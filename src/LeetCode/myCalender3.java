package LeetCode;

import java.io.*;
import java.util.*;

public class myCalender3 {

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


  static class MyCalendarThree {
    sparseSegmentTree thisTree;
    int max = 0;
    public MyCalendarThree() {
      thisTree = new sparseSegmentTree(1000000001);
    }

    public int book(int start, int end) {
      thisTree.change(start, end - 1, 1);
      max = Math.max(thisTree.query(start, end - 1), max);
      return max;
    }


    class sparseSegmentTree{
      //create a sparse lazy segment tree
      class Node{
        int lazy, maxVal;
        int left, right;
        Node leftChild, rightChild;
      }

      Node root;

      sparseSegmentTree(int max){
        root = new sparseSegmentTree.Node();
        root.left = 0;
        root.right = max;
        root.lazy = 0;
        root.maxVal = 0;
      }

      void change(int left, int right, int val){
        change(root, left, right, val);
      }


      void update(Node n){
        //first update the lazy tag that is previously stored in the Node
        if(n.lazy != 0){
          n.maxVal += n.lazy;

          if(n.left != n.right) {
            int middle = n.left + (n.right - n.left)/2;
            if (n.leftChild == null) {
              n.leftChild = new Node();
              n.leftChild.left = n.left;
              n.leftChild.right = middle;
              n.leftChild.lazy = n.lazy;
            }
            else{
              n.leftChild.lazy += n.lazy;
            }

            if(n.rightChild == null){
              n.rightChild = new Node();
              n.rightChild.left = middle + 1;
              n.rightChild.right = n.right;
              n.rightChild.lazy = n.lazy;
            }
            else{
              n.rightChild.lazy += n.lazy;
            }
          }
          n.lazy = 0;
        }
      }
      void change(Node n, int left, int right, int val){

        //first update the lazy tag that is previously stored in the Node
        update(n);
        //update value

        //not covered
        if(n.right < left || n.left > right){
          return;
        }

        //totally covered
        if(n.right <= right && n.left >= left){
          n.lazy += val;
          update(n);
          return;
        }

        int middle = n.left + (n.right - n.left)/2;
        if (n.leftChild == null) {
          n.leftChild = new Node();
          n.leftChild.left = n.left;
          n.leftChild.right = middle;
        }

        if(n.rightChild == null){
          n.rightChild = new Node();
          n.rightChild.left = middle + 1;
          n.rightChild.right = n.right;
        }

        change(n.leftChild, left, right, val);
        change(n.rightChild, left, right, val);
        n.maxVal = Math.max(n.maxVal, Math.max(n.leftChild.maxVal, n.rightChild.maxVal));
      }

      int query(int left, int right){
        return query(root, left, right);
      }

      int query(Node n, int left, int right){
        if(n == null){
          return 0;
        }

        update(n);
        //not covered
        if(n.left > right || n.right < left){
          return 0;
        }

        //totally covered
        if(left <= n.left && right >= n.right){
          return n.maxVal;
        }

        return Math.max(query(n.leftChild, left, right), query(n.rightChild, left, right));

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
