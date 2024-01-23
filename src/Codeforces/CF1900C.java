package Codeforces;

import java.io.*;
import java.util.*;

public class CF1900C {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  static Node[] allNodes;
  static ArrayList<Integer> postOrder;

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    // 0 is the root;
    allNodes = new Node[n];
    String s = nextLine();
    for (int i = 0; i < n; i++) {
      allNodes[i] = new Node(i, s.charAt(i));
    }
    for (int i = 0; i < n; i++) {
      allNodes[i].left = nextInt() - 1;
      allNodes[i].right = nextInt() - 1;
    }
    postOrder = new ArrayList<>();
    Post(0);

    int[] allS = new int[n];
    for (int i = 0; i < postOrder.size(); i++) {
      if(allNodes[postOrder.get(i)].val == 'L'){
        int minVal = Integer.MAX_VALUE;
        int left = allNodes[postOrder.get(i)].left;
        int right = allNodes[postOrder.get(i)].right;
        if(left >= 0){
          minVal = allS[left];
        }
        if(right >= 0){
          minVal = Math.min(minVal, allS[right] + 1);
        }
        if(minVal == Integer.MAX_VALUE){
          minVal = 0;
        }
        allS[postOrder.get(i)] = minVal;
      }

      else if(allNodes[postOrder.get(i)].val == 'R'){
        int minVal = Integer.MAX_VALUE;
        int left = allNodes[postOrder.get(i)].left;
        int right = allNodes[postOrder.get(i)].right;
        if(left >= 0){
          minVal = allS[left] + 1;
        }
        if(right >= 0){
          minVal = Math.min(minVal, allS[right]);
        }
        if(minVal == Integer.MAX_VALUE){
          minVal = 0;
        }
        allS[postOrder.get(i)] = minVal;
      }

      else{
        int minVal = Integer.MAX_VALUE;
        int left = allNodes[postOrder.get(i)].left;
        int right = allNodes[postOrder.get(i)].right;
        if(left >= 0){
          minVal = allS[left] + 1;
        }
        if(right >= 0){
          minVal = Math.min(minVal, allS[right] + 1);
        }
        if(minVal == Integer.MAX_VALUE){
          minVal = 0;
        }
        allS[postOrder.get(i)] = minVal;
      }


    }

    System.out.println(allS[0]);


  }
  static void Post(int curr){
    Node thisN = allNodes[curr];
    if(thisN.left > 0){
      Post(thisN.left);
    }
    if(thisN.right > 0){
      Post(thisN.right);
    }
    postOrder.add(curr);
  }

  static class Node{
    int left, right;
    int ind;
    char val;
    Node (int ind, char c) {
      this.ind = ind;
      val = c;
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
