package Codeforces;
import java.io.*;
import java.util.*;

public class CF1814OG {

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

    if(a == 0 && b == 0){
      System.out.println(0);
      return;
    }
    long right = Math.max(a,b);
    long left = 1;
    long minStep = Integer.MAX_VALUE;

    while(left <= right){
      long mid = (right + left)/2;

      long currStep = mid - 1 + (long) Math.ceil((double)a/mid) + (long) Math.ceil((double)b/mid);
      if(currStep < minStep){
        minStep = currStep;
        right = mid - 1;
      }
      else{
        left = mid + 1;
      }

    }

    System.out.println(minStep);
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