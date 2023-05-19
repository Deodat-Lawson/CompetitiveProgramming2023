package Codeforces;

import java.io.*;
import java.util.*;

public class CF1826C {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    static int[] smallestIntNeeded = new int[1000002];
    public static void main(String[] args) throws IOException {
        build();
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    public static void solve()throws IOException{
        //Todo: write your implementation
        int n = nextInt();
        int m = nextInt();

        if(n == 1 || m == 1){
            System.out.println("Yes");
            return;
        }
        if(n <= m){
            System.out.println("No");
            return;
        }


        if(smallestIntNeeded[n] <= m){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }


    }

    public static void build(){
        Arrays.fill(smallestIntNeeded, Integer.MAX_VALUE);
        for (int i = 2; i < smallestIntNeeded.length; i++) {
            if(smallestIntNeeded[i] == Integer.MAX_VALUE){
                for (int j = 2*i; j < smallestIntNeeded.length; j+=i) {
                    smallestIntNeeded[j] = Math.min(smallestIntNeeded[j],i);
                }
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
