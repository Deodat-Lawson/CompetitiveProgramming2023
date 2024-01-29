package ICPC;

import java.io.*;
import java.util.*;

public class evenup {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    int[] arr = new int[n];
    TreeSet<Integer> allS = new TreeSet<>();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int next = nextInt();
      arr[i] = next % 2;
      allS.add(i);
      list.add(i);
    }
    HashSet<Integer> removed = new HashSet<>();
    while (!list.isEmpty()){
      ArrayList<Integer> newList = new ArrayList<>();

      for (int a: list
           ) {
        if(!allS.contains(a)){
          continue;
        }
        if(allS.floor(a - 1) != null){
          int below = allS.floor(a - 1);
          if(arr[below] == arr[a]){
            allS.remove(below);
            allS.remove(a);
            removed.add(below);
            removed.add(a);
            if(allS.floor(a - 1) != null){
              newList.add(allS.floor(a - 1));
            }
            else if(allS.ceiling(a + 1) != null){
              newList.add(allS.ceiling(a + 1));
            }
          }
        }
        else if(allS.ceiling(a + 1) != null){
          int above = allS.ceiling(a + 1);
          if(arr[above] == arr[a]){
            allS.remove(above);
            allS.remove(a);
            removed.add(above);
            removed.add(a);
            if(allS.floor(a - 1) != null){
              newList.add(allS.floor(a - 1));
            }
            else if(allS.ceiling(a + 1) != null){
              newList.add(allS.ceiling(a + 1));
            }
          }
        }

      }

      list = newList;
    }
    System.out.println(n - removed.size());




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
