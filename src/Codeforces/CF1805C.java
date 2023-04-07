package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1805C {
  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();

    ArrayList<Integer> positives = new ArrayList<>();
    ArrayList<Integer> negatives = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int val = nextInt();
      if(val >= 0){
        positives.add(val);
      }
      if(val <= 0){
        negatives.add(val);
      }
    }
    Collections.sort(negatives);
    Collections.sort(positives);
    ArrayList<Integer> testList = new ArrayList<>();

    if(!negatives.isEmpty()){
      testList.add(negatives.get(0));
      testList.add(negatives.get(negatives.size()-1));
    }
    if(!positives.isEmpty()){
      testList.add(positives.get(0));
      testList.add(positives.get(positives.size()-1));
    }


    for (int i = 0; i < m; i++) {
      long a = nextLong();
      long b = nextLong();
      long c = nextLong();


      boolean flag = false;
      for (int j = 0; j < testList.size(); j++) {
        int curr = testList.get(j);
        long ans = b-curr;
        if(ans*ans - (4*a*c) < 0){
          System.out.println("YES");
          System.out.println(curr);
          flag = true;
          break;
        }
      }

      if(!flag){
        System.out.println("NO");
      }
    }

  }

  static String next () throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(f.readLine().trim());
    }
    return tok.nextToken();
  }

  static long nextLong () throws IOException {
    return Long.parseLong(next());
  }

  static int nextInt () throws IOException {
    return Integer.parseInt(next());
  }

  static double nextDouble () throws IOException {
    return Double.parseDouble(next());
  }

  static char nextCharacter () throws IOException {
    return next().charAt(0);
  }

  static String nextLine () throws IOException {
    return f.readLine().trim();
  }

}

