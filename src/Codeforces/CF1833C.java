package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF1833C {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    public static void solve()throws IOException{
        //Todo: write your implementation
        int n = nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int smallestEven = Integer.MAX_VALUE;
        int smallestOdd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            list.add(nextInt());
        }
        Collections.sort(list);
        if(list.get(0)%2 == 0) {
            for (int i = 0; i < n; i++) {
                if(list.get(i)%2 == 0){
                    smallestEven = Math.min(smallestEven,list.get(i));
                }
                else{
                    if(list.get(i) <= smallestOdd){
                        System.out.println("No");
                        return;
                    }
                    smallestOdd = Math.min(smallestOdd,list.get(i));
                }
            }
            System.out.println("Yes");
        }
        else{
            for (int i = 0; i < n; i++) {
                if(list.get(i)%2 == 0){
                    if(list.get(i) <= smallestOdd){
                        System.out.println("No");
                        return;
                    }
                    smallestEven = Math.min(smallestEven,list.get(i));
                }
                else{
                    smallestOdd = Math.min(smallestOdd,list.get(i));
                }
            }
            System.out.println("Yes");
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
