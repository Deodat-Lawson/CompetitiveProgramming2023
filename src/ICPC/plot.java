package ICPC;

import java.io.*;
import java.util.*;

public class plot {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    ArrayList<Long> curr = new ArrayList<>();
    int[] val = new int[n + 1];
    long[] ans = new long[n + 1];
    for (int i = n; i >= 0; i--) {
      val[i] = nextInt();
    }
    for (int i = 0; i <= n; i++) {
      //the specific index value
      long finalV = 0;
      for (int j = n; j >= 0; j--) {
        long power = (long)Math.pow(i, j);
        finalV += val[j] * power;
      }
      curr.add(finalV);
    }
    int ind = 0;
    while(!curr.isEmpty()){
      ans[ind] = curr.get(0);
      ind++;
      ArrayList<Long> newCurr = new ArrayList<>();
      for (int i = 0; i < curr.size() - 1; i++) {
        newCurr.add(curr.get(i + 1) - curr.get(i));
      }
      curr = newCurr;
    }

    for (int i = 0; i < n + 1; i++) {
      System.out.println(ans[i]);
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
