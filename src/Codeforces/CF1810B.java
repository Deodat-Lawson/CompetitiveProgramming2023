package Codeforces;

import java.io.*;
import java.util.*;

public class CF1810B {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    int n = nextInt();
    if(n%2 == 0){
      System.out.println(-1);
      return;
    }
    Stack<Integer> rec = new Stack<>();
    while(n > 1){
      n/=2;
      if(n%2 == 0){
        rec.add(1);
        n++;
      }
      else{
        rec.add(2);
      }
    }
    System.out.println(rec.size());
    while(!rec.isEmpty()) {
      System.out.print(rec.pop()+" ");
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
