package Codeforces;

import java.io.*;
import java.util.*;

public class CF1917C {

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
    int k = nextInt();
    int d = nextInt();
    int[] originalArray = new int[n];
    for (int i = 0; i < n; i++) {
      originalArray[i] = nextInt();
    }
    int[] kChange = new int[k];
    for (int i = 0; i < k; i++) {
      kChange[i] = nextInt();
    }
    int max = 0;
    //calculate total sum if set to 0 after the ith move
    for (int i = 0; i < Math.min(2 * n + 1,d); i++) {
      int currentCount = 0;
      for (int j = 0; j < n; j++) {
        if(j == originalArray[j] - 1) {
          currentCount++;
        }
      }
      max = Math.max(max, currentCount + (d - i - 1)/2);
      for (int j = 0; j < kChange[i%k]; j++) {
        originalArray[j]++;
      }
    }
    System.out.println(max);
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
