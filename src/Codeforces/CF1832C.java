package Codeforces;

import javax.security.auth.login.AccountException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1832C {
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
        int[] diff = new int[n-1];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        for (int i = 0; i < n-1; i++) {
            if(arr[i] < arr[i+1]){
                diff[i] = 1;
            }
            else if(arr[i] > arr[i+1]){
                diff[i] = -1;
            }
        }
        int count = n;
        int prevC = 0;
        for (int i = 0; i < diff.length; i++) {
            if(diff[i] == 0){
                count--;
            }
            else if(diff[i] == prevC){
                count--;
                prevC = diff[i];
            }
            else{
                prevC = diff[i];
            }

        }

        System.out.println(count);

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
