//package LeetCode;
//
//import java.io.*;
//import java.util.*;
//
//public class RedundantConnection2 {
//
//  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//  static StringTokenizer tok;
//
//  public static void main(String[] args) throws IOException {
//    int[][] a = {{2,1},{3,1},{4,2},{1,4}};
//    findRedundantDirectedConnection(a);
//  }
//
//  public static void solve() throws IOException {
//    //Todo: write your implementation
//  }
//
//  static boolean[] visited;
//  public static int[] findRedundantDirectedConnection(int[][] edges) {
//
//    ArrayList<Integer>[] adjListFrom = new ArrayList[edges.length];
//    ArrayList<Integer>[] adjListDFS = new ArrayList[edges.length];
//    for (int i = 0; i < adjListFrom.length; i++) {
//      adjListFrom[i] = new ArrayList<>();
//      adjListDFS[i] = new ArrayList<>();
//    }
//
//    for (int i = 0; i < edges.length; i++) {
//      adjListFrom[edges[i][1] - 1].add(edges[i][0] - 1);
//      adjListDFS[edges[i][0] - 1].add(edges[i][1] - 1);
//    }
//
//    for (int i = edges.length - 1; i >= 0; i--) {
//      int[] thisEdge = edges[i];
//      int to = edges[i][1] - 1;
//      int from = edges[i][0] - 1;
//
//      if(adjListFrom[to].size() > 1){
//        for (int j = 0; j < adjListFrom[to].size(); j++) {
//          if (adjListFrom[to].get(j) == from) {
//            adjListFrom[to].remove((int)j);
//          }
//        }
//        for (int j = 0; j < adjListDFS[from].size(); j++) {
//          if (adjListDFS[from].get(j) == to) {
//            adjListDFS[from].remove((int)j);
//          }
//        }
//
//        boolean[] v = new boolean[edges.length];
//        int root = findRoot(to, adjListFrom, v);
//        visited = new boolean[edges.length];
//        if(root == -1){
//          adjListDFS[from].add(to);
//          adjListFrom[to].add(from);
//          continue;
//        }
//
//        dfs(root, adjListDFS);
//        adjListDFS[from].add(to);
//        adjListFrom[to].add(from);
//
//        boolean rootedT = true;
//        for (int j = 0; j < edges.length; j++) {
//          if(!visited[j]){
//            rootedT = false;
//          }
//        }
//
//        if(rootedT){
//          return thisEdge;
//        }
//
//      }
//      else{
//        for (int j = 0; j < adjListDFS[from].size(); j++) {
//          if (adjListDFS[from].get(j) == to) {
//            adjListDFS[from].remove(j);
//          }
//        }
//        visited = new boolean[edges.length];
//        dfs(to, adjListDFS);
//        adjListDFS[from].add(to);
//
//
//        boolean rootedT = true;
//        for (int j = 0; j < edges.length; j++) {
//          if(!visited[j]){
//            rootedT = false;
//          }
//        }
//
//        if(rootedT){
//          return thisEdge;
//        }
//      }
//
//    }
//
//    int[] a = {-1,-1};
//    return a;
//
//  }
//
//
//  static void dfs(int edge, ArrayList<Integer>[] adj){
//    visited[edge] = true;
//    for (int i = 0; i < adj[edge].size(); i++) {
//      dfs(adj[edge].get(i),adj);
//    }
//  }
//
//  static int findRoot(int n, ArrayList<Integer>[] adjListFrom, boolean[] v){
//    v[n] = true;
//    if(adjListFrom[n].isEmpty()){
//      return n;
//    }
//    if(v[adjListFrom[n].get(0)]){
//      return -1;
//    }
//    return findRoot(adjListFrom[n].get(0), adjListFrom,v);
//  }
//  static String next() throws IOException {
//    while (tok == null || !tok.hasMoreTokens()) {
//      tok = new StringTokenizer(f.readLine().trim());
//    }
//    return tok.nextToken();
//  }
//
//  static long nextLong() throws IOException {
//    return Long.parseLong(next());
//  }
//
//  static int nextInt() throws IOException {
//    return Integer.parseInt(next());
//  }
//
//  static double nextDouble() throws IOException {
//    return Double.parseDouble(next());
//  }
//
//  static char nextCharacter() throws IOException {
//    return next().charAt(0);
//  }
//
//  static String nextLine() throws IOException {
//    return f.readLine().trim();
//  }
//
//}
