package LeetCode;

import java.io.*;
import java.util.*;

public class kokoEatingBananas {

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

    int[] a = {805306368,805306368,805306368};
    minEatingSpeed(a, 100000000);
  }

  public static int minEatingSpeed(int[] piles, int h) {
    long left = 1;
    long right = Long.MAX_VALUE;
    long ans = Long.MAX_VALUE;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      long count = 0;

      for (int i = 0; i < piles.length; i++) {
        count += (long) Math.ceil((double) piles[i] / (double) mid);
      }

      if(count <= h){
        ans = Math.min(ans, mid);
        right = mid - 1;
      }
      else{
        left = mid + 1;
      }
    }
    return (int)ans;
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
