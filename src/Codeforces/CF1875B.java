package Codeforces;

import java.io.*;
import java.util.*;

public class CF1875B {

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
    int m = nextInt();
    int k = nextInt();
    ArrayList<Integer> J = new ArrayList<>();
    ArrayList<Integer> G = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      J.add(nextInt());
    }
    for (int i = 0; i < m; i++) {
      G.add(nextInt());
    }
    Collections.sort(J);
    Collections.sort(G);
    int loop = 200 + (k % 2);
    for (int i = 1; i <= loop; i++) {
      if(i%2 == 1) {
        int a = J.get(0);
        int b = G.get(G.size() - 1);
        if(b > a) {
          J.set(0, b);
          G.set(G.size() - 1, a);
          Collections.sort(J);
          Collections.sort(G);
        }
      }
      else{
        int a = J.get(J.size() - 1);
        int b = G.get(0);
        if(a > b) {
          J.set(J.size() - 1, b);
          G.set(0, a);
          Collections.sort(J);
          Collections.sort(G);
        }
      }
    }

    long sum = 0;
    for (int i = 0; i < J.size(); i++) {
      sum += J.get(i);
    }
    System.out.println(sum);
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
