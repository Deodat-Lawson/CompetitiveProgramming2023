package LeetCode;

import javax.swing.text.WrappedPlainView;
import java.io.*;
import java.util.*;

public class maxStrictIncreasingCellInMatrix {

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
  int[][] memo;
  public int maxIncreasingCells(int[][] mat) {
    ArrayList<Node> smallestNodeInCR = new ArrayList<>();

    memo = new int[mat.length][mat[0].length];


    Node[][] matN = new Node[mat.length][mat[0].length];

    for (int i = 0; i < mat.length; i++) {
      ArrayList<Node> smallestInRow = new ArrayList<>();

      for (int j = 0; j < mat[0].length; j++) {
        smallestInRow.add(new Node(i, j, mat[i][j]));
      }

      Collections.sort(smallestInRow);
      ArrayList<Node> currSM = new ArrayList<>();
      ArrayList<Node> curr = new ArrayList<>();

      curr.add(smallestInRow.get(0));
      smallestNodeInCR.add(smallestInRow.get(0));
      for (int j = 1; j < mat[0].length; j++) {
        if (smallestInRow.get(j - 1).val < smallestInRow.get(j).val) {
          for (int k = 0; k < curr.size(); k++) {
            curr.get(k).addAdjNode(smallestInRow.get(j));
          }
          currSM = curr;
          curr = new ArrayList<>();
          curr.add(smallestInRow.get(j));
        } else {
          curr.add(smallestInRow.get(j));
          if (!currSM.isEmpty()) {
            for (int l = 0; l < currSM.size(); l++) {
              currSM.get(l).addAdjNode(smallestInRow.get(j));
            }
          }
          else{

            smallestNodeInCR.add(smallestInRow.get(j));
          }
        }
      }

      for (int j = 0; j < smallestInRow.size(); j++) {
        Node thisN = smallestInRow.get(j);
        matN[thisN.rPos][thisN.cPos] = thisN;
      }

    }


    for (int i = 0; i < mat[0].length; i++) {
      ArrayList<Node> smallestInCol = new ArrayList<>();

      for (int j = 0; j < mat.length; j++) {
        smallestInCol.add(matN[j][i]);
      }

      Collections.sort(smallestInCol);
      ArrayList<Node> currSM = new ArrayList<>();
      ArrayList<Node> curr = new ArrayList<>();

      curr.add(smallestInCol.get(0));
      smallestNodeInCR.add(smallestInCol.get(0));

      for (int j = 1; j < mat.length; j++) {

        if (smallestInCol.get(j - 1).val < smallestInCol.get(j).val) {
          for (int k = 0; k < curr.size(); k++) {
            curr.get(k).addAdjNode(smallestInCol.get(j));
          }
          currSM = curr;
          curr = new ArrayList<>();
          curr.add(smallestInCol.get(j));
        } else {
          curr.add(smallestInCol.get(j));
          if (!currSM.isEmpty()) {
            for (int l = 0; l < currSM.size(); l++) {
              currSM.get(l).addAdjNode(smallestInCol.get(j));
            }
          }
          else{
            smallestNodeInCR.add(smallestInCol.get(j));
          }
        }
      }
    }

    int m = 0;
    for (int i = 0; i < smallestNodeInCR.size(); i++) {
      dfs(smallestNodeInCR.get(i));
      m = Math.max(m, memo[smallestNodeInCR.get(i).rPos][smallestNodeInCR.get(i).cPos]);
    }

    return m;

  }


  void dfs(Node n){
    if(memo[n.rPos][n.cPos] != 0){
      return;
    }
    if(n.adjNode.isEmpty()){
      memo[n.rPos][n.cPos] = 1;
    }
    else{
      int max = 0;
      for (int i = 0; i < n.adjNode.size(); i++) {
        Node nextN = n.adjNode.get(i);
        if(memo[nextN.rPos][nextN.cPos] != 0){
          max = Math.max(max, memo[nextN.rPos][nextN.cPos]);
        }
        else{
          dfs(nextN);
          max = Math.max(max, memo[nextN.rPos][nextN.cPos]);
        }
      }
      memo[n.rPos][n.cPos] = max + 1;
    }
  }


  class Node implements Comparable<Node> {
    int rPos, cPos;
    ArrayList<Node> adjNode;

    int val;

    Node(int rP, int cP, int val) {
      rPos = rP;
      cPos = cP;
      this.val = val;
      adjNode = new ArrayList<>();
    }

    void addAdjNode(Node i) {
      adjNode.add(i);
    }

    @Override
    public int compareTo(Node o1) {
      return Integer.compare(val, o1.val);
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
