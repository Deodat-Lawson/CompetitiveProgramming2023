package LeetCode;

import java.io.*;
import java.util.*;

public class rangeFrequencyQueries {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
    RangeFreqQuery t = new RangeFreqQuery(arr);
    System.out.println(t.query(1,2,4));
    System.out.println(t.query(0,11,33));

  }

  static class RangeFreqQuery {
    ArrayList<Integer>[] rangeFreqArr;
    public RangeFreqQuery(int[] arr) {
      rangeFreqArr = (ArrayList<Integer>[]) new ArrayList[10002];
      for (int i = 0; i < rangeFreqArr.length; i++) {
        rangeFreqArr[i] = new ArrayList<>();
      }
      build(arr);
    }

    public void build(int[] arr){
      for (int i = 0; i < arr.length; i++) {
        int curr = arr[i];
        rangeFreqArr[curr].add(i);
      }
    }

    public int query(int left, int right, int value) {
      ArrayList<Integer> thisArr = rangeFreqArr[value];
      int smallestLargerThanLeft = Collections.binarySearch(thisArr, left);
      int largestSmallerThanRight = Collections.binarySearch(thisArr, right);

      if(smallestLargerThanLeft < 0){
        smallestLargerThanLeft *= -1;
        smallestLargerThanLeft -= 1;
      }

      if(largestSmallerThanRight < 0){
        largestSmallerThanRight *= -1;
        largestSmallerThanRight -= 2;
      }

      return largestSmallerThanRight - smallestLargerThanLeft + 1;
    }
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
