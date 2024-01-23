package Codeforces;

import java.io.*;
import java.util.*;

public class CF1839B {

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
    long sum = 0;
    int[] c = new int[n+1];
    PriorityQueue<Lamp> count = new PriorityQueue<>(new Comparator<Lamp>() {
      @Override
      public int compare(Lamp o1, Lamp o2) {
        if(o1.a < o2.a){
          return -1;
        }
        else if(o1.a > o2.a) {
          return 1;
        }
        else{
          return Integer.compare(o2.b, o1.b);
        }
      }
    });

    for (int i = 0; i < n; i++) {
      int a = nextInt();
      int b = nextInt();
      count.add(new Lamp(a, b));
    }

    while(!count.isEmpty()){
      Lamp curr = count.poll();
      if(c[curr.a] < curr.a){
        c[curr.a]++;
        sum += curr.b;
      }
    }
    System.out.println(sum);



  }

  static class Lamp{
    int a, b;
    Lamp(int a, int b){
      this.a = a;
      this.b = b;
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
