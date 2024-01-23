package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF1883B {
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
    int k = nextInt();

    int[] numCount = new int[26];
    String line = nextLine();
    for (int i = 0; i < line.length(); i++) {
      char curr = line.charAt(i);
      numCount[curr - 'a']++;
    }
    int totalOdd = 0;
    for (int i = 0; i < numCount.length; i++) {
      if(numCount[i]%2 != 0){
        totalOdd++;
      }
    }

    if(k + 1 >= totalOdd){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
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
