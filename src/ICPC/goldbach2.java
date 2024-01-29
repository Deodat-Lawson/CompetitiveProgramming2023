package ICPC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
public class goldbach2 {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    cleave();
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  static boolean[] cle = new boolean[32001];

  public static void solve() throws IOException {
    int n = nextInt();
    int count = 0;
    ArrayList<Pair> allP = new ArrayList<>();
    for (int i = 0; i <= n/2; i++) {
      if (!cle[i] && !cle[n - i]) {
        count++;
        allP.add(new Pair(i, n - i));
      }
    }
    System.out.println(n + " has " + count + " representation(s)");
    for (int i = 0; i < allP.size(); i++) {
      System.out.println(allP.get(i).a + "+" + allP.get(i).b);
    }
  }

  static class Pair {
    int a, b;
    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  static void cleave() {
    cle[0] = true;
    cle[1] = true;
    for (int i = 2; i < 32001; i++) {
      if (cle[i] == false) {
        for (int j = i * 2; j < 32001; j += i) {
          cle[j] = true;
        }
      }
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
