package LeetCode;
public class palidromeSubstrings {

  public int countSubstrings(String s) {
    boolean[][] dpTable = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j + i < s.length(); j++) {
        int start = j;
        int end = i + j;
        if(start == end){
          dpTable[start][end] = true;
        }
        else{
          if(s.substring(start, start+ 1).equals(s.substring(end, end + 1))){
            if(i == 1){
              dpTable[start][end] = true;
            }
            else{
              dpTable[start][end] = dpTable[start + 1][end - 1];
            }
          }
          else{
            dpTable[start][end] = false;
          }
        }
      }
    }

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
        if(dpTable[i][j]){
          count++;
        }
      }
    }
    return count;
  }
}
