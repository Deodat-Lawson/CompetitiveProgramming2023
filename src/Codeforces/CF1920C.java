package Codeforces;

import java.io.*;
import java.util.*;

public class CF1920C {

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
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
    }
    ArrayList<Integer> kVal = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        kVal.add(i);
      }
    }

    int count = 0;
    for (int i = 0; i < kVal.size(); i++) {
      int currK = kVal.get(i);
      int gcd = -1;

      for (int j = 0; j < n; j++) {

        int v = Math.abs(arr[j] - arr[j % currK]);
        if(v != 0){
          if(gcd == -1){
            gcd = v;
          }
          else{
            gcd = gcd(v, gcd);
          }
          if(gcd == 1){
            break;
          }
        }
      }

      if (gcd != 1) {
        count++;
      }

    }
    System.out.println(count);
  }

  public static int gcd(int b, int a) {
    if (b > a) {
      int temp = a;
      a = b;
      b = temp;
    }
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
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
