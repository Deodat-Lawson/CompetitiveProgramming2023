package Codeforces;

import java.io.*;
import java.util.*;

public class CF1805A {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException{
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve()throws IOException{
    int n = nextInt();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum ^= nextInt();
    }

    if(n%2 == 0){
      //if even then check if xor sum of ais
      if(sum == 0) {
        System.out.println(0);
      }
      else {
        System.out.println(-1);
      }
    }
    else{
      boolean flag = false;
      for (int i = 0; i <= 256; i++) {
        if((sum^i)  == 0){
          System.out.println(i);
          flag = true;
          break;
        }
      }
      if(!flag){
        System.out.println(-1);
      }

    }
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
