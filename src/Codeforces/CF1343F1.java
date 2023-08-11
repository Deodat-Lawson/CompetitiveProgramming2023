package Codeforces;

import java.io.*;
import java.util.*;

public class CF1343F1 {

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
    int[] arr = new int[n + 2];
    int[] parent = new int[n + 2];
    int[] totalMax = new int[n + 2];
    int[] totalMin = new int[n + 2];
    arr[1] = 1;
    parent[1] = 1;
    int[] dpmax = new int[n + 2];
    int[] dpmin = new int[n + 2];
    dpmax[1] = 1;

    int p = 2;

    for (int i = 0; i < n; i++) {
      char c = nextCharacter();

      if (c == '+') {
        int par = nextInt();
        int weight = nextInt();

        arr[p] = weight;
        parent[p] = par;

        if(weight == -1){
          totalMin[p] = totalMin[par] - 1;
          totalMax[p] = totalMax[par] - 1;
        }
        else{
          totalMax[p] = totalMax[par] + 1;
          totalMin[p] = totalMin[par] + 1;
        }


        if (weight == -1 && arr[par] == -1) {
          dpmin[p] = dpmin[par]-1;
          dpmax[p] = dpmax[par];
        } else if(weight == 1 && arr[par] == 1){
          dpmax[p] = dpmax[par]+1;
          dpmin[p] = dpmin[par];
        }
        else if(weight == -1){
          dpmin[p] = Math.min(dpmin[parent[par]],-1);
          dpmax[p] = dpmax[par];
        }
        else{
          dpmin[p] = dpmin[par];
          dpmax[p] = dpmax[parent[par]];
        }

        dpmin[p] = Math.min(dpmin[p],totalMin[p]);
        dpmax[p] = Math.max(dpmax[p], totalMax[p]);

        p++;
      } else {
        int u = nextInt();
        int v = nextInt();
        int k = nextInt();

        if (k <= dpmax[v] && k >= dpmin[v]) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }


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
