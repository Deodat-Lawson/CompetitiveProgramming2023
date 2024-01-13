package LeetCode;

import java.io.*;
import java.util.*;

public class countTheNumberOfKBigIndices {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int[] arr = {2,3,6,5,2,3};
    kBigIndices(arr, 2);
  }

  static public int kBigIndices(int[] nums, int k) {
    HashSet<Integer> frontToBack = new HashSet<>();
    HashSet<Integer> backToFront = new HashSet<>();
    sparseSegmentTree frontToBackSeg = new sparseSegmentTree(100001);
    sparseSegmentTree backToFrontSeg = new sparseSegmentTree(100001);

    for (int i = 0; i < nums.length; i++) {
      frontToBackSeg.update(nums[i], nums[i]);
      if(frontToBackSeg.query(0, nums[i] - 1) >= k){
        frontToBack.add(i);
      }
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      backToFrontSeg.update(nums[i], nums[i]);
      if(backToFrontSeg.query(0, nums[i] - 1) >= k){
        backToFront.add(i);
      }
    }

    int count = 0;
    for (int a: frontToBack
         ) {
      if(backToFront.contains(a)){
        count++;
      }
    }
    return count;
  }

  static class sparseSegmentTree{

    class Node{
      int left, right;
      int val, lazy;
      Node leftChild, rightChild;

      Node(int left, int right){
        this.left = left;
        this.right = right;
        val = 0;
        lazy = 0;
      }
    }

    Node root;

    sparseSegmentTree(int size){
      root = new Node(0, size);
    }

    void updateLazy(Node n){
      if(n.lazy != 0){
        n.val += n.lazy * (n.right - n.left + 1);
        if(n.left != n.right) {
          int mid = (n.left + n.right)/2;
          if (n.leftChild == null) {
            n.leftChild = new Node(n.left, mid);
          }
          if(n.rightChild == null){
            n.rightChild = new Node(mid + 1, n.right);
          }
          n.leftChild.lazy = n.lazy;
          n.rightChild.lazy = n.lazy;
        }
        n.lazy = 0;
      }
    }

    void update(int left, int right){
      update(root, left, right);
    }

    void update(Node n, int left, int right){
      updateLazy(n);

      //completely covered in interval
      if(n.left >= left && n.right <= right){
        n.lazy += 1;
        updateLazy(n);
        return;
      }
      //completely not contained in interval
      if(n.left > right || n.right < left){
        return;
      }

      int mid = (n.left + n.right)/2;
      if (n.leftChild == null) {
        n.leftChild = new Node(n.left, mid);
      }
      if(n.rightChild == null){
        n.rightChild = new Node(mid + 1, n.right);
      }
      update(n.leftChild, left, right);
      update(n.rightChild, left, right);
      n.val = n.leftChild.val + n.rightChild.val;
    }

    int query(int left, int right){
      return query(root, left, right);
    }

    int query(Node n, int left, int right){
      updateLazy(n);
      //totally covered
      if(n.left >= left && n.right <= right){
        return n.val;
      }
      //not covered
      if(n.left > right || n.right < left){
        return 0;
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
