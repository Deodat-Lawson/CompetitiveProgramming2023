package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1796A {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int numOfTest = nextInt();
    String ans = "";
    for (int i = 1; i < 100; i++) {
      if(i%3 == 0) {
        ans += "F";
      }
      if(i%5 == 0){
        ans += "B";
    }
    }

    for (int i = 0; i < numOfTest; i++) {
      int a = nextInt();
      String l = nextLine();
      if (ans.contains(l)) {
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
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
