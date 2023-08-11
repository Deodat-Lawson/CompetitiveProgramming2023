package Codeforces;

import java.io.*;
import java.util.*;

public class CF1843B {

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
    long sum = 0;
    int count = 0;
    int prev = 0;
    for (int i = 0; i < n; i++) {

      int curr = nextInt();
      if(curr == 0){
        continue;
      }
      long mult = (long)curr * prev;
      if(curr < 0 && prev >= 0){
        count++;
      }
      sum += Math.abs(curr);
      prev = curr;
    }

    System.out.println(sum + " " + count);
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
