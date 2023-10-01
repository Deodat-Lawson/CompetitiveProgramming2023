package Luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2147 {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {


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

  class linkCutTree{

    class Node{
      int parent, leftC, rightC;
      int key;
      boolean tag;
    }

    Node[] tree;

    void pushDown(int x){
      Node thisN = tree[x];
      if(thisN.tag){
        //swap two children
        int t = thisN.leftC;
        thisN.leftC = thisN.rightC;
        thisN.rightC = t;
        tree[thisN.leftC].tag = !tree[thisN.leftC].tag;
        tree[thisN.rightC].tag = !tree[thisN.rightC].tag;
      }
      thisN.tag = false;
    }

    void rotate(int x){
      Node thisN = tree[x];
      int y = thisN.parent;
      int z = tree[y].parent;

      boolean k = (tree[y].rightC == x);

      if (tree[z].leftC == y || tree[z].rightC == y){ //meaning that z is not separate trees
        if(tree[z].leftC == y){
          tree[z].leftC = x;
        }
        else{
          tree[z].rightC = x;
        }
      }
      tree[x].parent = z;

      if(k){ //if x is the right child of y
        tree[y].rightC = tree[x].leftC;
        tree[tree[x].leftC].parent = y;
        tree[x].leftC = y;
      }
      else{
        tree[y].leftC = tree[x].rightC;
        tree[tree[x].rightC].parent = y;
        tree[x].rightC = y;
      }
      tree[y].parent = x;

    }

    void pushAll(int x){
      Node thisNode = tree[x];
      if(tree[thisNode.parent].rightC == x || tree[thisNode.parent].leftC == x){
        pushAll(thisNode.parent);
      }
      pushDown(x);
    }

    void splay(int x){
      pushAll(x);
      
    }




  }





}
