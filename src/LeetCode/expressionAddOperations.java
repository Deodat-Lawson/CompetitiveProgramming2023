package LeetCode;

import java.io.*;
import java.util.*;

public class expressionAddOperations {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    addOperators("3456237490", 9191);
  }

  static ArrayList<String> allPossibilities = new ArrayList<>();

  public static List<String> addOperators(String num, int target) {
    allPossibilities = new ArrayList<>();

    ArrayList<String> ans = new ArrayList<>();

    StringVal(0, num, num.length(), 0);

    //test outputs
    for (int i = 0; i < allPossibilities.size(); i++) {
      long a = calculate(allPossibilities.get(i));
      if (a == target) {
        ans.add(allPossibilities.get(i));
      }
    }


    for (int i = 0; i < ans.size(); i++) {
      System.out.println(ans.get(i));
    }

    return ans;

  }

  public static void StringVal(int index, String value, int maxIndex, int operations) {

    int position = index + operations + 1;
    String prevPart = value.substring(0, position);
    String afterPart = value.substring(position);

    if (afterPart.isEmpty()) {
      allPossibilities.add(value);
      return;
    }

    StringVal(index + 1, prevPart + afterPart, maxIndex, operations);
    StringVal(index + 1, prevPart + "+" + afterPart, maxIndex, operations + 1);
    StringVal(index + 1, prevPart + "-" + afterPart, maxIndex, operations + 1);
    StringVal(index + 1, prevPart + "*" + afterPart, maxIndex, operations + 1);
  }


  public static long calculate(String s) {
    ArrayList<Long> calculate = new ArrayList<>();
    ArrayList<Character> operations = new ArrayList<>();

    String currVal = "";
    for (int i = 0; i < s.length(); i++) {
      if (!(s.charAt(i) == '*' || s.charAt(i) == '+' || s.charAt(i) == '-')) {
        currVal += s.charAt(i);
      } else {
        if (currVal.charAt(0) == '0' && currVal.length() > 1) {
          return -1;
        }

        calculate.add(Long.parseLong(currVal));
        operations.add(s.charAt(i));
        currVal = "";
      }
    }

    if (currVal.charAt(0) == '0' && currVal.length() > 1) {
      return -1;
    }
    calculate.add(Long.parseLong(currVal));


    //find multiply
    for (int i = 0; i < operations.size(); i++) {
      if (operations.get(i) == '*') {
        calculate.set(i, calculate.get(i) * calculate.get(i + 1));
        calculate.remove(i + 1);
        operations.remove(i);
        i--;
      }
    }

    for (int i = 0; i < operations.size(); i++) {
      if (operations.get(i) == '+') {
        calculate.set(i, calculate.get(i) + calculate.get(i + 1));
        calculate.remove(i + 1);
        operations.remove(i);
        i--;
      } else {
        calculate.set(i, calculate.get(i) - calculate.get(i + 1));
        calculate.remove(i + 1);
        operations.remove(i);
        i--;
      }
    }

    return calculate.get(0);

  }

}
