package Codeforces;

import java.io.*;
import java.util.*;

public class CF1808C2 {

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
    long min = nextLong();
    long max = nextLong();

    if(min == max){
      System.out.println(min);
      return;
    }

    String minS = "" + min;
    String maxS = "" + max;

    if(maxS.length() > minS.length()){
      System.out.println((long)Math.pow(10,(minS.length())) - 1);
      return;
    }

    int smallestIV = -1;
    int largestIV = -1;
    int IVIndex = -1;
    //find smallest and largest IV


    int currMax = 0;
    int currMin = 9;

    for (int i = 0; i < minS.length(); i++) {
      int minV = Integer.parseInt(minS.substring(i, i + 1));
      int maxV = Integer.parseInt(maxS.substring(i, i + 1));
      if (minV != maxV) {
        smallestIV = minV;
        largestIV = maxV;
        IVIndex = i;
        break;
      }
      currMax = Math.max(maxV, currMax);
      currMin = Math.min(maxV, currMin);
    }

    int minDiff = 9;
    int mMax = Math.max(currMax,smallestIV);
    int mMin = Math.min(currMin,smallestIV);

    int maxDiff = 9;
    int maMax = Math.max(currMax, largestIV);
    int maMin = Math.min(currMin, largestIV);

    int midDiff = 9;
    int midR = -1;


    for (int i = smallestIV; i <= largestIV ; i++) {
      if(i == smallestIV){
        for (int j = IVIndex + 1; j < minS.length(); j++) {
          int minV = Integer.parseInt(minS.substring(j,j+1));
          if(mMax - minV >= 1){
            break;
          }
          else if(mMax == minV){
            continue;
          }
          else{
            if(j != IVIndex + 1 && mMax != 9){
              mMax++;
              break;
            }
            mMax = Math.max(mMax,minV);
          }
        }
        minDiff = mMax - mMin;
      }
      else if(i == largestIV){
        for (int j = IVIndex + 1; j < minS.length(); j++) {
          int maxV = Integer.parseInt(maxS.substring(j,j+1));
          if(maxV - maMin >= 1){
            break;
          }
          else if(maMin == maxV){
            continue;
          }
          else{
            if(j != IVIndex + 1 && maMin != 0){
              maMin--;
              break;
            }
            maMin = Math.min(maMin,maxV);
          }
        }
        maxDiff = maMax - maMin;
      }
      else{
        int tMax = Math.max(i, currMax);
        int tMin = Math.min(i, currMin);
        if(tMax - tMin < midDiff){
          midDiff = tMax - tMin;
          midR = i;
        }
      }
    }

    String ans = minS.substring(0,IVIndex);

    if(midDiff < maxDiff && midDiff < minDiff && midR != -1){
      for (int j = IVIndex; j < minS.length(); j++) {
        ans += midR;
      }
    }
    else if(minDiff < maxDiff){
      ans += smallestIV;
      for (int j = IVIndex + 1; j < minS.length(); j++) {
        ans += mMax;
      }
    }
    else{
      ans += largestIV;
      for (int j = IVIndex + 1; j < minS.length(); j++) {
        ans += maMin;
      }
    }
    System.out.println(ans);










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
