package LeetCode;

import java.io.*;
import java.util.*;

public class dailyTemperatures {

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

  public int[] dailyTemperatures(int[] temperatures) {
    int[] ans = new int[temperatures.length];
    Stack<Integer> largestInt = new Stack<>();
    ans[temperatures.length - 1] = 0;
    largestInt.add(temperatures.length - 1);
    for (int i = temperatures.length - 2; i >= 0 ; i--) {
      while(!largestInt.isEmpty()){
        int current = largestInt.peek();
        if(temperatures[current] > temperatures[i]){
          break;
        }
        largestInt.pop();
      }
      if(largestInt.isEmpty()){
        ans[i] = 0;
      } else {
        ans[i] = largestInt.peek() - i;
      }
      largestInt.add(i);
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
