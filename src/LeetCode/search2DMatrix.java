package LeetCode;

import java.io.*;
import java.util.*;

public class search2DMatrix {

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

  public boolean searchMatrix(int[][] matrix, int target) {
    //search for the correct row
    int left = 0;
    int right = matrix.length - 1;
    int ans = 0;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (matrix[mid][0] < target) {
        left = mid + 1;
        ans = Math.max(0, mid);
      } else if(matrix[mid][0] > target){
        right = mid - 1;
      }
      else{
        return true;
      }
    }

    left = 0;
    right = matrix[0].length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (matrix[ans][mid] < target) {
        left = mid + 1;
      } else if (matrix[ans][mid] > target) {
        right = mid - 1;
      } else {
        return true;
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
