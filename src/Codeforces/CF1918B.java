package Codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class CF1918B {


  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve()throws IOException{
    //Todo: write your implementation
    int n = nextInt();
    Pair[] allP = new Pair[n];
    for (int i = 0; i < n; i++) {
      Pair p = new Pair();
      p.a = nextInt();
      allP[i]= p;
    }
    for (int i = 0; i < n; i++) {
      Pair p = allP[i];
      p.b = nextInt();
      allP[i] = p;
    }
    Arrays.sort(allP);
    for (int i = 0; i < allP.length; i++) {
      System.out.print(allP[i].a+" ");
    }
    System.out.println();
    for (int i = 0; i < allP.length; i++) {
      System.out.print(allP[i].b+" ");
    }
    System.out.println();
  }


  static class Pair implements Comparable<Pair>{
    int a, b;

    @Override
    public int compareTo(Pair o) {
      return Integer.compare(a + b, o.a + o.b);
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
