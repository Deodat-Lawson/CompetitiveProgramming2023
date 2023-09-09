package Codeforces;

import java.io.*;
import java.util.*;

public class CF1861B {

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
    String a = nextLine();
    String b = nextLine();
    ArrayList<Integer> notFound = new ArrayList<>();
    ArrayList<Integer> zeroI = new ArrayList<>();
    ArrayList<Integer> oneI = new ArrayList<>();

    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        notFound.add(i);
      } else {
        if (a.charAt(i) == '0') {
          zeroI.add(i);
        } else {
          oneI.add(i);
        }
      }
    }

    if (notFound.isEmpty()) {
      System.out.println("YES");
      return;
    }


    if (zeroI.isEmpty() || zeroI.size() == 1) {
      if ((!oneI.isEmpty()) && oneI.get(0) == 0 && oneI.get(oneI.size() - 1) == a.length() - 1) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
      return;
    }

    if (oneI.isEmpty() || oneI.size() == 1) {
      if ((!zeroI.isEmpty()) && zeroI.get(0) == 0 && zeroI.get(zeroI.size() - 1) == a.length() - 1) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
      return;
    }


    if (zeroI.get(0) < notFound.get(0) && zeroI.get(zeroI.size() - 1) > notFound.get(notFound.size() - 1) || oneI.get(0) < notFound.get(0) && oneI.get(oneI.size() - 1) > notFound.get(notFound.size() - 1)) {
      System.out.println("YES");
    } else if (notFound.get(0) == 0 || notFound.get(notFound.size() - 1) == a.length() - 1) {
      System.out.println("NO");
    } else {
      if (zeroI.get(0) == 0) {
        for (int i = 1; i < a.length() - 1; i++) {
          if (zeroI.contains(i) && oneI.contains(i + 1)) {
            System.out.println("YES");
            return;
          }
        }
        System.out.println("NO");
      } else {
        for (int i = 1; i < a.length() - 1; i++) {
          if (oneI.contains(i) && zeroI.contains(i + 1)) {
            System.out.println("YES");
            return;
          }
        }
        System.out.println("NO");
      }


  }


}


  static int bSearchLargerIndex(int val, ArrayList<Integer> list) {
    int ans = -1;
    int left = 0;
    int right = list.size() - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (list.get(mid) < val) {
        left = mid + 1;
      } else {
        ans = list.get(mid);
        right = mid - 1;
      }
    }
    return ans;

  }

  static int bSearchSmallerIndex(int val, ArrayList<Integer> list) {
    int ans = -1;
    int left = 0;
    int right = list.size() - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (list.get(mid) < val) {
        ans = list.get(mid);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;

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
