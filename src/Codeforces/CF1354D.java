//package Codeforces;
//
//import java.io.*;
//import java.util.*;
//
//public class CF1354D {
//
//  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//  static StringTokenizer tok;
//
//  public static void main(String[] args) throws IOException {
//    int t = nextInt();
//    for (int i = 0; i < t; i++) {
//      solve();
//    }
//  }
//
//  public static void solve() throws IOException {
//    //Todo: write your implementation
//    int n = nextInt();
//    int q = nextInt();
//
//    int[] numCounter = new int[n + 1];
//    for (int i = 0; i < n; i++) {
//      int a = nextInt();
//      numCounter[a]++;
//    }
//
//
//
//
//  }
//
//  class SegTree{
//
//  }
//
//  static String next() throws IOException {
//    while (tok == null || !tok.hasMoreTokens()) {
//      tok = new StringTokenizer(f.readLine().trim());
//    }
//    return tok.nextToken();
//  }
//
//  static long nextLong() throws IOException {
//    return Long.parseLong(next());
//  }
//
//  static int nextInt() throws IOException {
//    return Integer.parseInt(next());
//  }
//
//  static double nextDouble() throws IOException {
//    return Double.parseDouble(next());
//  }
//
//  static char nextCharacter() throws IOException {
//    return next().charAt(0);
//  }
//
//  static String nextLine() throws IOException {
//    return f.readLine().trim();
//  }
//
//}
