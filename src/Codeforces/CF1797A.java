package Codeforces;

import java.io.*;
import java.util.*;

public class CF1797A {

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

    int xL = nextInt();
    int uL = nextInt();

    int iniX = nextInt();
    int iniY = nextInt();
    int finalX = nextInt();
    int finalY = nextInt();

    System.out.println(Math.min(algo(iniX,iniY, xL, uL), algo(finalX,finalY, xL, uL)));
  }

  public static int algo(int x, int y, int sx, int sy){
    if(x == 1 && y == 1 || x == 1 && y == sy || x == sx && y == 1 || x == sx && y == sy){
      return 2;
    }
    else if(x == 1 || x == sx || y == 1|| y == sy){
      return 3;
    }
    else{
      return 4;
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
