package LeetCode;

import java.io.*;
import java.util.*;

public class longestIncreasingSubsequence2 {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
  }

  public int lengthOfLIS(int[] nums, int k) {
    int[] dp = new int[nums.length];

    ArrayList<Pair> ValList = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int valSmaller = nums[i];
      Pair ans = ValList.get(ValList.size() - 1);
      int left = 0;
      int right = ValList.size();

      while (!ValList.isEmpty() && left <= right) {
        int mid = (left + right) / 2;
        if (ValList.get(i).val < valSmaller) {
          ans = ValList.get(i);
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      int a = 0;

      if (ValList.isEmpty()) {
        ValList.add(new Pair(nums[i] + k, 1));
        a = 1;
      } else if (ans.val == ValList.get(ValList.size() - 1).val) {
        ValList.add(new Pair(nums[i] + k, ans.count + 1));
        a = ans.count + 1;
      } else {
        ValList.get(i + 1).val = nums[i] + k;
        ValList.get(i + 1).count = ans.count + 1;
        a = ans.count + 1;
      }
      if (i == 0) {
        dp[0] = 1;
      } else {
        dp[i] = Math.max(dp[i - 1], a);
      }


    }
    return dp[nums.length - 1];
    //linkedlist to store data
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

  class Pair {
    int val, count;

    Pair(int val, int count) {
      this.val = val;
      this.count = count;
    }

  }

}
