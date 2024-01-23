package Codeforces;

import java.io.*;
import java.util.*;

public class CF1920B {

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
    int n = nextInt();
    int k = nextInt();
    int x = nextInt();

    ArrayList<Integer> allNumbers = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      allNumbers.add(nextInt());
    }
    Collections.sort(allNumbers);
    Collections.reverse(allNumbers);
    for (int i = 0; i < x; i++) {
      allNumbers.set(i, allNumbers.get(i) * -1);
    }
    Collections.sort(allNumbers);
    Collections.reverse(allNumbers);

    LinkedList<Integer> modPos = new LinkedList<>();
    LinkedList<Integer> modNeg = new LinkedList<>();
    long sum = 0;
    for (int i = 0; i < allNumbers.size(); i++) {
      sum += allNumbers.get(i);
      if (allNumbers.get(i) >= 0) {
        modPos.addLast(allNumbers.get(i));
      } else {
        modNeg.addLast(allNumbers.get(i));
      }
    }
    long maxVal = sum;
    for (int i = 0; i < k; i++) {
      int remVal, chgVal;
      if (!modPos.isEmpty()) {
        chgVal = modPos.removeFirst();
        modNeg.addFirst(chgVal * -1);
        remVal = modNeg.removeLast();
        sum -= remVal;
        sum -= 2 * chgVal;
      }
      else{
        chgVal = modNeg.removeLast();
        sum -= chgVal;
      }
      maxVal = Math.max(maxVal, sum);
    }
    System.out.println(maxVal);
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
