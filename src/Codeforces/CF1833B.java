package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1833B {

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
        int k = nextInt();
        ArrayList<CF1833BKey> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int thisC = nextInt();
            CF1833BKey thisK = new CF1833BKey();
            thisK.val = thisC;
            thisK.index = i;
            a.add(thisK);
        }
        for (int i = 0; i < n; i++) {
            b.add(nextInt());
        }

        Collections.sort(a);
        Collections.sort(b);

        int[] ans = new int[n];
        for (int i = 0; i < b.size(); i++) {
            int val = b.get(i);
            int index = a.get(i).index;
            ans[index] = val;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();


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

class CF1833BKey implements Comparable<CF1833BKey>{
    int val, index;

    @Override
    public int compareTo(CF1833BKey o) {
        return Integer.compare(val, o.val);
    }
}
