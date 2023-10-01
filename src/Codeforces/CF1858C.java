package Codeforces;

import java.util.*;
import java.io.*;

public class CF1858C {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  static ArrayList<Integer> list;
  static boolean[] visited;

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    int[] connectNode = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
      connectNode[i] = -1;
    }
    for (int i = 1; i < n + 1; i++) {
      //num i connects to num 2*i
      if (2 * i <= n) {
        connectNode[i] = 2 * i;
      }
    }
    list = new ArrayList<>();
    visited = new boolean[n + 1];
    for (int i = 1; i < n + 1; i++) {
      if(!visited[i]){
        dfs(connectNode, i);
      }
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();

  }

  static void dfs(int[] connection, int index){
    visited[index] = true;
    list.add(index);
    if(connection[index] != -1){
      dfs(connection, index * 2);
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
