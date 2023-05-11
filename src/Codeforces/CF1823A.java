package Codeforces;

import java.io.*;
import java.util.*;

public class CF1823A {

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
    int a = nextInt();
    int count = nextInt();

    for (int i = 0; i < a; i++) {
      int l = a - i;
      int sum = 0;
      if(l > 1){
        sum+= ((l)*(l-1))/2;
      }
      if(i > 1){
        sum+= ((i)*(i-1))/2;
      }

      if(sum == count){
        System.out.println("YES");
        for (int j = 0; j < i; j++) {
          System.out.print("-1 ");
        }
        for (int j = 0; j < l; j++) {
          System.out.print("1 ");
        }
        System.out.println();
        return;
      }
    }

    System.out.println("NO");

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
