package LeetCode;

import java.io.*;
import java.util.*;

public class SplitArrayWithSameAvg {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int[] newIT = {0,0,0,0,0};
    System.out.println(splitArraySameAverage(newIT));
  }

  public static boolean splitArraySameAverage(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    int smallestDiv = Integer.MAX_VALUE;
    for (int i = nums.length; i >= 2; i--) {
      if (sum % i == 0) {
        smallestDiv = sum / i;
        break;
      }
    }
    double avg = (double) sum / nums.length;
    boolean[][][] dpTable = new boolean[sum+1][2][nums.length];

    for (int i = 0; i < nums.length; i++) {
      for (int k = 0; k < sum - smallestDiv + 1; k++) {
        for (int j = 0; j < nums.length; j++) {
          if (k == 0) {
            if (j == 0 || nums[i] == 0) {
              dpTable[k][i % 2][j] = true;
            } else if (i == 0) {
              dpTable[k][i % 2][j] = false;
            } else {
              dpTable[k][i % 2][j] = dpTable[k][(i - 1) % 2][j];
            }
          } else {
            if (i == 0) {
              if (k == nums[i] && j == 1) {
                dpTable[k][i % 2][j] = true;
              } else {
                dpTable[k][i % 2][j] = false;
              }
            } else {
              dpTable[k][i % 2][j] = dpTable[k][(i - 1) % 2][j];
              if (j > 0 && k >= nums[i]) {
                dpTable[k][i % 2][j] = (dpTable[k][i % 2][j] || dpTable[k - nums[i]][(i - 1) % 2][j - 1]);
              }
            }
          }

        }
      }
    }

    for (int j = 0; j < nums.length; j++) {
      for (int k = 0; k <= sum; k++) {
        if (dpTable[k][(nums.length - 1) % 2][j] && (double) k / j == avg) {
          return true;
        }
      }
    }
    return false;


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
