package LeetCode;

import java.io.*;
import java.util.*;

public class longestUploadedPrefixGood {

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
  }

  class LUPrefix {

    int[] next;
    public LUPrefix(int n) {
      next = new int[n + 2];

      for (int i = 0; i < next.length; i++) {
        next[i] = i;
      }
    }

    public void upload(int video) {
      next[video] = next[video + 1];

      int nextInd = 1;
      while(nextInd != next[nextInd]){
        nextInd = next[nextInd];
      }
      next[1] = nextInd;
    }


    public int longest() {
      return next[1] - 1;
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
