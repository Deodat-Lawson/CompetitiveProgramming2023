package ICPC;

import java.io.*;
import java.util.*;

public class missingnumbers {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int count = 1;
    boolean flag = true;
    for (int i = 0; i < n; i++) {
      int current = nextInt();
      while (current > count){
        flag = false;
        System.out.println(count);
        count++;
      }
      count++;
    }
    if(flag) {
      System.out.println("good job");
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
