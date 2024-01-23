//package Codeforces;
//
//import java.io.*;
//import java.util.*;
//
//public class CF1917D {
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
//  static int[] p;
//  static int[] q;
//  static int mod = 998244353;
//
//  public static void solve() throws IOException {
//    //Todo: write your implementation
//    int n = nextInt();
//    int k = nextInt();
//    p = new int[n];
//    q = new int[k];
//
//    for (int i = 0; i < n; i++) {
//      p[i] = nextInt();
//    }
//    for (int i = 0; i < k; i++) {
//      q[i] = nextInt();
//    }
//
//    int[] dp = new int[n];
//    Stack<Pair> stk = new Stack<>();
//    for (int i = 0; i < n; i++) {
//      while(!stk.isEmpty()){
//        Pair thisP = stk.peek();
//        if(thisP.value > )
//      }
//    }
//  }
//
//  static class Pair {
//    int value, count;
//
//    Pair(int value, int count) {
//      this.value = value;
//      this.count = count;
//    }
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
