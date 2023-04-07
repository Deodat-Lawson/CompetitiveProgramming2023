package Codeforces;

import java.io.*;
import java.util.*;

public class CF1814C {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    int n = nextInt();
    int s1 = nextInt();
    int s2 = nextInt();
    
    ArrayList<CF1814CPair> allP = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      allP.add(new CF1814CPair(i+1, nextInt()));
    }

    Collections.sort(allP);
    long bot1T = 0;
    long bot2T = 0;

    ArrayList<Integer> bt1 = new ArrayList<>();
    ArrayList<Integer> bt2 = new ArrayList<>();

    for (int i = 0; i < allP.size(); i++) {
      CF1814CPair thisP = allP.get(i);

      if((bt1.size()+1)*s1 > (bt2.size()+1)*s2){
        bt2.add(thisP.ball);
      }
      else if((bt1.size()+1)*s1 < (bt2.size()+1)*s2){
        bt1.add(thisP.ball);
      }
      else{
        if(s1 > s2){
          bt2.add(thisP.ball);
        }
        else{
          bt1.add(thisP.ball);
        }
      }
    }
    System.out.print(bt1.size()+" ");
    for (int i = 0; i < bt1.size(); i++) {
      System.out.print(bt1.get(i)+" ");
    }
    System.out.println();
    System.out.print(bt2.size()+" ");
    for (int i = 0; i < bt2.size(); i++) {
      System.out.print(bt2.get(i)+" ");
    }
    System.out.println();
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


class CF1814CPair implements Comparable<CF1814CPair>{
  int ball;
  int freq;

  CF1814CPair(int b, int f){
    ball = b;
    freq = f;
  }
  @Override
  public int compareTo(CF1814CPair o) {
    return Integer.compare(o.freq, this.freq);
  }
}

