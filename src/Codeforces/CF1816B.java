package Codeforces;

import java.io.*;
import java.util.*;

public class CF1816B {

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

    int[][] table = new int[2][n];
    table[0][0] = 2*n;
    table[1][n-1] = 2*n - 1;
    boolean YIN = true;
    int min = 1;
    int max = 2*n - 2;
    for (int i = 1; i < n; i++) {
      if(YIN){
        table[0][i] = min;
        min++;
        table[1][i-1] = min;
        min++;
      }
      else{
        table[1][i-1] = max;
        max--;
        table[0][i] = max;
        max--;

      }
      YIN = !YIN;
    }

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(table[i][j]+" ");
      }
      System.out.println();
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
