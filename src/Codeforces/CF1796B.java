package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1796B {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int numOfTest = nextInt();
    for (int i = 0; i < numOfTest; i++) {
      String a = nextLine();
      String b = nextLine();

      String ans = "";

      if(a.substring(0,1) .equals( b.substring(0,1))){
        System.out.println("YES");
        System.out.println(a.substring(0,1) + "*");
        continue;
      }

      if(a.substring(a.length() - 1) .equals( b.substring(b.length() - 1))){
        System.out.println("YES");
        System.out.println("*" + a.substring(a.length()-1));
        continue;
      }


      boolean flag = false;

      for (int j = 0; j < a.length() - 1; j++) {
        String trackCurr = a.substring(j, j+2);
        if(b.contains(trackCurr)){
          ans = "*" + trackCurr + "*";
          flag = true;
          break;
        }
      }

      if(flag){
        System.out.println("YES");
        System.out.println(ans);
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
