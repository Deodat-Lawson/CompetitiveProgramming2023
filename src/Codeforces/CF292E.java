package Codeforces;

import java.io.*;
import java.util.*;

public class CF292E {

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

  }


  static class segTree{
    int n;
    Node[] allN;
    class Node{
      int left, right;
      int val;

      Node(int left, int right){
        this.left = left;
        this.right = right;
        val = 0;
      }
    }

    segTree(int n){
      this.n = n;
      allN = new Node[n*4 + 1];
      build(0, n-1, 1);
    }

    void build(int l, int r, int index){
      Node n = new Node(l, r);
      allN[index] = n;
      if(l != r){
        int mid = (l + r)/2;
        build(l, mid, index * 2);
        build(mid + 1, n.right, index * 2 + 1);
      }
    }

    void update(int left, int right, int index){
      int indLeft = allN[index].left;
      int indRight = allN[index].right;

      if(indLeft == left && indRight == right){

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
