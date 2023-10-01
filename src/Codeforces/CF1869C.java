//package Codeforces;
//
//import java.io.*;
//import java.util.*;
//
//public class CF1869C {
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
//    int m = nextInt();
//
//    int[] perm = new int[m];
//    for (int i = 0; i < m; i++) {
//      perm[i] = i;
//    }
//
//    if(m == 1){
//      System.out.println(0);
//      for (int i = 0; i < n; i++) {
//        System.out.println(0);
//      }
//      return;
//    }
//
//
//    if(n == m){
//      System.out.println(n); // this is the max MEX value
//      for (int i = 1; i < n; i++) {
//        output(perm, i);
//      }
//      output(perm, 1);
//    }
//    else if(n > m){
//      System.out.println(m);
//      for (int i = 1; i < m; i++) {
//        output(perm, i);
//      }
//      for (int i = 0; i < n - m + 1; i++) {
//        output(perm, 1);package Codeforces;
//
//import java.io.*;
//import java.util.*;
//
//        public class CF1869C {
//
//          static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//          static StringTokenizer tok;
//
//          public static void main(String[] args) throws IOException {
//            int t = nextInt();
//            for (int i = 0; i < t; i++) {
//              solve();
//            }
//          }
//
//          public static void solve() throws IOException {
//            //Todo: write your implementation
//            int n = nextInt();
//            int m = nextInt();
//
//            int[] perm = new int[m];
//            for (int i = 0; i < m; i++) {
//              perm[i] = i;
//            }
//
//            if(m == 1){
//              System.out.println(0);
//              for (int i = 0; i < n; i++) {
//                System.out.println(0);
//              }
//              return;
//            }
//
//
//            if(n == m){
//              System.out.println(n); // this is the max MEX value
//              for (int i = 1; i < n; i++) {
//                output(perm, i);
//              }
//              output(perm, 1);
//            }
//            else if(n > m){
//              System.out.println(m);
//              for (int i = 1; i < m; i++) {
//                output(perm, i);
//              }
//              for (int i = 0; i < n - m + 1; i++) {
//                output(perm, 1);
//              }
//            }
//            else{
//              System.out.println(n + 1);
//              for (int i = 0; i < n; i++) {
//                output(perm, i);
//              }
//
//            }
//
//
//          }
//
//
//          public static void output(int[] permutation, int index){
//            for (int i = index; i < permutation.length; i++) {
//              System.out.print(permutation[i] + " ");
//            }
//            for (int i = 0; i < index; i++) {
//              System.out.print(permutation[i] + " ");
//            }
//            System.out.println();
//          }
//
//          static String next() throws IOException {
//            while (tok == null || !tok.hasMoreTokens()) {
//              tok = new StringTokenizer(f.readLine().trim());
//            }
//            return tok.nextToken();
//          }
//
//          static long nextLong() throws IOException {
//            return Long.parseLong(next());
//          }
//
//          static int nextInt() throws IOException {
//            return Integer.parseInt(next());
//          }
//
//          static double nextDouble() throws IOException {
//            return Double.parseDouble(next());
//          }
//
//          static char nextCharacter() throws IOException {
//            return next().charAt(0);
//          }
//
//          static String nextLine() throws IOException {
//            return f.readLine().trim();
//          }
//
//        }
//
//      }
//    }
//    else{
//      System.out.println(n + 1);
//      for (int i = 0; i < n; i++) {
//        output(perm, i);
//      }
//
//    }
//
//
//  }
//
//
//  public static void output(int[] permutation, int index){
//    for (int i = index; i < permutation.length; i++) {
//      System.out.print(permutation[i] + " ");
//    }
//    for (int i = 0; i < index; i++) {
//      System.out.print(permutation[i] + " ");
//    }
//    System.out.println();
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
