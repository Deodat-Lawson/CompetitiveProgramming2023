package Codeforces;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CF1823B {

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
    int n = nextInt();
    int k = nextInt();
    HashSet<Integer>[] table = new HashSet[k];
    for (int i = 0; i < k; i++) {
      table[i] = new HashSet<>();
    }
    for (int i = 0; i < n; i++) {
      int thisN = nextInt();
      HashSet<Integer> thisRow = table[i%k];
      thisRow.add(thisN);
    }


    int count = 0;
    for (int i = 0; i < n; i++) {
      if(!table[i%k].contains((i+1))){
        count++;
      }
    }

    if(count == 0){
      System.out.println(0);
    }
    else if(count <= 2){
      System.out.println(1);
    }
    else{
      System.out.println(-1);
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
