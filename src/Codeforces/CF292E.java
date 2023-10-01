package Codeforces;

import java.io.*;
import java.util.*;

public class CF292E {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    int q = nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = nextInt();
    }
    
    segTree thisTree = new segTree(n, a,b);
    for (int i = 0; i < q; i++) {
      int o = nextInt();
      if(o == 1){
//        for (int j = 0; j < n; j++) {
//          System.out.print(thisTree.access(1, j) + " ");
//
//        }
//        System.out.println();

        int finalDestIndex = nextInt() - 1;
        int initialCopiedIndex = nextInt() - 1;
        int length = nextInt();
        int finalCopiedLength = initialCopiedIndex + length - 1;
        int diff = finalDestIndex - initialCopiedIndex;
        thisTree.update(initialCopiedIndex, finalCopiedLength, diff, 1);
      }
      else{
        int dest = nextInt() - 1;
        System.out.println(thisTree.access(1, dest));
      }
    }

//    for (int i = 0; i < n; i++) {
//      System.out.print(thisTree.access(1, i) + " ");
//    }
//

  }

  static class segTree{
    Node[] tree;
    int[] aVal;
    int[] bVal;

    static class Node{

      boolean isA;
      int lazyAdd;
      int indexVal;
      int left, right;
      Node(int i, int l, int r, int lz, boolean isA){
        left = l;
        right = r;
        indexVal = i;
        lazyAdd = lz;
        this.isA = isA;
      }
    }

    segTree(int n, int[] a, int[] b){
      aVal = a;
      bVal = b;
      tree = new Node[4*n];
      build(0,n-1,1);
    }

    void build(int left, int right, int index){
      if(left == right){
        tree[index] = new Node(left, left, right, Integer.MIN_VALUE, false);
        return;
      }
      tree[index] = new Node(-1, left, right, Integer.MIN_VALUE, false);
      int mid = (left + right)/2;
      build(left, mid, index * 2);
      build(mid + 1, right, index * 2 + 1);
    }

    void propUpdateIsA(int index){
      if(tree[index].isA && (tree[index].left != tree[index].right)){
        tree[index * 2].isA = true;
        tree[index * 2 + 1].isA = true;
      }
    }

    void propUpdateI(int index){
      if(tree[index].lazyAdd != Integer.MIN_VALUE){
        if(tree[index].left == tree[index].right){
          tree[index].indexVal = tree[index].left + tree[index].lazyAdd;
          tree[index].lazyAdd = Integer.MIN_VALUE;
        }
        else{
          tree[index * 2].lazyAdd = tree[index].lazyAdd;
          tree[index * 2 + 1].lazyAdd = tree[index].lazyAdd;
          tree[index].lazyAdd = Integer.MIN_VALUE;
        }
      }
    }


    void update(int left, int right, int diff, int index){//diff is calculated as (newIndexInA - oldIndexPos)
      if(left > right){
        return;
      }
      propUpdateI(index);
      propUpdateIsA(index);
      int l = tree[index].left;
      int r = tree[index].right;
      if(l >= left && r <= right){
        tree[index].lazyAdd = diff;
        tree[index].isA = true;
        propUpdateI(index);
        propUpdateIsA(index);
        return;
      }
      int mid = (l + r)/2;
      if(mid < left){
        update(left, right, diff, index * 2 + 1);
      }
      else if(mid + 1 > right){
        update(left, right, diff, index * 2);
      }
      else{
        update(left, mid, diff, index * 2);
        update(mid + 1, right, diff, index * 2 + 1);
      }
      propUpdateI(index);
      propUpdateIsA(index);
    }

    int access(int index, int dest){
      propUpdateIsA(index);
      propUpdateI(index);
      int left = tree[index].left;
      int right = tree[index].right;
      if(left == dest && right == dest){
        if(tree[index].isA){
          return aVal[tree[index].indexVal];
        }
        else{
          return bVal[tree[index].indexVal];
        }
      }
      int mid = (left + right)/2;
      int ans;
      if(dest <= mid){
        ans = access(index * 2, dest);
      }
      else{
        ans = access(index * 2 + 1, dest);
      }
      return ans;
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
