//package ICPC;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.io.*;
//import java.lang.reflect.Array;
//import java.util.*;
//
//public class donthungertogether {
//
//  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//  static StringTokenizer tok;
//
//  public static void main(String[] args) throws IOException {
//    int n = nextInt();
//    int k = nextInt();
//    double[] psa = new double[n + 1];
//    int[] deadlines = new int[n];
//    double[] arr = new double[n];
//    for (int i = 0; i < n; i++) {
//      double q = nextDouble();
//      int f = nextInt() - 1;
//      arr[i] = q;
//      deadlines[i] = f;
//      psa[i] += q;
//      psa[f + 1] -= q;
//    }
//
//    for (int i = 1; i < n; i++) {
//      psa[i] += psa[i - 1];
//      if(psa[i] <= 0 && arr[i] == 0){
//        System.out.println(-1);
//      }
//    }
//
//    double[] dp = new double[n];
//    PriorityQueue<Pair> pq = new PriorityQueue<>();
//    double total = 0;
//
//
//    pq.add(new Pair(psa[0],deadlines[0]));
//    total += deadlines[0];
//    dp[0] = psa[0] / k;
//
//    for (int i = 1; i < n; i++) {
//
//      while(!pq.isEmpty() && pq.peek().deadline < i){
//        total -= pq.poll().quantity;
//      }
//
//
//
//
//
//      double direct = arr[i] / k;
//
//
//      dp[i] = Math.max(rangeSum, direct);
//    }
//
//    double min = Double.MAX_VALUE;
//    for (int i = 0; i < dp.length; i++) {
//      min = Math.min(dp[i], min);
//    }
//
//    System.out.println(min);
//
//  }
//
//  static class Pair implements Comparable<Pair>{
//    double quantity;
//    int deadline;
//    Pair(double quantity, int deadline){
//      this.quantity = quantity;
//      this.deadline = deadline;
//    }
//
//    @Override
//    public int compareTo( Pair o) {
//      return Integer.compare(deadline, o.deadline);
//    }
//  }
//
//  public static void solve() throws IOException {
//    //Todo: write your implementation
//  }
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
