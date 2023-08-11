package LeetCode;

import java.io.*;
import java.util.*;

public class longIncreaseSubsequence2Redo {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    longIncreaseSubsequence2Redo a = new longIncreaseSubsequence2Redo();
    int[] as = {4,2,1,4,3,4,5,8,15};
    a.lengthOfLIS(as,3);
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
  }

  public int lengthOfLIS(int[] nums, int k) {
    int[] anums = {4,2,1,4,3,4,5,8,15};
    k = 3;
    int[] valCount = new int[100001];
    segTree seg = new segTree(valCount);

    int max = 0;

    for (int i = 0; i < anums.length; i++) {
      int val = anums[i];
      int leftBound = Math.max(val - k, 1);
      int rightBound = Math.max(val - 1,leftBound);

      int count = seg.query(leftBound, rightBound, 1);
      seg.update(val, count + 1, 1);
      max = Math.max(max, count + 1);
    }

    return max;

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

  class segTree{
    Node[] segT;

    segTree(int[] v){
      segT = new Node[4 * v.length];
      for (int i = 0; i < segT.length; i++) {
        segT[i] = new Node();
      }
      build(1,v.length,1);
    }

    void build(int left, int right, int num){
      segT[num].left = left;
      segT[num].right = right;

      if(left == right){
        segT[num].Max = 0;
        return;
      }

      int mid = (left + right)/2;
      build(left, mid, 2*num);
      build(mid + 1, right, 2*num + 1);

      segT[num].Max = 0;
    }
    void update(int pos, int val, int num){
      if(segT[num].left == segT[num].right){
        segT[num].Max = val;
        return;
      }

      int mid = (segT[num].right + segT[num].left)/2;
      if(pos <= mid){
        update(pos, val, 2*num);
      }
      else{
        update(pos, val, 2*num + 1);
      }

      segT[num].Max = Math.max(segT[2*num].Max, segT[2*num + 1].Max);
    }

    int query(int left, int right, int num){
      if(segT[num].left == segT[num].right){
        return segT[num].Max;
      }
      int mid = (segT[num].left + segT[num].right)/2;

      if(left >= mid + 1){
        return query(left, right, 2*num + 1);
      }
      else if(right <= mid){
        return query(left, right, 2*num);
      }
      else{
        return Math.max(query(left, right, 2*num), query(left, right, 2*num + 1));
      }
    }


    class Node{
      int left, right;
      int Max;

      Node(){
      }
    }




  }


}
