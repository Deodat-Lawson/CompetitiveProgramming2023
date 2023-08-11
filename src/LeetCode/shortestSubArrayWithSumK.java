package LeetCode;

import java.io.*;
import java.util.*;

public class shortestSubArrayWithSumK {

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

  public int shortestSubarray(int[] nums, int k) {
    long[] psa = new long[nums.length + 1];
    for (int i = 1; i < nums.length + 1; i++) {
      psa[i] = nums[i-1] + psa[i-1];
    }
    int shortestL = Integer.MAX_VALUE;

    Node[] arr = new Node[nums.length + 1];
    int endPointer = 0;

    for (int i = 0; i < psa.length; i++) {
      //find the smallest element that works
      if(i != 0) {
        int works = -1;
        int left = 0;
        int right = endPointer;

        while (left <= right) {
          int mid = (left + right) / 2;
          Node a = arr[mid];
          if (psa[i] - a.value >= k) {
            left = mid + 1;
            works = mid;
          } else {
            right = mid - 1;
          }
        }

        if(works != -1) {
          shortestL = Math.min(shortestL, i - arr[works].index);
        }
      }

      //find correct pointer to put the value in at the position.


      if(i == 0){
        arr[0] = new Node(0, 0);
      }
      else{
        int test = -1;
        int left = 0;
        int right = endPointer;
        while(left <= right){
          int mid = (left + right)/2;
          Node a = arr[mid];
          if(psa[i] > a.value){
            left = mid + 1;
            test = mid;
          }
          else{
            right = mid - 1;
          }
        }
        arr[test + 1] = new Node(i, psa[i]);
        endPointer = test + 1;
      }
    }

    if(shortestL == Integer.MAX_VALUE){
      shortestL = -1;
    }

    return shortestL;


      
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


  class Node{
    int index;
    long value;
    Node(int i, long v){
      index = i;
      value = v;
    }

  }
}
