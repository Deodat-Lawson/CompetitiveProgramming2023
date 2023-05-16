package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF1818C {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        int n = nextInt();
        ArrayList<Integer> allNum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            allNum.add(nextInt());
        }

        ArrayList<CF1818CSegment> decreasingSeg = new ArrayList<>();

        int prevIndex = 0;
        for (int i = 1; i < n; i++) {
            if(allNum.get(i) > allNum.get(i-1)){
                decreasingSeg.add(new CF1818CSegment(prevIndex,i));
                prevIndex = i;
            }
        }

        int query = nextInt();


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

class CF1818CSegment{
    int l;
    int r;

    CF1818CSegment(int l, int r){
        this.l = l;
        this.r = r;
    }
}
