package Codeforces;

import java.io.*;
import java.util.*;

public class CF1920D {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  static int lastElement[];
  static long size[];

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    int q = nextInt();
    long currentSize = 0;
    lastElement = new int[n];
    size = new long[n];

    for (int i = 0; i < n; i++) {
      int operation = nextInt();
      int value = nextInt();
      if (operation == 1) {
        if (currentSize != Long.MAX_VALUE) {
          currentSize++;
        }
        lastElement[i] = value;
        size[i] = currentSize;
      } else {
        if (currentSize * (long) (value + 1) >= currentSize) {
          currentSize = currentSize * (long) (value + 1);
        } else {
          currentSize = Long.MAX_VALUE;
        }
        lastElement[i] = lastElement[i - 1];
        size[i] = currentSize;
      }
    }
    for (int i = 0; i < q; i++) {
      long k = nextLong();
      System.out.print(findK(k) + " ");
    }
    System.out.println();
  }

  static int findK(long k) {
    int indexLessThan = 0;

    int left = 0;
    int right = size.length;
    while (left <= right) {
      int mid = (left + right) / 2;
      long val = size[mid];
      if (val == k) {
        return lastElement[mid];
      } else if (val > k) {
        right = mid - 1;
      } else {
        indexLessThan = Math.max(indexLessThan, mid);
        left = mid + 1;
      }
    }

    long newK = k % size[indexLessThan];
    if (newK == 0) {
      return lastElement[indexLessThan];
    }
    return findK(newK);

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
