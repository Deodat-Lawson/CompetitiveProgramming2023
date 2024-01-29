package ICPC;

import java.io.*;
import java.util.*;

public class isyavowel {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    String n = nextLine();
    int yCount = 0;
    int vCount = 0;
    for (int i = 0; i < n.length(); i++) {
      char c = n.charAt(i);
      if(c == 'a' || c == 'e' || c == 'i' || c == 'o' ||c =='u'){
        vCount++;
      }
      else if(c == 'y'){
        yCount++;
      }
    }

    System.out.println("" + vCount + " " + (vCount + yCount));
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
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
