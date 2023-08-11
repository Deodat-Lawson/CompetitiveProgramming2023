package Codeforces;

import java.io.*;
import java.util.*;

public class CF1843A {

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
    int n = nextInt();
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      arr.add(nextInt());
    }
    Collections.sort(arr);

    int mid = n/2;
    int sumL = 0;
    int sumR = 0;
    for (int i = 0; i < mid; i++) {
      sumL += arr.get(i);
      sumR += arr.get(n - i - 1);
    }
    System.out.println(sumR - sumL);
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
