package Codeforces;

import java.io.*;
import java.util.*;

public class CF1920A {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    int n = nextInt();
    int lowerBound = 0;
    int upperBound = Integer.MAX_VALUE;
    HashSet<Integer> cannotBe = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int id = nextInt();
      int val = nextInt();
      if(id == 1){
        lowerBound = Math.max(lowerBound, val);
      }
      else if(id == 2){
        upperBound = Math.min(upperBound, val);
      }
      else{
        cannotBe.add(val);
      }
    }

    int rem = 0;
    for (int i: cannotBe
         ) {
      if(i >= lowerBound && i <= upperBound){
        rem++;
      }
    }

    System.out.println(Math.max(upperBound - lowerBound + 1 - rem, 0));
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
