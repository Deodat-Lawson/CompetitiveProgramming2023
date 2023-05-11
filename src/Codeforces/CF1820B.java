package Codeforces;

import java.io.*;
import java.util.*;

public class CF1820B {

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
    String a = nextLine();
    //fist find if there is 0,
    if(!a.contains("0")){
      long al = a.length();
      System.out.println(al*al);
      return;
    }
    if(!a.contains("1")){
      System.out.println(0);
      return;
    }


    int index = a.indexOf("0");
    a = a.substring(index) + a.substring(0,index);
    long max = 0;
    long numOfconsequtive1 = 0;

    //start at a 0
    for (int i = 0; i < a.length(); i++) {
      char thisC = a.charAt(i);
      if(thisC == '1'){
        numOfconsequtive1++;
      }
      else{
        max = Math.max(numOfconsequtive1,max);
        numOfconsequtive1 = 0;
      }
    }
    max = Math.max(numOfconsequtive1,max);
    max++;



    if(max%2 == 0){
      long num = (max/2);
      System.out.println(num*num);
    }
    else{
      long num = max/2;
      System.out.println(num*(num+1));
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
