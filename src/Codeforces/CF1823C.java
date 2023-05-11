package Codeforces;

import java.io.*;
import java.util.*;

public class CF1823C {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;
  static boolean[] primes = new boolean[(int)Math.pow(10,7)+2];
  static ArrayList<Integer> primesList = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    getPrimes();
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(nextInt());
    }
    for (int i = 0; i < n; i++) {
      int c = list.get(i);
      if(!primes[c]){
        map.put(c, map.getOrDefault(c,0)+1);
      }
      else{
        for (int j = 0; j < primesList.size(); j++) {
          if(c%primesList.get(j) == 0){
            c/=primesList.get(j);
            map.put(primesList.get(j), map.getOrDefault(primesList.get(j),0)+1);
            if(!primes[c]){
              map.put(c, map.getOrDefault(c,0)+1);
              break;
            }
            else{
              j = -1;
            }
          }
        }
      }
    }
    int result = 0;
    int count = map.size();
    for (int a: map.values()
         ) {
      if(a%2 == 0){
        count--;
      }
      result += (a/2);
    }

    result+= (count/3);
    System.out.println(result);

  }

  public static void getPrimes(){
    primes[0] = true;
    primes[1] = true;
    for (int i = 0; i < primes.length; i++) {
      if(!primes[i]){
        for (int j = i*2; j < primes.length; j+=i) {
          primes[j] = true;
        }
        primesList.add(i);
      }
    }
    Collections.sort(primesList);


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
