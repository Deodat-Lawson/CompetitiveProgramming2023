package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1669G {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int m = nextInt();
    char[][] table = new char[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        table[i][j] = nextCharacter();
      }
    }

  }

  static void fall(char[][] table){
    for (int i = 0; i < table.length; i++) {
      for (int j = 0; j < table[0].length; j++) {
        char curr = table[i][j];
        


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
