package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF1825B {


    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    public static void solve() throws IOException {
        long n = nextLong();
        long m = nextLong();

        long allNum = n*m;
        ArrayList<Long> nums = new ArrayList<>();
        for (int i = 0; i < allNum; i++) {
            long thisN = nextLong();
            nums.add(thisN);
        }
        Collections.sort(nums);
        long larger = Math.max(n,m);
        long smaller = Math.min(n,m);

        long max2 = 0;
        long min2 = 0;
        max2 += (nums.get(nums.size() - 2) - nums.get(0))*(smaller - 1);
        max2 += (larger - 1)*smaller*(nums.get(nums.size() - 1) - nums.get(0));

        min2 += (nums.get(nums.size() - 1) - nums.get(1))*(smaller - 1);
        min2 += (larger - 1)*smaller*(nums.get(nums.size() - 1) - nums.get(0));

        System.out.println(Math.max(max2,min2));


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
