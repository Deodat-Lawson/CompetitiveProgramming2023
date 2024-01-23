package LeetCode;

import java.io.*;
import java.security.Key;
import java.util.*;

public class freedomTrail {

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


  public int findRotateSteps(String ring, String key) {
    int size = ring.length();
    ArrayList<Integer>[] indexMap = new ArrayList[26];
    for (int i = 0; i < 26; i++) {
      indexMap[i] = new ArrayList<>();
    }
    for (int i = 0; i < ring.length(); i++) {
      char c = ring.charAt(i);
      indexMap[c - 'a'].add(i);
    }

    ArrayList<Pair>[] keyPairList = new ArrayList[key.length()];
    for (int i = 0; i < key.length(); i++) {
      keyPairList[i] = new ArrayList<>();
    }

    int firstCharacter = key.charAt(0) - 'a';
    for (int i = 0; i < indexMap[firstCharacter].size(); i++) {
      int prevIndex = 0;
      int currentIndex = indexMap[firstCharacter].get(i);
      int diff;
      if(currentIndex > prevIndex){
        diff = Math.min(currentIndex - prevIndex + 1, prevIndex + size - currentIndex + 1);
      }
      else if(prevIndex > currentIndex){
        diff = Math.min(prevIndex - currentIndex + 1, currentIndex + size - prevIndex + 1);
      }
      else{
        diff = 1;
      }
      keyPairList[0].add(new Pair(currentIndex, diff));
    }

    for (int i = 1; i < key.length(); i++) {
      int currentCharacter = key.charAt(i) - 'a';

      for (int j = 0; j < indexMap[currentCharacter].size(); j++) {
        int currentIndex = indexMap[currentCharacter].get(j);
        int minV = Integer.MAX_VALUE;

        for (int k = 0; k < keyPairList[i-1].size(); k++) {
          Pair currentPair = keyPairList[i-1].get(k);
          int prevIndex = currentPair.index;
          int prevV = currentPair.count;
          int diff;
          if(currentIndex > prevIndex){
            diff = prevV + Math.min(currentIndex - prevIndex + 1, prevIndex + size - currentIndex + 1);
          }
          else if(prevIndex > currentIndex){
            diff = prevV + Math.min(prevIndex - currentIndex + 1, currentIndex + size - prevIndex + 1);
          }
          else{
            diff = prevV + 1;
          }
          minV = Math.min (minV, diff);
        }
        keyPairList[i].add(new Pair(currentIndex, minV));
      }
    }

    int minC = Integer.MAX_VALUE;
    for (int i = 0; i < keyPairList[keyPairList.length - 1].size(); i++) {
      minC = Math.min(minC, keyPairList[keyPairList.length - 1].get(i).count);
    }
    return minC;

  }


  class Pair{
    int index, count;
    Pair(int i, int c) {
      index = i;
      count = c;
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
