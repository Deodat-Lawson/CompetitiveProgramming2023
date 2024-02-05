package Codeforces;

import java.io.*;
import java.util.*;

public class CF1921F {

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
    int q = nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
    }
    int[][] dp = new int[n][n];

    //dp [i][j] is the prefix sum of the sequence ending at i with a difference of j
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(i < j){
          dp[i][j] = arr[i];
        }
        else {
          dp[i][j] = dp[i - j][j] + arr[i];
        }
      }
    }

    for (int i = 0; i < q; i++) {
      int s = nextInt() - 1;
      int d = nextInt();
      int k = nextInt();

      int end = s + (k - 1) * d;
      System.out.println(dp[end][d] - dp[s][d]);
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
