package LeetCode;

import java.io.*;
import java.time.chrono.MinguoChronology;
import java.util.*;

public class partitionArrayIntoArraysToMinDiff {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int[] a = {-36,36};
    int[] b = {3,9,7,3};
    int[] c = {2,-1,0,4,-2,-9};
    System.out.println(minimumDifference(c));
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
  }

  public static int minimumDifference(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    int valSmallerEqualTo = sum/2;

    Arrays.sort(nums);

    int[][] dpTable = new int[nums.length / 2 + 1][nums.length];

    for (int i = 0; i <= nums.length/2; i++) {
      for (int j = 0; j < nums.length; j++) {
        if(i == 0){
          dpTable[i][j] = 0;
        }
        else if(i == 1){
          if(nums[j] <= valSmallerEqualTo) {
            dpTable[i][j] = nums[j];
          }
          else{
            dpTable[i][j] = Integer.MIN_VALUE;
          }
        }
        else{
          int max = Integer.MIN_VALUE;
          for (int k = 0; k < j; k++) {
            int v = dpTable[i-1][k] + nums[j];
            if(v > max && v <= valSmallerEqualTo && dpTable[i-1][k] != Integer.MIN_VALUE){
              max = v;
            }
          }

          dpTable[i][j] = max;
        }
      }
    }

    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if(dpTable[nums.length/2][i] != Integer.MIN_VALUE){
        minDiff = Math.min(minDiff, sum - 2 * dpTable[nums.length/2][i]);
      }
    }

    return minDiff;

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
