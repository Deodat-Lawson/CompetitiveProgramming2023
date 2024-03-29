package LeetCode;

import java.io.*;
import java.util.*;

public class isSubsequence {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public boolean isSubsequence(String s, String t) {
    int firstIndexOfLastElement = 0;
    for(int i = 0; i < s.length(); i++){
      String a = s.substring(i, i+1);
      firstIndexOfLastElement = t.indexOf(a, firstIndexOfLastElement);
      if(firstIndexOfLastElement == -1){
        return false;
      }
      firstIndexOfLastElement++;

    }
    return true;
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
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
