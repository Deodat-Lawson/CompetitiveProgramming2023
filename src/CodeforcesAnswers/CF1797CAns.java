package CodeforcesAnswers;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.*;

public class CF1797CAns {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StreamTokenizer st = new StreamTokenizer(br);
  static PrintWriter OUT = new PrintWriter(new BufferedOutputStream(System.out));

  public static int nextInt() throws Exception {
    st.nextToken();
    return (int) st.nval;
  }

  public static double nextDouble() throws Exception {
    st.nextToken();
    return st.nval;
  }

  public static String nextStr() throws Exception {
    st.nextToken();
    return st.sval;
  }

  public static String nextLine() throws Exception {
    return br.readLine();
  }

  public static String replace(String s, int i, char c) {
    char[] arr = s.toCharArray();
    arr[i] = c;
    String s1 = String.valueOf(arr);
    return s1;
  }

  public static void main(String[] args) throws Exception {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      int n = nextInt();
      int m = nextInt();
      System.out.printf("? %d %d%n", 1, m);
      System.out.flush();
      int first = nextInt();
      System.out.printf("? %d %d%n", n, 1);
      System.out.flush();
      int second = nextInt();

      if (n >= m) {
        System.out.printf("? %d %d%n", first + 1, m);
        System.out.flush();
        int c = nextInt();
        System.out.printf("! %d %d%n", c == first ? n - second : first + 1, m - c);
      } else {
        System.out.printf("? %d %d%n", 1, m - first);
        System.out.flush();
        int c = nextInt();
        System.out.printf("! %d %d%n", c + 1, c == first ? second + 1 : m - first);
      }
    }
  }
}
 
 