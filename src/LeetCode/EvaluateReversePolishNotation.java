package LeetCode;

import java.io.*;
import java.util.*;

public class EvaluateReversePolishNotation {

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

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      String s = tokens[i];
      if(!(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"))){
        stack.add(Integer.parseInt(s));
      }
      else {
        int firstNum = stack.pop();
        int secondNum = stack.pop();
        if(s.equals("+")){
          stack.add(firstNum + secondNum);
        }
        if(s.equals("-")){
          stack.add(secondNum - firstNum);
        }
        if(s.equals("*")){
          stack.add(firstNum * secondNum);
        }
        if(s.equals("/")){
          stack.add(secondNum/firstNum);
        }
      }
    }
    return stack.pop();
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
