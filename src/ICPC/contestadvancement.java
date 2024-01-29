package ICPC;

import java.io.*;
import java.util.*;

public class contestadvancement {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int k = nextInt();
    int c = nextInt();
    ArrayList<teamP> qualify = new ArrayList<>();

    boolean[] qualified = new boolean[n];

    int[] teamID = new int[n];
    int[] schoolID = new int[n];

    int[] schoolCount = new int[100001];

    for (int i = 0; i < n; i++) {
      int t = nextInt();
      int s = nextInt();
      teamID[i] = t;
      schoolID[i] = s;
    }

    for (int i = 0; i < n; i++) {
      int currSID = schoolID[i];
      if(schoolCount[currSID] < c){
        schoolCount[currSID]++;
        qualify.add(new teamP(teamID[i], i));
        qualified[i] = true;
      }
    }


    for (int i = 0; qualify.size() < k; i++) {
      if(!qualified[i]){
        qualify.add(new teamP(teamID[i], i));
      }
    }

    Collections.sort(qualify);

    for (int i = 0; i < k; i++) {
      System.out.println(qualify.get(i).teamID);
    }
  }

  static class teamP implements Comparable<teamP>{
    int teamID, rank;
    teamP(int teamID, int rank){
      this.teamID = teamID;
      this.rank = rank;
    }
    @Override
    public int compareTo(teamP o) {
      return Integer.compare(rank, o.rank);
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
