package Codeforces;

import java.io.*;
import java.util.*;

public class CF1843D {
  static long[] child;
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
    int v = nextInt();
    ArrayList<Integer>[] adjList = new ArrayList[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new ArrayList<>();
    }
    for (int i = 0; i < v - 1; i++) {
      int a = nextInt() - 1;
      int b = nextInt() - 1;
      adjList[a].add(b);
      adjList[b].add(a);
    }
    child = new long[v];
    upDateChild(0,-1, adjList);
    int q = nextInt();
    for (int i = 0; i < q; i++) {
      int a = nextInt() - 1;
      int b = nextInt() - 1;

      long getA = child[a];
      long getB = child[b];

      System.out.println(getB * getA);
    }


  }

  static long upDateChild(int currV, int par, ArrayList<Integer>[] arrL) {
    ArrayList<Integer> thisList = arrL[currV];
    long sum = 0;
    for (int i = 0; i < thisList.size(); i++) {
      int a = thisList.get(i);
      if (a != par) {
        sum += upDateChild(a, currV, arrL);
      }
    }
    if (sum == 0) {
      sum = 1;
    }
    child[currV] = sum;
    return sum;
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
