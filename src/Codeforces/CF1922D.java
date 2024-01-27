//package Codeforces;
//
//import java.io.*;
//import java.util.*;
//
//public class CF1922D {
//
//  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//  static StringTokenizer tok;
//
//  public static void main(String[] args) throws IOException {
//    int t = nextInt();
//    for (int i = 0; i < t; i++) {
//      solve();
//    }
//  }
//
//  public static void solve() throws IOException {
//    //Todo: write your implementation
//    int n = nextInt();
//    int[] attackValue = new int[n];
//    int[] defenseValue = new int[n];
//    for (int i = 0; i < n; i++) {
//      attackValue[i] = nextInt();
//    }
//    for (int i = 0; i < n; i++) {
//      defenseValue[i] = nextInt();
//    }
//    TreeSet<Integer> aliveSet = new TreeSet<>();
//    for (int i = 0; i < n; i++) {
//      aliveSet.add(i);
//    }
//    ArrayList<Integer> currentDead = new ArrayList<>();
//    for (int i = 0; i < n; i++) {
//      int totalAttackValue = 0;
//      if (i - 1 >= 0) {
//        totalAttackValue += attackValue[i - 1];
//      }
//      if (i + 1 < n) {
//        totalAttackValue += attackValue[i + 1];
//      }
//      if(totalAttackValue > defenseValue[i]){
//        currentDead.add(i);
//        aliveSet.remove(i);
//      }
//    }
//    int[] rounds = new int[n];
//    rounds[0] = currentDead.size();
//    ArrayList<Integer> newDead = new ArrayList<>();
//    int count = 1;
//    while(!currentDead.isEmpty()){
//      for (int current: currentDead
//           ) {
//        int prev = aliveSet.floor(current - 1);
//        int next = aliveSet.ceiling(current + 1);
//        if(prev != -)
//      }
//    }
//
//
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
