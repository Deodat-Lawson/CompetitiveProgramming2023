package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
public class CF1894C {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    DFS thisDFS = new DFS(n);

    int k = nextInt();


    for (int i = 0; i < n; i++) {
      int currIVal = i + 1;
      int newVal = nextInt();
      if (newVal > n) {
        continue;
      }
      int currdiff = newVal - currIVal;
      if (currdiff < 0) {
        currdiff *= -1;
      }

      if (currdiff == 0) {
        thisDFS.adjList[currIVal].add(1);
      } else {
        int find = n + 1 - currdiff;
        thisDFS.adjList[currIVal].add(find);
      }
    }
    thisDFS.dfs(1, 1);
    if (thisDFS.maxL >= k) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
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

  static class DFS {
    ArrayList<Integer>[] adjList;
    boolean[] visited;

    int maxL = -1;
    DFS(int n) {
      adjList = new ArrayList[n + 1];
      for (int i = 0; i < n + 1; i++) {
        adjList[i] = new ArrayList<>();
      }
      visited = new boolean[n + 1];
    }

    void dfs(int currNode, int currL) {
      maxL = Math.max(maxL, currL);
      for (int to : adjList[currNode]) {
        if (!visited[currNode]) {
          visited[to] = true;
          dfs(to, currL + 1);
          visited[to] = false;
        } else {
          maxL = Integer.MAX_VALUE;
          return;
        }
      }
    }

  }


}
