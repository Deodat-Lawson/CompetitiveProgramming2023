package LeetCode;

import java.io.*;
import java.util.*;

public class findMinInRotatedSortedArray {

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

  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int ans = Integer.MAX_VALUE;
    while (left <= right) {
      int mid = (left + right)/2;
      if(nums[mid] <= nums[nums.length - 1]){
        ans = Math.min(ans, nums[mid]);
        right = mid - 1;
      }
      else{
        left = mid + 1;
      }
    }
    return ans;
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
