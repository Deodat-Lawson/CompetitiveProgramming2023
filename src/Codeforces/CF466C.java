package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF466C {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve()throws IOException{
    //Todo: write your implementation
    int n = nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
    }
    long sum = 0;
    long[] psa = new long[n + 1];
    psa[0] = 0;
    for (int i = 1; i < n + 1; i++) {
      psa[i] = psa[i - 1] + arr[i-1];
    }
    sum = psa[n];
    if(sum%3 != 0){
      System.out.println(0);
      return;
    }
    long twoRegionalSum = 2 * sum/3;

    int[] freqPsa = new int[n + 1];

    freqPsa[n] = 0;
    for (int i = n - 1; i >= 0 ; i--) {
      freqPsa[i] = freqPsa[i + 1];
      if(psa[i] == twoRegionalSum){
        freqPsa[i]++;
      }
    }

    long ans = 0;
    for (int i = 1; i < n; i++) {
      if(psa[i] == sum/3){
        ans += freqPsa[i + 1];
      }
    }


    System.out.println(ans);

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
