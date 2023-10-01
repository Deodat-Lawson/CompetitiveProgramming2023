package Codeforces;

import java.io.*;
import java.util.*;

public class CF1869B {

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
    int n = nextInt();
    int k = nextInt();
    int a = nextInt();
    int b = nextInt();

    city[] allCities = new city[n + 1];

    for (int i = 1; i <= n; i++) {
      allCities[i] = new city(nextLong(), nextLong());
    }

    city from = allCities[a];
    city to = allCities[b];
    long directDist = Math.abs(to.y - from.y) + Math.abs(to.x - from.x);

    if(k == 0){
      System.out.println(directDist);
      return;
    }

    if(a == b){
      System.out.println(0);
      return;
    }


    long distFromToMC = 0;
    long distToToMC = 0;
    if(a > k){
      distFromToMC = Long.MAX_VALUE;
      for (int i = 1; i <= k; i++) {
        long currDist = Math.abs(allCities[i].x - from.x) + Math.abs(allCities[i].y - from.y);
        distFromToMC = Math.min(distFromToMC, currDist);
      }
    }

    if(b > k){
      distToToMC = Long.MAX_VALUE;
      for (int i = 1; i <= k; i++) {
        long currDist = Math.abs(allCities[i].x - to.x) + Math.abs(allCities[i].y - to.y);
        distToToMC = Math.min(distToToMC, currDist);
      }
    }

    System.out.println(Math.min(distFromToMC + distToToMC, directDist));


  }


  static class city{
    long x, y;
    city(long x, long y){
      this.x = x;
      this.y = y;
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
