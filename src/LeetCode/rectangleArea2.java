//package LeetCode;
//
//import javax.print.DocFlavor;
//import java.io.*;
//import java.util.*;
//
//public class rectangleArea2 {
//
//  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//  static StringTokenizer tok;
//
//  public static void main(String[] args) throws IOException {
//    solve();
//  }
//
//  public static void solve() throws IOException {
//    //Todo: write your implementation
//  }
//
//
//  //this implementation is wrong?
//
//
//  class twoDimensionalSparseLazySegmentTree{
//
//    class Node{
//      int leftD1, rightD1;
//      int leftD2, rightD2;
//
//      Node leftD1Child;
//      Node rightD1Child;
//      Node leftD2Child;
//      Node rightD2Child;
//
//      int lazy;
//      int val;
//
//      Node(int leftD1, int rightD1, int leftD2, int rightD2){
//        this.leftD1 = leftD1;
//        this.rightD1 = rightD1;
//        this.leftD2 = leftD2;
//        this.rightD2 = rightD2;
//        lazy = 0;
//        val = 0;
//      }
//
//      int size(){
//        int s = (rightD1 - leftD1 + 1) * (rightD2 - leftD2 + 1);
//        return s;
//      }
//    }
//
//    Node root;
//
//    twoDimensionalSparseLazySegmentTree(int D1max, int D2max){
//      root = new Node(0, D1max, 0, D2max);
//    }
//
//
//    void lazyUpdate(Node n){
//      if(n.lazy != 0){
//        n.val += (n.size() * n.lazy);
//
//        if(n.leftD1 != n.rightD1) {
//          int midD1 = (n.leftD1 + n.rightD1)/2;
//          if(n.leftD1Child == null){
//            n.leftD1Child = new Node(n.leftD1, midD1, n.leftD2, n.rightD2);
//            n.leftD1Child.lazy = n.lazy;
//          }
//          if(n.rightD1Child == null){
//            n.rightD1Child = new Node(midD1 + 1, n.rightD2, n.leftD2, n.rightD2);
//            n.rightD1Child.lazy = n.lazy;
//          }
//        }
//
//        if(n.leftD2 != n.rightD2){
//          int midD2 = (n.leftD2 + n.rightD2)/2;
//          if(n.leftD2Child == null){
//            n.leftD2Child = new Node(n.leftD1, n.leftD2, n.leftD2, midD2);
//            n.leftD2Child.lazy = n.lazy;
//          }
//          if(n.rightD2Child == null){
//            n.rightD2Child = new Node(n.leftD1, n.rightD1, midD2 + 1, n.rightD2);
//            n.rightD2Child.lazy = n.lazy;
//          }
//        }
//        n.lazy = 0;
//      }
//    }
//    void update(Node n, int d1Start, int d1End, int d2Start, int d2End){
//      lazyUpdate(n);
//
//      //if totally completely overlapped we update the lazy tag
//      if(n.leftD1 >= d1Start && n.rightD1 <= d1End && n.leftD2 >= d2Start && n.rightD2 <= d2End){
//        n.lazy = 1;
//        lazyUpdate(n);
//        return;
//      }
//
//      //if no overlap, we don't update anything
//      if(n.leftD1 > d1End || n.rightD1 < d1Start || n.leftD2 > d2End || n.rightD2 < d1Start){
//        return;
//      }
//
//      //otherwise split into four and update each section
//      if(n.leftD1 != n.rightD1){
//        int midD1 = (n.leftD1 + n.rightD1)/2;
//        if(n.leftD1Child == null){
//          n.leftD1Child = new Node(n.leftD1, midD1, n.leftD2, n.rightD2);
//          n.leftD1Child.lazy = n.lazy;
//
//        }
//        if(n.rightD1Child == null){
//          n.rightD1Child = new Node(midD1 + 1, n.rightD2, n.leftD2, n.rightD2);
//          n.rightD1Child.lazy = n.lazy;
//        }
//      }
//
//      if(n.rightD1 != n.rightD2){
//        int midD2 = (n.leftD2 + n.rightD2)/2;
//        if(n.leftD2Child == null){
//          n.leftD2Child = new Node(n.leftD1, n.leftD2, n.leftD2, midD2);
//          n.leftD2Child.lazy = n.lazy;
//        }
//        if(n.rightD2Child == null){
//          n.rightD2Child = new Node(n.leftD1, n.rightD1, midD2 + 1, n.rightD2);
//          n.rightD2Child.lazy = n.lazy;
//        }
//      }
//
//    }
//
//    int combine(Node n){
//      int sum = 0;
//      if(n.leftD1Child != null){
//        sum += n.leftD1Child.val;
//      }
//      if(n.rightD1Child != null){
//        sum += n.rightD1Child.val;
//      }
//      if(n.rightD2Child != null){
//
//      }
//    }
//
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
