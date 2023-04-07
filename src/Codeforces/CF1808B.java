package Codeforces;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CF1808B {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    HashMap<Integer, ArrayList<Integer>> allMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ArrayList<Integer> thisL = allMap.getOrDefault(j, new ArrayList<Integer>());
        thisL.add(nextInt());
        allMap.put(j,thisL);
      }
    }


    long sum = 0;
    for (int i = 0; i < m; i++) {
      ArrayList<Integer> thisL = allMap.getOrDefault(i, new ArrayList<Integer>());
      Collections.sort(thisL);
      for (int j = 0; j < n; j++) {
        int oppositeIndex = thisL.size() - j - 1;
        if(oppositeIndex <= j){
          break;
        }
        sum += (long)(oppositeIndex - j) * (long) (thisL.get(oppositeIndex) - thisL.get(j));
      }
    }

    System.out.println(sum);
    
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
