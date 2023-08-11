package LeetCode;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class heightOfBinaryTreeAfterSubtreeRemoval {

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


  public int[] treeQueries(TreeNode root, int[] queries) {
    TreeHeight t = new TreeHeight(root);
    int[] ans = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      ans[i] = t.query(queries[i], -1, -1);
    }
    return ans;
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

  class TreeHeight{
    int[] height = new int[(int)Math.pow(10,5) + 1];
    int[] valParent = new int[(int)Math.pow(10,5) + 1];

    TreeNode[] valToNode = new TreeNode[(int)Math.pow(10,5) + 1];
    int rootT;

    TreeHeight(TreeNode root){
      rootT = root.val;
      build(root);
    }

    void build(TreeNode curr){
      valToNode[curr.val] = curr;
      int leftHeight = 0;
      int rightHeight = 0;
      if(curr.left != null){
        build(curr.left);
        leftHeight = height[curr.left.val];
        valParent[curr.left.val] = curr.val;
      }
      if(curr.right != null){
        build(curr.right);
        rightHeight = height[curr.right.val];
        valParent[curr.right.val] = curr.val;
      }
      height[curr.val] = Math.max(rightHeight, leftHeight) + 1;
    }

    int query(int val, int count, int child){
      if(count == -1){
        return query(valParent[val],0,val);
      }

      int leftHeight = 0;
      int rightHeight = 0;
      if(valToNode[val].left != null){
        if(valToNode[val].left.val != child) {
          leftHeight = height[valToNode[val].left.val];
        }
        else{
          leftHeight = count;
        }
      }
      if(valToNode[val].right != null){
        if(valToNode[val].right.val != child) {
          rightHeight = height[valToNode[val].right.val];
        }
        else{
          rightHeight = count;
        }
      }

      if(val == rootT){
        return Math.max(rightHeight, leftHeight) + 1;
      }
      else{
        return query(valParent[val],Math.max(rightHeight, leftHeight) + 1,val);
      }

    }

  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }
    TreeNode(int val) {
      this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
