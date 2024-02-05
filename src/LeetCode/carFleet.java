package LeetCode;

import java.io.*;
import java.util.*;

public class carFleet {

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
    int[] p = {6,8};
    int[] s = {3,2};
    carFleet(10,p, s);
  }

  public static int carFleet(int target, int[] position, int[] speed) {
    ArrayList<Car> allCars = new ArrayList<>();
    double time = -1;
    for (int i = 0; i < position.length; i++) {
      allCars.add(new Car(speed[i], position[i]));
    }
    Collections.sort(allCars);
    int count = 0;
    for (int i = 0; i < allCars.size(); i++) {
      Car curr = allCars.get(i);
      double val = (double)(target - curr.pos)/ (double) curr.speed;
      if(val > time){
        count++;
        time = val;
      }
    }
    return count;

  }

  static class Car implements Comparable<Car>{
    int speed;
    int pos;

    Car(int speed, int pos){
      this.speed = speed;
      this.pos = pos;
    }

    @Override
    public int compareTo(Car o){
      return Integer.compare(o.pos, pos);
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
