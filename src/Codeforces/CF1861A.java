package Codeforces;

import java.io.*;
import java.util.*;

public class CF1861A {

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
    String a = nextLine();
    int threeIndex = -1;
    int sevenIndex = -1;
    for (int i = 0; i < a.length(); i++) {
      if(a.charAt(i) == '3'){
        threeIndex = i;
      }
      else if(a.charAt(i) == '7'){
        sevenIndex = i;
      }
    }

    if(threeIndex > sevenIndex){
      System.out.println("73");
    }
    else{
      System.out.println("37");
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
