package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1795A {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {

    int n = nextInt();
    for (int i = 0; i < n; i++) {
      int a = nextInt();
      int b = nextInt();
      String al = nextLine();
      String l2 = nextLine();

      String sum = al+l2;

      boolean works = false;

      for (int j =  0; j < sum.length(); j++) {
        int split = j;


        String prev = sum.substring(0,1);
        boolean thisW = false;
        for (int k = 1; k < split; k++) {
          String c = sum.substring(k,k+1);
          if(c.equals(prev)){
            thisW = true;
            break;
          }
          prev = c;
        }

        prev = "";
        for (int k = split; k < sum.length(); k++) {
          String c = sum.substring(k,k+1);
          if(c.equals(prev)){
            thisW = true;
            break;
          }
          prev = c;
        }

        if(!thisW){
          works = true;
          break;
        }

      }

      if(works){
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
