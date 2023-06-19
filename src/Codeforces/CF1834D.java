package Codeforces;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.io.*;

public class CF1834D {
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


class CF1834DPair{
    int start, end;
    CF1834DPair(int s, int e){
        start = s;
        end = e;
    }
}

class CF1834DfPair extends CF1834DPair implements Comparable<CF1834DfPair>{

    CF1834DfPair(int s, int e) {
        super(s, e);
    }

    @Override
    public int compareTo( CF1834DfPair o) {
        return 0;
    }
}

class CF1834DePair extends CF1834DPair implements Comparable<CF1834DePair>{

    CF1834DePair(int s, int e) {
        super(s, e);
    }

    @Override
    public int compareTo( CF1834DePair o) {
        return 0;
    }
}


class CF1834DsPair extends CF1834DPair implements Comparable<CF1834DsPair>{

    CF1834DsPair(int s, int e) {
        super(s, e);
    }

    @Override
    public int compareTo( CF1834DsPair o) {
        return 0;
    }
}


