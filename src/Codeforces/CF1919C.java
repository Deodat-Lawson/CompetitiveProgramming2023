package Codeforces;

import java.io.*;
import java.util.*;

public class CF1919C {

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
    int ALVal = Integer.MAX_VALUE;
    int BLVal = Integer.MAX_VALUE;
    int count = 0;

    for (int i = 0; i < n; i++) {
      int curr = arr[i];
      if(ALVal >= BLVal){
        if(BLVal >= curr) {
          BLVal = curr;
        }
        else if(ALVal >= curr) {
          ALVal = curr;
        }
        else{
          BLVal = curr;
          count++;
        }
      }
      else {
        if (BLVal >= ALVal) {
          if (ALVal >= curr) {
            ALVal = curr;
          } else if (BLVal >= curr) {
            BLVal = curr;
          } else {
            ALVal = curr;
            count++;
          }
        }
      }
    }
    System.out.println(count);
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
