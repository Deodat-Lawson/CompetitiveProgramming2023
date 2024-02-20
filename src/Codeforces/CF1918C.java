package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF1918C {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    long a = nextLong();
    long b = nextLong();
    long r = nextLong();
    if (a < b) {
      long temp = a;
      a = b;
      b = temp;
    }

    if(r == 0){
      System.out.println(a - b);
      return;
    }

    int log = (int) (Math.log(r) / Math.log(2));


    long min = Long.MAX_VALUE;

    long lengthOfBIncrement = r;
    long bIncrement = b;
    long aBI = a;
    lengthOfBIncrement -= (1L << log);
    bIncrement ^= (1L << log);
    aBI ^= (1L << log);
    //assuming aBI is the larger one
    if (aBI < bIncrement) {
      long temp = aBI;
      aBI = bIncrement;
      bIncrement = temp;
    }

    for (int i = log - 1; i >= 0; i--) {
      if (((bIncrement & (1L << i)) == 0) && (aBI & (1L << i)) == (1L << i)) {
        if ((bIncrement ^ (1L << i)) <= (aBI ^ (1L << i)) && (1L << i) <= lengthOfBIncrement) {
          bIncrement ^= (1L << i);
          aBI ^= (1L << i);
          lengthOfBIncrement -= (1L << i);
        }
      }
    }

    min = Math.min(min, aBI - bIncrement);

    lengthOfBIncrement = r;
    bIncrement = b;
    aBI = a;

    for (int i = log - 1; i >= 0; i--) {
      if (((bIncrement & (1L << i)) == 0) && (aBI & (1L << i)) == (1L << i)) {
        if ((bIncrement ^ (1L << i)) <= (aBI ^ (1L << i)) && (1L << i) <= lengthOfBIncrement) {
          bIncrement ^= (1L << i);
          aBI ^= (1L << i);
          lengthOfBIncrement -= (1L << i);
        }
      }
    }

    min = Math.min(min, aBI - bIncrement);
    System.out.println(min);
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
