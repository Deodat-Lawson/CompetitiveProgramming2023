package ICPC;

import java.io.*;
import java.util.*;

public class magnesiumsupplementation {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    long n = nextLong();
    long k = nextLong();
    long p = nextLong();
    ArrayList<Long> ans = new ArrayList<>();
    for (long i = 1; i <= Math.min(Math.sqrt(n), k); i++) {
      if(n % i == 0){
        if(n/i <= p){
          ans.add(i);
        }
        long other = n/i;
        if(i == other || other > k){
          continue;
        }
        if(n/other <= p){
          ans.add(other);
        }
      }
    }
    Collections.sort(ans);
    System.out.println(ans.size());
    for (int i = 0; i < ans.size(); i++) {
      System.out.println(ans.get(i));
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
