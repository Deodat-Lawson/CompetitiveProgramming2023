package Codeforces;

import java.io.*;
import java.util.*;

public class CF1917A {

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
    long product = 1;
    int pos = 0;
    int neg = 0;
    int zero = 0;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
      product *= arr[i];
      if(arr[i] > 0){
        pos++;
      } else if(arr[i] < 0){
        neg++;
      }
      else{
        zero++;
      }
    }
    if(zero > 0){
      System.out.println(0);
      return;
    }

    if(neg % 2 == 0){
      arr[0] = 0;
      System.out.println(1);
      System.out.println("1 0");
    }
    else{
      System.out.println(0);
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
