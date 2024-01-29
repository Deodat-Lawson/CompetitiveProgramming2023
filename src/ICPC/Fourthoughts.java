package ICPC;

import java.io.*;
import java.security.KeyStore;
import java.util.*;

public class Fourthoughts {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  static HashMap<Integer, String> allVals = new HashMap<>();
  static ArrayList<String> allPosOp = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    initialization();
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    if(allVals.containsKey(n)){
      String ans = allVals.get(n);
      System.out.println("4 " + ans.substring(0,1) + " 4 " + ans.substring(1, 2) + " 4 " + ans.substring(2, 3) + " 4 = " + n);
    }
    else{
      System.out.println("no solution");
    }

  }


  static void initialization(){
    for (int i = 0; i < 4; i++) {
      String a = "";
      a = modified(a, i);
      for (int j = 0; j < 4; j++) {
        String b = a;
        b = modified(b, j);
        for (int k = 0; k < 4; k++) {
          String c = b;
          c = modified(c, k);
          allPosOp.add(c);
        }
      }
    }

    for (int i = 0; i < allPosOp.size(); i++) {
      ArrayList<Integer> elements = new ArrayList<>();
      for (int j = 0; j < 4; j++) {
        elements.add(4);
      }
      String operation = allPosOp.get(i);
      for (int j = 0; j < operation.length(); j++) {
        String currO = operation.substring(j, j+1);

        if(currO.equals("/")){
          elements.set(j, elements.get(j)/elements.get(j + 1));
          elements.remove(j + 1);
          if(operation.length() > 1) {
            operation = operation.substring(0, j) + operation.substring(j + 1);
          } else{
            break;
          }
          j--;
        }
        else if(currO.equals("*")){
          elements.set(j, elements.get(j) * elements.get(j + 1));
          elements.remove(j + 1);
          if(operation.length() > 1) {
            operation = operation.substring(0, j) + operation.substring(j + 1);
          } else {
            break;
          }
          j--;
        }
      }

      for (int j = 0; j < operation.length(); j++) {
        String currO = operation.substring(j, j+1);

        if(currO.equals("+")){
          elements.set(j, elements.get(j) + elements.get(j + 1));
          elements.remove(j + 1);
          if(operation.length() > 1) {
            operation = operation.substring(0, j) + operation.substring(j + 1);
          } else{
            break;
          }
          j--;
        }
        else if(currO.equals("-")){
          elements.set(j, elements.get(j) - elements.get(j + 1));
          elements.remove(j + 1);
          if(operation.length() > 1) {
            operation = operation.substring(0, j) + operation.substring(j + 1);
          }
          else{
            break;
          }
          j--;
        }
      }

      int finalV = elements.get(0);
      if(!allVals.containsKey(finalV)){
        allVals.put(finalV, allPosOp.get(i));
      }
    }

  }

  static String modified(String og, int i){
    String n = og;
    if(i == 0){
      n += "+";
    }
    else if(i == 1){
      n += "-";
    }
    else if(i == 2){
      n += "*";
    }
    else{
      n+="/";
    }
    return n;
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
