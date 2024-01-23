package Codeforces;


import java.io.*;
import java.util.*;

public class CF609E {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  static ArrayList<Edge>[] adjList;
  static boolean[] visited;
  static ArrayList<Edge> MSTEdge = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int e = nextInt();
    PriorityQueue<Edge> allEdges = new PriorityQueue<>();
    Edge[] indexMap = new Edge[e];
    long[] ans = new long[e];

    HashSet<Integer> MST = new HashSet<>();

    for (int i = 0; i < e; i++) {
      int n1 = nextInt() - 1;
      int n2 = nextInt() - 1;
      long weight = nextLong();
      Edge curr = new Edge(n1, n2, weight, i);
      indexMap[i] = curr;
      allEdges.add(curr);
    }

    DSU thisDSU = new DSU(n);
    while (!allEdges.isEmpty()) {
      Edge currentEdge = allEdges.poll();
      int a = currentEdge.par;
      int b = currentEdge.child;
      if (!thisDSU.equal(a, b)) {
        MST.add(currentEdge.id);
        thisDSU.union(a, b);
      }
    }

    MSTEdge = new ArrayList<>();
    adjList = new ArrayList[n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      adjList[i] = new ArrayList<>();
    }
    for (int a : MST
    ) {
      Edge thisE = indexMap[a];
      adjList[thisE.par].add(thisE);
      adjList[thisE.child].add(thisE);
    }

    dfsSort(0);

    long mstWeight = 0;
    for (Edge thisE : MSTEdge
    ) {
      mstWeight += thisE.weight;
    }
    binaryLift thisMst = new binaryLift(n, MSTEdge);

    for (int i = 0; i < e; i++) {
      if (MST.contains(i)) {
        ans[i] = mstWeight;
      } else {
        Edge thisE = indexMap[i];
        int n1 = thisE.par;
        int n2 = thisE.child;
        long w = thisE.weight;
        long val = mstWeight + w - thisMst.findMaxEdge(n1, n2);
        ans[i] = val;
      }
    }

    for (int i = 0; i < ans.length; i++) {
      System.out.println(ans[i]);
    }


  }


  static void dfsSort(int curr) {
    visited[curr] = true;
    for (Edge childEdge : adjList[curr]
    ) {
      if (curr != childEdge.par) {
        int temp = childEdge.par;
        childEdge.par = childEdge.child;
        childEdge.child = temp;
      }

      if (visited[childEdge.child]) {
        continue;
      }
      MSTEdge.add(new Edge(childEdge.par, childEdge.child, childEdge.weight, childEdge.id));
      dfsSort(childEdge.child);
    }
  }

  static class binaryLift {
    int[][] dp;
    int[] depth;
    long[][] maxEdgeWeight;
    ArrayList<Edge>[] children;

    binaryLift(int n, ArrayList<Edge> allEdges) {
      int log = (int) (Math.log(n) / Math.log(2)) + 1;
      depth = new int[n];
      dp = new int[n][log];
      maxEdgeWeight = new long[n][log];
      for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[0].length; j++) {
          dp[i][j] = -1;
          maxEdgeWeight[i][j] = -1;
        }
      }

      children = new ArrayList[n];
      for (int i = 0; i < n; i++) {
        children[i] = new ArrayList<>();
      }
      for (int i = 0; i < allEdges.size(); i++) {
        Edge thisE = allEdges.get(i);
        children[thisE.par].add(thisE);
        dp[thisE.child][0] = thisE.par;
        maxEdgeWeight[thisE.child][0] = thisE.weight;
      }
      dfs(0, 1);
    }

    void dfs(int n, int d) {
      depth[n] = d;

      for (Edge thisE : children[n]
      ) {
        for (int i = 1; i < dp[0].length; i++) {
          int curr = thisE.child;
          int prevPar = dp[curr][i - 1];
          if (prevPar == -1) {
            break;
          }
          dp[curr][i] = dp[prevPar][i - 1];
          maxEdgeWeight[curr][i] = Math.max(maxEdgeWeight[curr][i - 1], maxEdgeWeight[prevPar][i - 1]);
        }
        dfs(thisE.child, d + 1);
      }
    }

    int kthAncestor(int n, int k) {
      int curr = n;
      for (int i = 0; k > 0; i++) {
        if (k % 2 == 1) {
          curr = dp[curr][i];
        }
        if (curr == -1) {
          return -1;
        }
        k /= 2;
      }
      return curr;
    }

    int lca(int a, int b) {
      if (depth[b] > depth[a]) {
        int temp = a;
        a = b;
        b = temp;
      }

      int k = depth[a] - depth[b];
      int aAncestor = kthAncestor(a, k);

      if (aAncestor == b) {
        return aAncestor;
      }

      for (int i = dp[0].length - 1; i >= 0; i--) {
        if (dp[aAncestor][i] != dp[b][i]) {
          aAncestor = dp[aAncestor][i];
          b = dp[b][i];
        }
      }
      return dp[aAncestor][0];
    }

    long kthMaxEdge(int n, int k) {
      int curr = n;
      long maxVal = 0;
      for (int i = 0; k > 0; i++) {
        if (k % 2 == 1) {
          maxVal = Math.max(maxVal, maxEdgeWeight[curr][i]);
          curr = dp[curr][i];
        }
        if (curr == -1) {
          return -1;
        }
        k /= 2;
      }
      return maxVal;
    }

    long findMaxEdge(int a, int b) {
      int lca = lca(a, b);
      int aD = depth[a] - depth[lca];
      int bD = depth[b] - depth[lca];
      return Math.max(kthMaxEdge(a, aD), kthMaxEdge(b, bD));
    }


  }


  static class Edge implements Comparable<Edge> {
    int par, child;
    long weight;
    int id;

    Edge(int n1, int n2, long weight, int id) {
      this.par = n1;
      this.child = n2;
      this.weight = weight;
      this.id = id;
    }

    public int compareTo(Edge o1) {
      return Long.compare(weight, o1.weight);
    }
  }

  static class DSU {
    int[] par;
    int[] size;

    DSU(int n) {
      par = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        par[i] = i;
        size[i] = 1;
      }
    }

    int find(int p) {
      int v = p;
      while (v != par[v]) {
        v = par[v];
      }
      par[p] = v;
      return v;
    }

    void union(int p, int q) {
      if (find(p) != find(q)) {
        if (size[q] > size[p]) {
          int temp = p;
          p = q;
          q = temp;
        }

        par[find(q)] = find(p);
        size[p] += size[q];
      }
    }

    boolean equal(int a, int b) {
      return find(a) == find(b);
    }

  }


  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(f.readLine().trim());
    }
    return tok.nextToken();
  }

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char nextCharacter() throws IOException {
    return next().charAt(0);
  }

  static String nextLine() throws IOException {
    return f.readLine().trim();
  }

}
