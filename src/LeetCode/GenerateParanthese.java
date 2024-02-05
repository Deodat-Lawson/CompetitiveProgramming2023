package LeetCode;

import java.io.*;
import java.util.*;

public class GenerateParanthese {

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

  public List<String> generateParenthesis(int n) {
    ArrayList<StringParan> current = new ArrayList<>();
    current.add(new StringParan("", 0));

    for (int i = 0; i < n*2; i++) {
      ArrayList<StringParan> newArr = new ArrayList<>();
      for (int j = 0; j < current.size(); j++) {
        StringParan currParan = current.get(j);
        if(currParan.val > 0){
          newArr.add(new StringParan(currParan.currentP + ")", currParan.val - 1));
        }
        newArr.add(new StringParan(currParan.currentP + "(", currParan.val + 1));
      }
      current = newArr;
    }



    ArrayList<String> goodList = new ArrayList<>();
    for (int i = 0; i < current.size(); i++) {
      System.out.println(current.get(i).currentP);
      if(current.get(i).val == 0){
        goodList.add(current.get(i).currentP);
      }
    }
    return goodList;

  }

  class StringParan{
    String currentP;
    int val;
    StringParan(String str, int i){
      currentP = str;
      val = i;
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
