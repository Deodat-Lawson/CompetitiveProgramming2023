package ICPC;

import java.io.*;
import java.util.*;

public class icpcteamgeneration {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    boolean[] taken = new boolean[n];
    for (int i = 0; i < n; i++) {
      a[i] = nextInt() - 1;
      b[i] = nextInt() - 1;
    }
    int team = 0;


    for (int i = 0; i < n; i++) {
      if(taken[i]){
        continue;
      }
      HashSet<Integer> setOfPpl = new HashSet<>();
      setOfPpl.add(i);
      for (int j = a[i]; j <= b[i]; j++) {
        //j is within i
        if(j == i){
          continue;
        }
        if(!taken[j]){
          boolean test = true;
          for (int k: setOfPpl
          ) {
            if(a[j] <= k && k <= b[j] && a[k] <= j && j <= b[k]) {
            }
            else{
              test = false;
            }
          }

          if(test){
            setOfPpl.add(j);
          }
        }

        if(setOfPpl.size() >= 3){
          taken[i] = true;
          for (int k: setOfPpl
               ) {
            taken[k] = true;
          }
          team++;
          break;
        }
      }
    }

    System.out.println(team);
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
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
