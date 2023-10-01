package LeetCode;

import java.io.*;
import java.util.*;

public class myPow {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    System.out.println(myPow(0.00001,2147483647));
  }

  static HashMap<Double, Integer> memo = new HashMap<>();
  public static double myPow(double x, int n) {
    if(n == -1){
      return 1/x;
    }
    if(n == 1){
      return x;
    }
    else if(n == 0){
      return 1;
    }

    if(memo.containsKey(n)){
      return memo.get(n);
    }

    int mid = n/2;
    double res = myPow(x, mid) * myPow(x, n - mid);

    memo.put(res, n);
    return res;

  }










}
