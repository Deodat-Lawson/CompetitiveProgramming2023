package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1828B {


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
        int[] arr = new int[n];

        int largest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int pos = nextInt() - 1;
            arr[pos] = i;
        }

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(arr[i] - (i));
            if(largest == Integer.MAX_VALUE){
                largest = diff;
            }
            else{
                largest = gcd(largest,diff);
            }
        }

        System.out.println(largest);


    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
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
