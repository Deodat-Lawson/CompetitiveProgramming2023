//package WC;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.StringTokenizer;
//
//public class WC2018C3S2 {
//  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//  static StringTokenizer tok;
//  public static void main(String[] args) throws IOException {
//    int N = nextInt();
//    int K = nextInt();
//    int F = nextInt();
//
//    ArrayList<Integer> gyms = new ArrayList<>();
//    ArrayList<Integer>[] adjList = new ArrayList[N+1];
//
//    for (int i = 0; i < N+1; i++) {
//      adjList[i] = new ArrayList<>();
//    }
//
//    for (int i = 0; i < K; i++) {
//      gyms.add(nextInt());
//    }
//
//    for (int i = 0; i < N-1; i++) {
//      int a = nextInt();
//      int b = nextInt();
//      adjList[a].add(b);
//      adjList[b].add(a);
//    }
//
//
//
//
//
//  }
//
//
//
//
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
//
//class WC2018C3S2Traversal{
//  int[] dist;
//  boolean[] isLastPoint;
//  HashMap<Integer, Integer> mapToIndex = new HashMap<>();
//  HashSet<Integer> visited = new HashSet<>();
//  HashSet<Integer> find = new HashSet<>();
//
//  ArrayList<Integer>[] adjList;
//
//  WC2018C3S2Traversal(ArrayList<Integer> allFind, ArrayList<Integer>[] adjList){
//    this.adjList = adjList;
//    dist = new int[allFind.size()];
//    isLastPoint = new boolean[allFind.size()];
//    for (int i = 0; i < allFind.size(); i++) {
//      find.add(allFind.get(i));
//      dist[i] = Integer.MAX_VALUE;
//      isLastPoint[i] = true;
//    }
//  }
//
//  void dfs(int curr, int d, int prevNode){
//    if(find.contains(curr)){
//      dist[curr] = d;
//      prevNode
//    }
//    visited.add(curr);
//    for (int i = 0; i < adjList[curr].size(); i++) {
//      int a = adjList[curr].get(i);
//      if(!visited.contains(a)){
//        dfs(a, d + 1);
//      }
//    }
//  }
//
//
//}
