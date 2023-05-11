package Codeforces;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class CF1820C {

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
    int s = nextInt();
    HashSet<Integer> smallestN = new HashSet<>();
    StringBuilder arr = new StringBuilder();
    for (int i = 0; i < s; i++) {
      int a = nextInt();
      String aToString = "" + a;
      arr.append(aToString);
      smallestN.add(a);
    }

    int smallestNotContained = 0;
    while(true){
      if(!smallestN.contains(smallestNotContained)){
        break;
      }
      smallestNotContained++;
    }

    int goal = smallestNotContained+1;
    String goalToS = "" + goal;
    String smallestToS = ""+smallestNotContained;


    if(!smallestN.contains(goal)){
      if(s == goal - 1){
        System.out.println("No");
      }
      else{
        System.out.println("Yes");
      }
    }
    else{

      int firstIndex = arr.indexOf(goalToS);
      int lastIndex = arr.lastIndexOf(goalToS);



      StringBuilder newA = new StringBuilder();
      newA.append(arr.substring(0,firstIndex));
      for (int i = firstIndex; i <= lastIndex; i++) {
        newA.append(smallestToS);
      }
      newA.append(arr.substring(lastIndex+1));

      HashSet<Integer> c = new HashSet<>();
      for (int i = 0; i < newA.length(); i++) {
        int a = Integer.parseInt(newA.substring(i,i+1));
        c.add(a);
      }



      int smallestNotContained2 = 0;
      while(true){
        if(!c.contains(smallestNotContained2)){
          break;
        }
        smallestNotContained2++;
      }

      if(smallestNotContained2 == goal){
        System.out.println("Yes");
      }
      else{
        System.out.println("No");
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
