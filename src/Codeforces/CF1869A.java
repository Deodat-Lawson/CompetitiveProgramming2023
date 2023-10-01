package Codeforces;

import java.io.*;
import java.util.*;

public class CF1869A {

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
    for (int i = 0; i < n; i++) {
      nextInt();
    }
    if(n % 2 == 0){
      System.out.println(2);
      System.out.println(1 + " " + n);
      System.out.println(1 + " " + n);
    }
    else{
      System.out.println(4);
      System.out.println(1 + " " + (n-1));
      System.out.println(1 + " " + (n-1));
      System.out.println((n-1) + " " + (n));
      System.out.println((n-1) + " " + (n));
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
