package LeetCode;

import java.io.*;
import java.util.*;

public class WildcardMatching {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve("abb", "**??");
  }

  public static void solve(String s, String p) throws IOException {
    //Todo: write your implementation
    if (p.isEmpty()) {
      System.out.println(s.isEmpty());
      return;
    }
    if (s.isEmpty()) {
      for (int i = 0; i < p.length(); i++) {
        if (!p.substring(i, i + 1).equals("*")) {
          System.out.println(false);
          return;
        }

      }
      System.out.println(true);
      return;
    }
    int firstNonStar = 0;
    for (int i = 0; i < p.length(); i++) {
      if(!p.substring(i,i+1).equals("*")){
        firstNonStar = i;
        break;
      }
    }


    boolean[][] dpTable = new boolean[p.length()][s.length()];
    int lastTableT = Integer.MAX_VALUE;

    for (int i = 0; i < p.length(); i++) {
      String thisM = p.substring(i, i + 1);
      int thisTableT = Integer.MAX_VALUE;

      for (int j = 0; j < s.length(); j++) {
        String match = s.substring(j, j + 1);

        if (j == 0 && i == 0) {
          if (thisM.equals(match) || thisM.equals("*") || thisM.equals("?")) {
            dpTable[i][j] = true;
            thisTableT = 0;
          } else {
            dpTable[i][j] = false;
          }
        } else if (i == 0) {
          if (thisM.equals("*")) {
            dpTable[i][j] = true;
            thisTableT = 0;
          } else {
            dpTable[i][j] = false;
          }
        } else if (j == 0) {
          String aT = p.substring(0,i + 1);
          String aw = aT.replace("*","");
          if(aw.equals(match) || aw.equals("?") || aw.equals("")){
            dpTable[i][j] = true;
            thisTableT = Math.min(thisTableT,j);
          }
          else{
            dpTable[i][j] = false;
          }
        } else {
          if (thisM.equals(match) || thisM.equals("?")) {
            dpTable[i][j] = dpTable[i - 1][j - 1];
            if (dpTable[i][j]) {
              thisTableT = Math.min(thisTableT, j);
            }
          } else if (thisM.equals("*")) {
            if (j >= lastTableT) {
              dpTable[i][j] = true;
              thisTableT = Math.min(thisTableT, j);
            }
          } else {
            dpTable[i][j] = false;
          }

        }
      }
      lastTableT = thisTableT;

    }

    System.out.println(dpTable[p.length() - 1][s.length() - 1]);

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
