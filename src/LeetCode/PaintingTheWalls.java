package LeetCode;

import java.io.*;
import java.util.*;

public class PaintingTheWalls {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int[] cost = {2,3,4,2};
    int[] time = {1,1,1,1};


    solve(cost, time);
  }

  public static void solve(int[] cost, int[] time) throws IOException {
    //Todo: write your implementation
    int sumOfCosts = 0;
    for (int i = 0; i < cost.length; i++) {
      sumOfCosts+=cost[i];
    }
    int[][] tableDp = new int[cost.length][sumOfCosts + 1];
    for (int i = 0; i < tableDp.length; i++) {
      for (int j = 0; j < tableDp[0].length; j++) {
        tableDp[i][j] = -1;
      }
    }

    int sumCost = 0;
    for (int i = 0; i < cost.length; i++) {
      int tTime = time[i];
      int tCost = cost[i];
      sumCost+=tCost;
      for (int j = 0; j < sumOfCosts; j++) {

        if(i == 0){
          if(j <= tTime){
            tableDp[i][j] = tCost;
          }
        }
        else{
          if(j < tTime){
              tableDp[i][j] = tableDp[i - 1][j + 1];
          }
          else if(j > sumCost){
            continue;
          }
          else{
            if(tableDp[i - 1][j + 1] != -1) {
              tableDp[i][j] = Math.min(tableDp[i-1][j+1],tableDp[i-1][j - tTime] + tCost);
            }
            else if(tableDp[i-1][j - tTime] != -1){
              tableDp[i][j] = tableDp[i-1][j - tTime] + tCost;
            }
          }
        }
      }
    }

    System.out.println(tableDp[tableDp.length-1][0]);

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
