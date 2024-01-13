package LeetCode;

import javax.swing.plaf.ProgressBarUI;
import java.io.*;
import java.util.*;

public class rangeSumQueryMutable {

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

  class NumArray {

    class Node {
      int left, right;
      int sum;
    }

    Node[] segmentTree;
    int[] nums;

    public NumArray(int[] nums) {
      segmentTree = new Node[nums.length * 4];
      this.nums = nums;
      build(0, nums.length - 1, 1);
    }

    public void build(int left, int right, int index) {
      Node thisN = new Node();
      thisN.left = left;
      thisN.right = right;
      if (left == right) {
        thisN.sum = nums[left];
        segmentTree[index] = thisN;
        return;
      }
      int mid = (left + right) / 2;
      build(left, mid, index * 2);
      build(mid + 1, right, index * 2 + 1);
      thisN.sum = segmentTree[index * 2].sum + segmentTree[index * 2 + 1].sum;
      segmentTree[index] = thisN;
    }

    public void update(int index, int val) {
      nums[index] = val;
      update(1, index, val);
    }

    public void update(int n, int index, int val) {
      if (segmentTree[n].left == segmentTree[n].right) {
        segmentTree[n].sum = val;
        return;
      }
      int mid = (segmentTree[n].left + segmentTree[n].right) / 2;
      if (mid >= index) {
        update(n * 2, index, val);
      } else {
        update(n * 2 + 1, index, val);
      }
      segmentTree[n].sum = segmentTree[n * 2].sum + segmentTree[n * 2 + 1].sum;
    }

    public int sumRange(int left, int right) {
      return sumRange(1, left, right);
    }

    public int sumRange(int n, int left, int right) {
      if (segmentTree[n].left >= left && segmentTree[n].right <= right) {
        return segmentTree[n].sum;
      }
      int mid = (segmentTree[n].left + segmentTree[n].right) / 2;
      if (mid < left) {
        return sumRange(n * 2 + 1, left, right);
      } else if (mid >= right) {
        return sumRange(n * 2, left, right);
      } else {
        return sumRange(n * 2 + 1, left, right) + sumRange(n * 2, left, right);
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
