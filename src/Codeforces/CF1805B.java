package Codeforces;
import java.io.*;
import java.util.*;
public class CF1805B {
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
    int smallestElement = 200;
    String s = nextLine();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if(smallestElement > c){
        smallestElement = c;
      }
    }

    int lastIndexOfSmallest = s.lastIndexOf((char)smallestElement);
    String newS = "" + (char)smallestElement + s.substring(0,lastIndexOfSmallest) + s.substring(lastIndexOfSmallest + 1);
    System.out.println(newS);
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
