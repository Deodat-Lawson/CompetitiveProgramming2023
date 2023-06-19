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
        int n = nextInt();
        int m = nextInt();

        ArrayList<CF1834DfPair> sortByFront = new ArrayList<>();
        ArrayList<CF1834DePair> sortByEnd = new ArrayList<>();
        ArrayList<CF1834DsPair> sortBySmallestL = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = nextInt();
            int end = nextInt();
            CF1834DfPair thisPf = new CF1834DfPair(start,end);
            CF1834DePair thisPe = new CF1834DePair(start, end);
            CF1834DsPair thisPs = new CF1834DsPair(start,end);
            sortByFront.add(thisPf);
            sortByEnd.add(thisPe);
            sortBySmallestL.add(thisPs);
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


class CF1834DPair {
    int start, end;

    CF1834DPair(int s, int e) {
        start = s;
        end = e;
    }
}

class CF1834DfPair extends CF1834DPair implements Comparable<CF1834DfPair> {

    CF1834DfPair(int s, int e) {
        super(s, e);
    }

    @Override
    public int compareTo(CF1834DfPair o) {
        return Integer.compare(start,o.start);
    }
}

class CF1834DePair extends CF1834DPair implements Comparable<CF1834DePair> {

    CF1834DePair(int s, int e) {
        super(s, e);
    }

    @Override
    public int compareTo(CF1834DePair o) {
        return Integer.compare(end, o.end);
    }
}


class CF1834DsPair extends CF1834DPair implements Comparable<CF1834DsPair> {
    int l;
    CF1834DsPair(int s, int e) {
        super(s, e);
        l= e - s + 1;
    }

    @Override
    public int compareTo(CF1834DsPair o) {
        return Integer.compare(l, o.l);
    }
}
