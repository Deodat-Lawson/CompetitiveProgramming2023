package Codeforces;

import java.io.*;
import java.util.*;

public class CF1797C {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      int rSize = nextInt();
      int cSize = nextInt();

      System.out.println("? 1 1");
      System.out.flush();

      int k = nextInt();

      //Test coordinates (1, k+1) and (k+1, 1) if they exists

      int rCordVal = -1;
      if (k + 1 <= rSize) {
        System.out.println("? " + (k + 1) + " " + 1);
        rCordVal = nextInt();
      }

      int cCordVal = -1;
      if (k + 1 <= cSize) {
        System.out.println("? " + 1 + " " + (k + 1));
        cCordVal = nextInt();
      }


      if (rCordVal == -1) {
        System.out.println("! " + (cCordVal + 1) + " " + (k + 1));
        continue;
      }

      if (cCordVal == -1) {
        System.out.println("! " + (k + 1) + " " + (rCordVal + 1));
        continue;
      }

      if (cCordVal == rCordVal) {
        System.out.println("! " + (k + 1) + " " + (k + 1));
      } else if (cCordVal > rCordVal) {
        System.out.println("! " + (k + 1) + " " + (rCordVal + 1));
      }
      else{
        System.out.println("! " + (cCordVal + 1) + " " + (k + 1));
      }

      System.out.flush();
    }
  }

//  public static void solve() throws IOException {
//    int rSize = nextInt();
//    int cSize = nextInt();
//
//    System.out.println("? 1 1");
//    System.out.flush();
//
//    int k = nextInt();
//
//    //Test coordinates (1, k+1) and (k+1, 1) if they exists
//
//    int rCordVal = -1;
//    if (k + 1 <= rSize) {
//      System.out.println("? " + (k + 1) + " " + 1);
//      rCordVal = nextInt();
//    }
//
//    int cCordVal = -1;
//    if (k + 1 <= rSize) {
//      System.out.println("? " + 1 + " " + (k + 1));
//      cCordVal = nextInt();
//    }
//
//
//    if (rCordVal == -1) {
//      System.out.println("! " + (cCordVal + 1) + " " + (k + 1));
//      return;
//    }
//
//    if (cCordVal == -1) {
//      System.out.println("! " + (k + 1) + " " + (rCordVal + 1));
//      return;
//    }
//
//    if (cCordVal == rCordVal) {
//      System.out.println("! " + (k + 1) + " " + (k + 1));
//    } else if (cCordVal > rCordVal) {
//      System.out.println("! " + (k + 1) + " " + (rCordVal + 1));
//    }
//    else{
//      System.out.println("! " + (cCordVal + 1) + " " + (k + 1));
//    }
//
//    System.out.flush();

//
//  }

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
