package LeetCode;

import java.io.*;
import java.util.*;

public class wordSearch2 {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {

  }

  static boolean[] TF;
  static char[][] boardB;

  public List<String> findWords(char[][] board, String[] words) {
    TF = new boolean[words.length];
    boardB = board;
    for (int i = 0; i < words.length; i++) {
      String currW = words[i];

      for (int j = 0; j < board.length; j++) {
        for (int k = 0; k < board[0].length; k++) {
          if(currW.charAt(0) == board[j][k]){
            boolean[][] thisBd = new boolean[board.length][board[0].length];
            thisBd[j][k] = true;

            dfs(currW, 1, thisBd, j, k, i);
          }
        }
      }

    }

    ArrayList<String> ans = new ArrayList<>();
    for (int i = 0; i < TF.length; i++) {
      if(TF[i]){
        ans.add(words[i]);
      }
    }

    return ans;


  }


  public void dfs(String s, int index, boolean[][] visited, int xPos, int yPos, int numIndex) {
    if(TF[numIndex]){
      return;
    }
    if (index == s.length()) {
      TF[numIndex] = true;
      return;
    }

    char nextVal = s.charAt(index);

    if (xPos + 1 < visited.length && !visited[xPos + 1][yPos] && boardB[xPos + 1][yPos] == nextVal) {
      visited[xPos + 1][yPos] = true;
      dfs(s, index + 1, visited, xPos + 1, yPos, numIndex);
      visited[xPos + 1][yPos] = false;
    }
    if (xPos - 1 >= 0 && !visited[xPos - 1][yPos] && boardB[xPos - 1][yPos] == nextVal) {
      visited[xPos - 1][yPos] = true;
      dfs(s, index + 1, visited, xPos - 1, yPos, numIndex);
      visited[xPos - 1][yPos] = false;
    }
    if (yPos + 1 < visited[0].length && !visited[xPos][yPos + 1] && boardB[xPos][yPos + 1] == nextVal) {
      visited[xPos][yPos + 1] = true;
      dfs(s, index + 1, visited, xPos, yPos + 1, numIndex);
      visited[xPos][yPos + 1] = false;
    }
    if (yPos - 1 >= 0 && !visited[xPos][yPos - 1] && boardB[xPos][yPos - 1] == nextVal) {
      visited[xPos][yPos - 1] = true;
      dfs(s, index + 1, visited, xPos, yPos - 1, numIndex);
      visited[xPos][yPos - 1] = false;
    }


  }


}
