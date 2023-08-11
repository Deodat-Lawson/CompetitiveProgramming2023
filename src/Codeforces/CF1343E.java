package Codeforces;

import java.io.*;
import java.util.*;

public class CF1343E {

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
    int m = nextInt();
    ArrayList<Integer> update = new ArrayList<>();
    ArrayList<CF1843ERange> allRange = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int l = nextInt();
      int r = nextInt();
      allRange.add(new CF1843ERange(l, r));
    }
    int minSat = Integer.MAX_VALUE;
    int q = nextInt();
    for (int i = 0; i < q; i++) {
      update.add(nextInt());
    }

    int left = 0;
    int right = q;
    while (left <= right){
      int mid = (left + right)/2;
      int[] psa = new int[n + 1];
      for (int i = 0; i < mid; i++) {
        psa[update.get(i)] = 1;
      }

      for (int i = 1; i < n + 1; i++) {
        psa[i] = psa[i] + psa[i-1];
      }

      boolean flag = false;
      for (int i = 0; i < allRange.size(); i++) {
        CF1843ERange thisR = allRange.get(i);
        int ones = psa[thisR.r] - psa[thisR.l - 1];
        int zero = (thisR.r - thisR.l + 1) - ones;
        if(ones > zero){
          flag = true;
          break;
        }
      }

      if(flag){
        right = mid - 1;
        minSat = Math.min(minSat, mid);
      }
      else{
        left = mid + 1;
      }
    }

    if(minSat == Integer.MAX_VALUE){
      System.out.println("-1");
      return;
    }
    System.out.println(minSat);

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


class CF1843ERange{
  int l, r;
  CF1843ERange(int l, int r){
    this.l = l;
    this.r = r;
  }
}
