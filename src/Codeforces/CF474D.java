package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF474D {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  static int mod = (int) (1e9 + 7);
  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve()throws IOException{
    //Todo: write your implementation
    int t = nextInt();
    int k = nextInt();

    int increment = 0;
    int incrementIndex = 1;

    long[] dp = new long[100001];
    dp[1] = 1;
    for (int i = 2; i < dp.length; i++) {
      dp[i] = dp[i - 1] + increment;
      if(i%k == 0){
        dp[i] += 1;
        increment += incrementIndex;
        incrementIndex++;
      }
      dp[i]%=mod;
    }
    long[] psa = new long[100001];
    for (int i = 1; i < dp.length; i++) {
      psa[i] = psa[i - 1] + dp[i];
      psa[i]%=mod;
    }

    for (int i = 0; i < t; i++) {
      int start = nextInt();
      int end = nextInt();
      System.out.println((psa[end] - psa[start - 1] + mod)%mod);
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
