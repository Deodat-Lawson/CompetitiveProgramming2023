package Codeforces;

import java.io.*;
import java.util.*;

public class CF1853D {

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
    int[] arr = new int[n];
    ArrayList<Pair> allP = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
      allP.add(new Pair(arr[i], i));
    }

    Collections.sort(allP, new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.ind, o2.ind);
      }
    });

    int currMVal = n;
    int headP = 0;
    int tailP = n - 1;
    int currMustCount = 0;

    while (headP <= tailP){
      Pair headV = allP.get(headP);
      Pair tailV = allP.get(tailP);

      int length = tailP - headP + 1;
      if(headV.ind - currMustCount == 0 ^ tailV.ind - currMustCount == length){ //only one of them can be true
        if(headV.ind - currMustCount == 0){ //largest is that the end
          headV.val = currMVal * -1;
          allP.set(headP, headV);
          currMVal--;
          headP++;
        }
        else{
          tailV.val = currMVal;
          allP.set(tailP, tailV);
          currMVal--;
          tailP--;
          currMustCount++;
        }
      }
      else{
        System.out.println("No");
        return;
      }
    }

    System.out.println("Yes");

    Collections.sort(allP, new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.index, o2.index);
      }
    });

    for (int i = 0; i < allP.size(); i++) {
      System.out.print(allP.get(i).val + " ");
    }
    System.out.println();


  }

  static class Pair{
    int val, ind, index;
    Pair(int in, int index){
      ind = in;
      this.index = index;
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
