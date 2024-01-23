package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class CF1894B {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve()throws IOException{
    int n = nextInt();
    ArrayList<Integer>[] indicesCount = new ArrayList[101];
    for (int i = 0; i < 101; i++) {
      indicesCount[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      int val = nextInt();
      indicesCount[val].add(i);
    }
    int firstPairSecondElement = -1;
    int secondPairSecondElement = -1;

    for (int i = 0; i < indicesCount.length; i++) {
      if(firstPairSecondElement != -1 && secondPairSecondElement != -1){
        break;
      }
      if(indicesCount[i].size() >= 2){
        if(firstPairSecondElement == -1){
          firstPairSecondElement = indicesCount[i].get(0);
        }
        else if(secondPairSecondElement == -1){
          secondPairSecondElement = indicesCount[i].get(0);
        }
      }
    }
    if(firstPairSecondElement == -1 || secondPairSecondElement == -1){
      System.out.println("-1");
      return;
    }


    for (int i = 0; i < n; i++) {
      if(i == firstPairSecondElement){
        System.out.print("2 ");
      }
      else if(i == secondPairSecondElement){
        System.out.print("3 ");
      }
      else{
        System.out.print("1 ");
      }
    }
    System.out.println();
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
