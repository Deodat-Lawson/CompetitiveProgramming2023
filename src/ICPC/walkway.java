package ICPC;

import java.io.*;
import java.util.*;

public class walkway {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    while (true) {
      int n = nextInt();
      if (n == 0) {
        return;
      }
      solve(n);
    }
  }


  static double minVal;
  static HashMap<Integer, HashSet<Stone>> map;
  static double[] visited;
  static int end;
  static int start;

  static PriorityQueue<StonePair> pq ;

  public static void solve(int n) throws IOException {
    //Todo: write your implementation
    map = new HashMap<>();
    minVal = Double.MAX_VALUE;
    visited = new double[1001];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = Double.MAX_VALUE;
    }

    for (int i = 0; i < n; i++) {
      int a = nextInt();
      int b = nextInt();
      int h = nextInt();
      double cost = (double) ((a + b) * h) /2;
      HashSet<Stone> thisHashSet = map.getOrDefault(a, new HashSet<>());
      thisHashSet.add(new Stone(a, b, cost));
      map.put(a, thisHashSet);

      HashSet<Stone> thisHashSet2 = map.getOrDefault(b, new HashSet<>());
      thisHashSet2.add(new Stone(a, b, cost));
      map.put(b, thisHashSet2);
    }

    start = nextInt();
    end = nextInt();

    pq = new PriorityQueue<>();
    pq.add(new StonePair(start,0));

    while(!pq.isEmpty()) {
      StonePair current = pq.poll();

      if(current.val == end){
        System.out.println(current.cost * 0.02);
        return;
      }
      if(visited[current.val] != Double.MAX_VALUE){
        continue;
      }
      visited[current.val] = current.cost;
      HashSet<Stone> allConnected = map.getOrDefault(current.val, new HashSet<>());
      for (Stone s: allConnected
           ) {
        int b = s.b;
        if(s.b == current.val){
          b = s.a;
        }
        if(visited[b] == Double.MAX_VALUE){
          pq.add(new StonePair(b, current.cost + s.h));
        }
      }

    }

  }

  static class StonePair implements Comparable<StonePair> {
    int val;
    double cost;
    StonePair(int val, double cost) {
      this.val = val;
      this.cost = cost;
    }
    @Override
    public int compareTo(StonePair o) {
      return Double.compare(cost, o.cost);
    }
  }

  static class Stone {
    int a, b;
    double h;

    Stone(int a, int b, double h) {
      this.a = a;
      this.b = b;
      this.h = h;
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
