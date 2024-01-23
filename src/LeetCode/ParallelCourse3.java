package LeetCode;

import java.io.*;
import java.util.*;

public class ParallelCourse3 {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  static ArrayList<Integer>[] adjList;
  static Stack<Integer> stack;
  static HashSet<Integer> visited;
  public static int minimumTime(int n, int[][] relations, int[] time) {
    stack = new Stack<>();
    adjList = new ArrayList[n];
    visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      adjList[i] = new ArrayList<>();
    }
    for (int i = 0; i < relations.length; i++) {
      for (int j = 0; j < 2; j++) {
        int from = relations[i][j] - 1;
        int to = relations[i][j] - 1;
        adjList[from].add(to);
      }
    }
    for (int i = 0; i < n; i++) {
      if(!visited.contains(i)){
        dfs(i);
      }
    }

    ArrayList<Integer> allNum = new ArrayList<>();
    while (!stack.isEmpty()){
      allNum.add(stack.pop());
    }

    int[] ttg = new int[n];
    for (int i = 0; i < allNum.size(); i++) {
      for (int child: adjList[i]
           ) {
        ttg[child] = Math.max(ttg[i] + time[i], ttg[child]);
      }
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(ttg[i] + time[i], max);
    }
    return max;


  }

  public static void dfs(int n) {
    visited.add(n);
    for (int child: adjList[n]
         ) {
      if(!visited.contains(child)){
        dfs(child);
      }
    }
    stack.add(n);
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
