package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class CF1828C {


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
        ArrayList<Integer> sortedAs = new ArrayList<>();
        ArrayList<Integer> sortedBs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedAs.add(nextInt());
        }
        for (int i = 0; i < n; i++) {
            sortedBs.add(nextInt());
        }
        Collections.sort(sortedAs);
        Collections.sort(sortedBs);

        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = sortedBs.get(i);
            int left = 0;
            int right = n - 1;
            int ans = n;
            while (left <= right) {
                int mid = (left + right) / 2;
                int midV = sortedAs.get(mid);
                if (midV <= value) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    ans = Math.min(mid, ans);
                }
            }
            indices.add(ans);
        }

        long res = 1;
        for (int i = 0; i < indices.size(); i++) {
            int num = indices.get(i);
            int output = (n - num) - (n - (i + 1));
            res *= (long) output;
            res %= (1e9 + 7);
        }
        System.out.println(res);


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

