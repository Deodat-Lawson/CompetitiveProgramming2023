package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class CF61E {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve()throws IOException{
    int n = nextInt();
    int[] nums = new int[n];

    for (int i = 0; i < nums.length; i++) {
      nums[i] = nextInt();
    }

    int[] gl = new int[n];
    int[] lt = new int[n];
    TreeSet<Integer> allV = new TreeSet<>();


    for (int i = 0; i < nums.length; i++) {
      //find smallest integer greater than
      int element = nums[i];
      if(i == 0){
        gl[i] = 0;
        allV.add(element);
        continue;
      }

      if(allV.higher(element) != null){
        gl[i] = allV.tailSet(allV.higher(element)).size();
      }
      else{
        gl[i] = 0;
      }
      allV.add(element);
    }


    allV = new TreeSet<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      int element = nums[i];
      if(i == nums.length - 1){
        lt[i] = 0;
        allV.add(element);
        continue;
      }

      if(allV.lower(element) != null){
        lt[i] = allV.headSet(allV.lower(element)).size() + 1;
      }
      else{
        lt[i] = 0;
      }
      allV.add(element);
    }

    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += (long) lt[i] * gl[i];
    }

    System.out.println(sum);

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
