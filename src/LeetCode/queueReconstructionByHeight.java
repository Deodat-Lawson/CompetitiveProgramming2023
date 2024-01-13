package LeetCode;

import kotlin.CompareToKt;

import java.io.*;
import java.util.*;

public class queueReconstructionByHeight {

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

  public int[][] reconstructQueue(int[][] people) {
    ArrayList<People> allPeople = new ArrayList<>();
    LinkedList<People> answer = new LinkedList<>();

    for (int i = 0; i < people.length; i++) {
      int height = people[i][0];
      int pplInFront = people[i][1];
      allPeople.add(new People(height, pplInFront));
    }

    Collections.sort(allPeople);
    for (int i = 0; i < allPeople.size(); i++) {
      People thisP = allPeople.get(i);
      answer.add(thisP.peopleInFront, thisP);
    }

    int[][] ans = new int[people.length][2];
    int index = 0;
    for (People p : answer
         ) {
      ans[index][0] = p.height;
      ans[index][1] = p.peopleInFront;
      index++;
    }
    return ans;

  }


  class People implements Comparable<People> {
    int height;
    int peopleInFront;

    People(int height, int peopleInFront) {
      this.height = height;
      this.peopleInFront = peopleInFront;
    }

    @Override
    public int compareTo(People o1) {
      if (height > o1.height) {
        return -1;
      } else if (height < o1.height) {
        return 1;
      } else {
        return Integer.compare(peopleInFront, o1.peopleInFront);
      }
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
