package Codeforces;

import java.io.*;
import java.util.*;

public class CF1909C {

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
    ArrayList<Integer> left = new ArrayList<>();
    TreeMap<Integer, Integer> rightMap = new TreeMap<>();
    ArrayList<Integer> weight = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      left.add(nextInt());
    }
    for (int i = 0; i < n; i++) {
      int val = nextInt();
      rightMap.put(val, rightMap.getOrDefault(val, 0) + 1);
    }
    for (int i = 0; i < n; i++) {
      weight.add(nextInt());
    }
    Collections.sort(left);
    Collections.reverse(left);
    Collections.sort(weight);

    ArrayList<Integer> allSizes = new ArrayList<>();
    for (int i = 0; i < left.size(); i++) {
      int current = left.get(i);
      int val = rightMap.ceilingKey(current);
      allSizes.add(val - current);
      if (rightMap.get(val) == 1) {
        rightMap.remove(val);
      } else {
        rightMap.put(val, rightMap.get(val) - 1);
      }
    }

    Collections.sort(allSizes);
    Collections.reverse(allSizes);
    long sum = 0;
    for (int i = 0; i < allSizes.size(); i++) {
      int s = allSizes.get(i);
      int w = weight.get(i);
      sum += ((long) s * w);
    }
    System.out.println(sum);
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
