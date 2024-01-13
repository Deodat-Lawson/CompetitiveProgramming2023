package LeetCode;

import java.io.*;
import java.util.*;

public class longestUploadedPrefix {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = 1;
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    LUPrefix thisP = new LUPrefix(4);
    thisP.upload(3);
    thisP.upload(1);
    thisP.upload(2);
    System.out.println(thisP.longest);

  }

  static class LUPrefix {

    int[] prev;
    int[] next;
    int longest = 0;
    public LUPrefix(int n) {
      prev = new int[n + 2];
      next = new int[n + 2];

      for (int i = 0; i < prev.length; i++) {
        prev[i] = i;
        next[i] = i;
      }
    }

    public void upload(int video) {
      prev[video] = prev[video - 1];
      next[video] = next[video + 1];

      int length = 0;
      int nextInd = video;
      while(nextInd != next[nextInd]){
        nextInd = next[nextInd];
      }
      next[video] = nextInd;
      length += (nextInd - video);

      int prevInd = video;
      while(prevInd != prev[prevInd]){
        prevInd = prev[prevInd];
      }
      prev[video] = prevInd;
      length += (video - prevInd);

      length--;

      longest = Math.max(longest, length);
    }


    public int longest() {
      return longest;
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
