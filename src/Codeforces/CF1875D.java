package Codeforces;

import java.io.*;
import java.util.*;

public class CF1875D {

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
    long[] memo = new long[n + 1];
    int[] arr = new int[n + 1];
    for (int i = 0; i < n; i++) {
      int thisInt = nextInt();
      if(thisInt > n){
        thisInt = n;
      }
      arr[thisInt]++;
    }
    int MEX = 0;
    for (int i = 0; i < n; i++) {
      if(arr[i] == 0) {
        MEX = i;
        break;
      }
    }

    if(MEX == 0){
      System.out.println(0);
      return;
    }

    for (int i = 1; i < n; i++) {
      memo[i] = Long.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        //our current MEX is i, we want to cut j
        memo[i] = Math.min(memo[i], (long) (arr[j] - 1) * i + memo[j] + j);
      }
      if(i == MEX){
        System.out.println(memo[i]);
        return;
      }
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
