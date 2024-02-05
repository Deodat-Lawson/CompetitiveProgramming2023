package LeetCode;

import java.io.*;
import java.util.*;

public class largestRectangleInHistogram {

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

  public int largestRectangleArea(int[] heights) {
    //find the leftMostElement that is smaller than the currentElement's Height
    //find the rightMostElement that is smaller than the currentElement's Height
    int[] leftIndex = new int[heights.length];
    int[] rightIndex = new int[heights.length];
    Stack<Integer> stk = new Stack<>();
    for (int i = 0; i < leftIndex.length; i++) {
      int currHeight = heights[i];
      while (!stk.isEmpty()){
        int prevV = stk.peek();
        if(currHeight > heights[prevV]){
          break;
        }
        stk.pop();
      }
      if(stk.isEmpty()){
        leftIndex[i] = 0;
      }
      else{
        leftIndex[i] = stk.peek() + 1;
      }
      stk.add(i);
    }

    stk.clear();
    for (int i = rightIndex.length - 1; i >= 0; i--) {
      int currHeight = heights[i];
      while (!stk.isEmpty()){
        int prevV = stk.peek();
        if(currHeight > heights[prevV]){
          break;
        }
        stk.pop();
      }
      if(stk.isEmpty()){
        rightIndex[i] = rightIndex.length - 1;
      }
      else{
        rightIndex[i] = stk.peek() - 1;
      }
      stk.add(i);
    }

    long max = 0;
    for (int i = 0; i < heights.length; i++) {
      max = Math.max(max, (long)(rightIndex[i] - leftIndex[i] + 1) * heights[i]);
    }
    return (int) max;
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
