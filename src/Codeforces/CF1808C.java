package Codeforces;

import java.io.*;
import java.util.*;

public class CF1808C {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    long a = nextLong();
    long b = nextLong();

    if (a == b) {
      System.out.println(a);
      return;
    }

    String aToStr = "" + a;
    String bToStr = "" + b;

    if (bToStr.length() > aToStr.length()) {
      for (int i = 0; i < aToStr.length(); i++) {
        System.out.print(0);
      }
      System.out.println();
      return;
    }

    int indexDiff = 0;
    while (aToStr.charAt(indexDiff) == bToStr.charAt(indexDiff)) {
      indexDiff++;
    }

    int maxDigit = -1;
    int smallestDigit = 10;
    //case indexDiff is not 0;
    String beginning = aToStr.substring(0, indexDiff);
    for (int i = 0; i < beginning.length(); i++) {
      int thisD = Integer.parseInt(aToStr.substring(i, i + 1));
      maxDigit = Math.max(maxDigit, thisD);
      smallestDigit = Math.min(smallestDigit, thisD);
    }

    String remainingADigits = aToStr.substring(indexDiff);
    String remainingBDigits = bToStr.substring(indexDiff);

    int smallA = Integer.parseInt(remainingADigits.substring(0, 1));
    int smallB = Integer.parseInt(remainingBDigits.substring(0, 1));

    ArrayList<String> allPossible = new ArrayList<>();

    for (int i = smallA + 1; i < smallB - 1; i++) {
      if (i >= smallestDigit && i <= maxDigit) {
        System.out.print(beginning);
        for (int j = 0; j < remainingBDigits.length(); j++) {
          System.out.print(i);
        }
        System.out.println();
        return;
      }

      String ending = "";
      for (int j = 0; j < remainingBDigits.length(); j++) {
        ending+= i;
      }
      allPossible.add(beginning + ending);
    }

    //smallest starting digit
    boolean frontDigitIsAtMax = false;
    for (int i = 0; i < remainingADigits.length(); i++) {
      int currD = Integer.parseInt(remainingADigits.substring(i,i+1));

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
