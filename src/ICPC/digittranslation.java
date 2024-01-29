package ICPC;

import java.io.*;
import java.util.*;

public class digittranslation {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    String s = nextLine();
    int count = 1;
    for (int i = 0; i + 10 < s.length(); i++) {
      String sub = s.substring(i, i + 10);
      if(sub.equals("fiveightwo") || sub.equals("nineightwo")){
        s = s.substring(0, i) + "5ight2" + s.substring(i + 10);
      }
    }

    for (int i = 0; i + 9 < s.length(); i++) {
      String sub = s.substring(i, i + 9);

      if(sub.equals("eighthree")){
        s = s.substring(0,i) + "eigh3" + s.substring(i + 9);
      }
      if(sub.equals("threeight")){
        s = s.substring(0, i) + "3ight" + s.substring(i + 9);
        count*=2;
      }
    }

    for (int i = 0; i + 5 < s.length(); i++) {
      String sub = s.substring(i, i + 5);
      if(sub.equals("eight")){
        s = s.substring(0, i) + "3ight" + s.substring(i + 9);
        count*=2;
      }
    }

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
