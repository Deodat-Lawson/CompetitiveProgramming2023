package LeetCode;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class TextJustification {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    String[] s = {"What","must","be","acknowledgment","shall","be"};
    System.out.println(fullJustify(s,16));
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(f.readLine().trim());
    }
    return tok.nextToken();
  }

  static public List<String> fullJustify(String[] words, int maxWidth) {
    int[] wordLength = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      wordLength[i] = words[i].length();
    }
    int[] additionalSpaceForWord = new int[words.length];

    int remainL = maxWidth;
    int currS = -1;
    int currE = -1;
    for (int i = 0; i < words.length; i++) {
      int l = wordLength[i];
      if(remainL == maxWidth){ //first element
        additionalSpaceForWord[i] = 0;
        remainL -= l;
        currS = i + 1;
        currE = -1;
      }
      else {
        if(remainL >= l + 1){ //can be put on line
          currE = i;
          remainL -= (l+1);
          additionalSpaceForWord[i] = 1;
        }
        else{

          if(currE == -1){ //one element
            String prev = words[i-1];
            for (int j = 0; j < remainL; j++) {
              prev += " ";
            }
            words[i-1] = prev;
          }
          else{ //multiple elements
            int c = 0;
            while(c < remainL){

              int res = c%(currE - currS + 1);
              additionalSpaceForWord[res + currS]++;
              c++;
            }

          }

          remainL = maxWidth;
          additionalSpaceForWord[i] = 0;
          remainL -= l;
          currS = i + 1;
          currE = -1;

        }
      }
    }

    while (remainL > 0){
      words[words.length - 1] += " ";
      remainL--;
    }

    ArrayList<String> list = new ArrayList<>();
    String s = words[0];
    for (int i = 1; i < words.length; i++) {
      if(additionalSpaceForWord[i] != 0){
        for (int j = 0; j < additionalSpaceForWord[i]; j++) {
          s+= " ";
        }
        s+= words[i];
      }
      else{
        list.add(s);
        s = "";
        s+=words[i];
      }
    }
    list.add(s);

    return list;


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
