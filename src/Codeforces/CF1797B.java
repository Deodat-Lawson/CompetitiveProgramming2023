package Codeforces;

import java.io.*;
import java.util.*;

public class CF1797B {

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
    int k = nextInt();
    int[][] table = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        table[i][j] = nextInt();
      }
    }


    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        int curr = table[i][j];
        int oppo = table[n - i - 1][n - j - 1];
        if (curr != oppo) {
          count++;
        }
      }
    }

    //check the next diagonal
    for (int i = 0; i < n/2; i++) {
      int val = table[i][n - i - 1];
      int reverseVal = table[n - i -1][i];
      if(val!= reverseVal){
        count++;
      }
    }

    if (count > k) {
      System.out.println("NO");
      return;
    } else {
      if(n%2 != 0){
        System.out.println("YES");
        return;
      }
      if ((k - count) % 2 == 0) {
        System.out.println("YES");
        return;
      }
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

}
