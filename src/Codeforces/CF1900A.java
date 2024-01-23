package Codeforces;

import java.io.*;
import java.util.*;

public class CF1900A {

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
    int l = nextInt();
    String s = nextLine();
    int totalC = 0;
    int consecC = 0;
    for (int i = 0; i < l; i++) {
      char c = s.charAt(i);
      if(c == '.') {
        consecC++;
        totalC++;
      }
      else{
        if(consecC >= 3){
          System.out.println(2);
          return;
        }
        consecC = 0;
      }
    }
    if(consecC >= 3){
      System.out.println(2);
      return;
    }
    System.out.println(totalC);
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
