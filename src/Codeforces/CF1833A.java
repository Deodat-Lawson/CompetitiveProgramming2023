package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1833A {


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
        HashSet<String> allStr = new HashSet<>();

        String s = nextLine();
        for (int i = 0; i < n-1; i++) {
            allStr.add(s.substring(i,i+2));
        }
        System.out.println(allStr.size());
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
