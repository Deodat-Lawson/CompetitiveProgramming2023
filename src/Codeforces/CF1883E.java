package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF1883E {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve()throws IOException{
    int n = nextInt();
    long count = 0;
    long[] arr = new long[n];
    arr[0] = nextLong();
    for (int i = 1; i < n; i++) {
      arr[i] = nextLong();
      if(arr[i] < arr[i - 1]){
        long a = (long)Math.ceil((double)arr[i-1]/(double)arr[i]);
        long l = (long)Math.ceil(Math.log(a)/Math.log(2));
        arr[i] *= (long) Math.pow(2, l);
        count += l;
      }
    }
    System.out.println(count);
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
