package ICPC;

import java.io.*;
import java.util.*;

public class waterjournal {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int min = nextInt();
    int max = nextInt();
    HashSet<Integer> cont = new HashSet<>();
    for (int i = 0; i < n - 1; i++) {
      cont.add(nextInt());
    }

    if(!cont.contains(min) && !cont.contains(max)){
      System.out.println(-1);
      return;
    }
    if(!cont.contains(min)){
      System.out.println(min);
      return;
    }

    if(!cont.contains(max)){
      System.out.println(max);
      return;
    }

    for (int i = min; i <= max; i++) {
      System.out.println(i);
    }
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
