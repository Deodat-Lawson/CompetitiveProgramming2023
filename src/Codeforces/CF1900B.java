package Codeforces;

import java.io.*;
import java.util.*;

public class CF1900B {

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
    int a = nextInt();
    int b = nextInt();
    int c = nextInt();
    int aAns = calculated(a, b, c);
    int bAns = calculated(b, a, c);
    int cAns = calculated(c, b, a);

    System.out.println(aAns + " " + bAns + " " + cAns);
  }
  static int calculated(int a, int b, int c){
    int BCDiff = Math.abs(c - b);
    if(BCDiff % 2 == 0){
      if(a != 0 || (b != 0 && c != 0)) {
        return 1;
      }
    }
    return 0;
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
