package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class CF1883C {
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
    int k = nextInt();
    int[] fork4 = new int[n];

    int minDiv = Integer.MAX_VALUE;

    boolean flag = false;
    for (int i = 0; i < n; i++) {
      int curr = nextInt();
      fork4[i] = curr;
      minDiv = Math.min(minDiv, (k - curr % k));
      if(curr % k == 0 && !flag){
        System.out.println(0);
        flag = true;
      }
    }
    if(flag){
      return;
    }

    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int curr = fork4[i];
      res.add(curr % 2);
    }
    Collections.sort(res);
    int s = res.get(0) + res.get(1);

    if(k == 4){
      System.out.println(Math.min(s, minDiv));
    }
    else{
      System.out.println(minDiv);
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
