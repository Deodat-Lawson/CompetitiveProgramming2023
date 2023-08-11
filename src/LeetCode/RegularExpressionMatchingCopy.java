package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class RegularExpressionMatchingCopy {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    System.out.println(isMatch("aa", "a"));
  }

  public static boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[p.length()][s.length()];
    String prevC = "";
    for (int i = 0; i < p.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
        String sVal = s.substring(i, i + 1);
        String pVal = p.substring(i, i + 1);
        boolean isSame = sVal.equals(pVal);
        if (i == 0) {
          if (pVal.equals(".")) {
            if(j == 0) {
              dp[i][j] = true;
            }
          } else {
            if (j == 0 && isSame) {
              dp[i][j] = true;
            } else {
              dp[i][j] = false;
            }
          }
        } else {
          if (pVal.equals("*")) {
            if(prevC.contains(sVal)){

            }
          } else if (pVal.equals(".")) {
            if(j == 0){
              dp[i][j] = noL(p.substring(0,i));
            }
            else{
              dp[i][j] = dp[i-1][j-1];
            }
          } else {
            if(!isSame){
              dp[i][j] = false;
            }
            else{
              if(j == 0){
                dp[i][j] = noL(p.substring(0,i));
              }
              else{
                dp[i][j] = dp[i-1][j-1];
              }
            }

          }
        }
        prevC = pVal;



      }
    }
    return dp[p.length() - 1][s.length() - 1];
  }

  static boolean noL(String s){
    for (int i = 0; i < s.length(); i++) {
      if(!s.substring(i,i+1).equals("*")){
        return false;
      }
    }
    return true;
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
