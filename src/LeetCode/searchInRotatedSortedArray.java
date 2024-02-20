package LeetCode;

import java.io.*;
import java.util.*;

public class searchInRotatedSortedArray {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public int search(int[] nums, int target) {
    //find the starting element, then run two binary search to try find the element
    int left = 0;
    int right = nums.length - 1;
    int startingIndex = -1;
    while(left <= right){
      int mid = (left + right)/2;
      if(nums[mid] == target){
        return mid;
      }
      if(nums[mid] <= nums[nums.length - 1]){
        startingIndex = mid;
        right = mid - 1;
      }
      else{
        left = mid + 1;
      }
    }

    left = startingIndex;
    right = nums.length - 1;
    while(left <= right){
      int mid = (left + right)/2;
      if(nums[mid] < target){
        left = mid + 1;
      }
      else if(nums[mid] > target){
        right = mid - 1;
      }
      else{
        return mid;
      }
    }

    left = 0;
    right = startingIndex - 1;
    while(left <= right){
      int mid = (left + right)/2;
      if(nums[mid] < target){
        left = mid + 1;
      }
      else if(nums[mid] > target){
        right = mid - 1;
      }
      else{
        return mid;
      }
    }
    return -1;

  }

  public static void solve() throws IOException {
    //Todo: write your implementation
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
