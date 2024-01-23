package Codeforces;

import java.io.*;
import java.util.*;

public class CF1839C {

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
    int[] allNum = new int[n];
    for (int i = 0; i < n; i++) {
      allNum[i] = nextInt();
    }
    if (allNum[n - 1] == 1) {
      System.out.println("NO");
      return;
    }
    ArrayList<Integer> seq = new ArrayList<>();
    for (int i = 0; i < n; i++) {

      for (int j = i; j < n; j++) {
        if (allNum[j] == 0) {
          seq.add(j - i);
          for (int k = i; k < j; k++) {
            seq.add(0);
          }
          i = j + 1;
        }
      }
    }
    System.out.println("YES");
    for (int i = seq.size() - 1; i >= 0; i--) {
      System.out.print(seq.get(i) + " ");
    }
    System.out.println();
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
