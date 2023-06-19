package Codeforces;

import java.io.*;
import java.util.*;

public class CF1820A {

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
    String a = nextLine();
    if(a.length() == 1){
      if(a.equals("^")){
        System.out.println(1);
      }
      else{
        System.out.println(2);
      }
      return;
    }
    
    a = "_" + a + "_";

    int count = 0;
    for (int i = 0; i < a.length() - 1; i++) {
      char curr = a.charAt(i);
      if(curr == '_'){
        if(a.charAt(i + 1)=='_'){
          count++;
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
