package LeetCode;

import java.io.*;
import java.util.*;

public class myCalenderI {

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

  class MyCalendar {

    ArrayList<Interval> allIntervals = new ArrayList<>();

    public MyCalendar() {
      allIntervals = new ArrayList<>();
    }

    public boolean book(int start, int end) {
      Interval current = new Interval(start, end);
      for (int i = 0; i < allIntervals.size(); i++) {
        if(allIntervals.get(i).contains(current)){
          return false;
        }
      }
      allIntervals.add(current);
      return true;
    }

    class Interval{
      int left;
      int right;
      Interval(int left, int right){
        this.left = left;
        this.right = right;
      }

      public boolean contains(Interval c){
          return c.left >= left || c.right <= left;
      }

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
