package Codeforces;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class CF1840E {

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
    String s1 = nextLine();
    String s2 = nextLine();
    int characterBlockTime = nextInt();
    int queries = nextInt();

    TreeSet<Integer> differenceIndices = new TreeSet<>();

    char[] s1toC = new char[s1.length()];
    char[] s2toC = new char[s2.length()];
    for (int i = 0; i < s1toC.length; i++) {
      s1toC[i] = s1.charAt(i);
      s2toC[i] = s2.charAt(i);

      if(s1toC[i] != s2toC[i]){
        differenceIndices.add(i);
      }
    }



    int[] add = new int[queries + 1];

    for (int i = 0; i < add.length; i++) {
      add[i] = -1;
    }

    for (int i = 0; i < queries; i++) {
      int qVal = nextInt();

      if(add[i] != -1){
        if(s1toC[add[i]] != s2toC[add[i]]){
          differenceIndices.add(add[i]);
        }
      }
      if(qVal == 1){
        int indexBlock = nextInt() - 1;
        if(i + characterBlockTime < add.length){
          add[i + characterBlockTime] = indexBlock;
        }
        if(differenceIndices.contains(indexBlock)){
          differenceIndices.remove(indexBlock);
        }
      }
      else if(qVal == 2){
        int string1N = nextInt();
        int string1I = nextInt() - 1;
        int string2N = nextInt();
        int string2I = nextInt() - 1;

        if(string1N == 1 && string2N == 1){
          char temp = s1toC[string1I];
          s1toC[string1I] = s1toC[string2I];
          s1toC[string2I] = temp;
        }
        else if(string1N == 2 && string2N == 1){
          char temp = s2toC[string1I];
          s2toC[string1I] = s1toC[string2I];
          s1toC[string2I] = temp;
        }
        else if(string1N == 1 && string2N == 2){
          char temp = s1toC[string1I];
          s1toC[string1I] = s2toC[string2I];
          s2toC[string2I] = temp;
        }
        else{
          char temp = s2toC[string1I];
          s2toC[string1I] = s2toC[string2I];
          s2toC[string2I] = temp;
        }

        if(s1toC[string1I] == s2toC[string1I]){
          differenceIndices.remove(string1I);
        }
        else{
          differenceIndices.add(string1I);
        }


        if(s1toC[string2I] == s2toC[string2I]){
          differenceIndices.remove(string2I);
        }
        else{
          differenceIndices.add(string2I);
        }
      }
      else{
        if(differenceIndices.isEmpty()){
          System.out.println("YES");
        }
        else{
          System.out.println("NO");
        }
      }


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
