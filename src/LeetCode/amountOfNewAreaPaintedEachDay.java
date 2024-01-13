package LeetCode;

import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class amountOfNewAreaPaintedEachDay {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    int[][] a = {{0,2}, {0,5}, {2,4}, {2,3}};
    amountPainted(a);
  }

  public static int[] amountPainted(int[][] paint) {
    sparseSegmentTree sSegmentTree = new sparseSegmentTree(50002);
    int[] arr = new int[paint.length];
    for (int i = 0; i < paint.length; i++) {
      arr[i] = sSegmentTree.query(sSegmentTree.root, paint[i][0], paint[i][1] - 1);
      sSegmentTree.update(sSegmentTree.root, paint[i][0], paint[i][1] - 1);
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    return arr;
  }

  static class sparseSegmentTree {

    class Node {
      int left, right;
      boolean tf = false;
      int fCount;
      Node leftChild, rightChild;

      Node(int left, int right){
        this.left = left;
        this.right = right;
        fCount = right - left + 1;
      }
    }

    Node root;

    public sparseSegmentTree(int size) {
      root = new Node(0, size + 1);
    }

    public void update(Node n, int left, int right) {

      //first we update lazy
      if (n.tf) {
        n.fCount = 0;
        if(n.left == n.right){
          return;
        }
        int mid = (n.left + n.right) / 2;
        if (n.leftChild == null) {
          n.leftChild = new Node(n.left, mid);
        }
        if (n.rightChild == null) {
          n.rightChild = new Node(mid + 1, n.right);
        }
        n.leftChild.tf = true;
        n.leftChild.fCount = 0;
        n.rightChild.tf = true;
        n.rightChild.fCount = 0;
      }


      if (left <= n.left && right >= n.right) {
        n.tf = true;
        n.fCount = 0;
        return;
      }
      if (n.right < left || n.left > right) {
        return;
      }


      int mid = (n.left + n.right) / 2;
      if (n.leftChild == null) {
        n.leftChild = new Node(n.left, mid);
      }
      if (n.rightChild == null) {
        n.rightChild = new Node(mid + 1, n.right);
      }


      update(n.leftChild, left, right);
      update(n.rightChild, left, right);

      n.fCount = n.leftChild.fCount + n.rightChild.fCount;
    }

    public int query(Node n, int left, int right) {

      if (n.tf) {
        n.fCount = 0;
        int mid = (n.left + n.right) / 2;
        if(n.left == n.right){
          return 0;
        }
        if (n.leftChild == null) {
          n.leftChild = new Node(n.left, mid);
        }
        if (n.rightChild == null) {
          n.rightChild = new Node(mid + 1, n.right);
        }
        n.leftChild.tf = true;
        n.leftChild.fCount = 0;
        n.rightChild.tf = true;
        n.rightChild.fCount = 0;
      }

      if (n.right < left || n.left > right) {
        return 0;
      }
      if (left <= n.left && right >= n.right) {
        return n.fCount;
      }


      int mid = (n.left + n.right) / 2;
      if (n.leftChild == null) {
        n.leftChild = new Node(n.left, mid);
      }
      if (n.rightChild == null) {
        n.rightChild = new Node(mid + 1, n.right);
      }

      return query(n.leftChild, left, right) + query(n.rightChild, left, right);
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
