package LeetCode;

import java.io.*;
import java.util.*;

public class oddEvenJump {

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
  public int oddEvenJumps(int[] arr) {
    boolean[] dpOdd = new boolean[arr.length];
    boolean[] dpEven = new boolean[arr.length];

    dpEven[arr.length - 1] = true;
    dpOdd[arr.length - 1] = true;
    TreeSet<Pair> p = new TreeSet<>();
    p.add(new Pair(arr[arr.length - 1],arr.length - 1));

    for (int i = arr.length - 2; i >= 0; i--) {
      Pair greaterThan = p.ceiling(new Pair(arr[i],i));
      Pair lessThan = p.floor(new Pair(arr[i],i));

      if(greaterThan != null){
        dpOdd[i] = dpEven[greaterThan.index];
      }

      if(lessThan != null){
        dpEven[i] = dpOdd[lessThan.index];
      }

      if(greaterThan != null && greaterThan.val == arr[i]){
        greaterThan.index = i;
      }
      else{
        p.add(new Pair(arr[i],i));
      }

    }
    int c = 0;
    for (int i = 0; i < dpOdd.length; i++) {
      if(dpOdd[i]){
        c++;
      }
    }
    return c;


  }

  class Pair implements Comparable<Pair>{
    int index;
    int val;
    Pair(int v, int i){
      val = v;
      index = i;
    }

    @Override
    public int compareTo(Pair o1){
      return Integer.compare(val, o1.val);
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
