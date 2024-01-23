package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class CF1883D {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    HashMap<String, Integer> map = new HashMap<>();
    HashMap<String, Integer> startTime = new HashMap<>();
    ArrayList<Segment> allSeg = new ArrayList<>();
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      char c = nextCharacter();
      int left = nextInt();
      int right = nextInt();
      Segment s = new Segment(left, right);

      if(c == '+') {
        if (!map.containsKey(s.toS())) {
          startTime.put(s.toS(), i);
          map.put(s.toS(), 1);
        }
        else{
          map.put(s.toS(), map.get(s.toS()) + 1);
        }
      }
      else{
        map.put(s.toS(), map.get(s.toS()) - 1);
        if(map.get(s.toS()) <= 0){
          Segment newS = new Segment(s.left, s.right);
          newS.addTime = startTime.get(s.toS());
          newS.removeTime = i;
          allSeg.add(newS);
          map.remove(s.toS());
          startTime.remove(s.toS());
        }
      }

    }
    for (String s: map.keySet()
         ) {
      int left = Integer.parseInt(s.substring(0, s.indexOf(" ")));
      int right = Integer.parseInt(s.substring(s.indexOf(" ") + 1));
      Segment newS = new Segment(left, right);
      newS.addTime = startTime.get(s);
      newS.removeTime = t;
      allSeg.add(newS);
    }

    Collections.sort(allSeg, new Comparator<Segment>() {
      @Override
      public int compare(Segment o1, Segment o2) {
        return Integer.compare(o1.addTime, o2.addTime);
      }
    });

    PriorityQueue<Segment> startPQ = new PriorityQueue<>(new Comparator<Segment>() {
      @Override
      public int compare(Segment o1, Segment o2) {
        return Integer.compare(o1.right, o2.right);
      }
    });

    PriorityQueue<Segment> endPQ = new PriorityQueue<>(new Comparator<Segment>() {
      @Override
      public int compare(Segment o1, Segment o2) {
        return Integer.compare(o2.left, o1.left);
      }
    });

    int index = 0;
    for (int i = 0; i < t; i++) {
      if(index < allSeg.size()) {
        Segment s = allSeg.get(index);
        if (s.addTime == i) {
          index++;
          startPQ.add(s);
          endPQ.add(s);
        }
      }

      int largestStart = Integer.MIN_VALUE;
      while(!endPQ.isEmpty()){
        Segment thisE = endPQ.peek();
        if(thisE.removeTime <= i){
          endPQ.poll();
        }
        else{
          largestStart = thisE.left;
          break;
        }
      }

      int smallestEnd = Integer.MAX_VALUE;
      while(!startPQ.isEmpty()){
        Segment thisE = startPQ.peek();
        if(thisE.removeTime <= i){
          startPQ.poll();
        }
        else{
          smallestEnd = thisE.right;
          break;
        }
      }

      if(smallestEnd < largestStart){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
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

  static class Segment {
    int addTime;
    int removeTime;
    int left;
    int right;
    Segment(int l, int r) {
      left = l;
      right = r;
    }

    public String toS() {
      return ("" + left + " " + right);
    }
  }

}
