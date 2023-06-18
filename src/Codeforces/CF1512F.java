package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1512F {

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
        int c = nextInt();
        int[] a = new int[n];
        int[] b = new int[n-1];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            b[i] = nextInt();
        }

        int[] daysForPromo = new int[n];
        int[] moneyLeftAfterPro = new int[n];

        for (int i = 0; i < n-1; i++) {
            if(i == 0){
                daysForPromo[i] = Math.max(1,(int)Math.round(Math.ceil((float)b[i]/a[i]) + 1));
                moneyLeftAfterPro[i] = Math.max(0,(daysForPromo[i] - 1) * a[i] - b[i]);
            }
            else{
                int m = b[i] - moneyLeftAfterPro[i-1];
                daysForPromo[i] = Math.max(1,((int)Math.round(Math.ceil((float)m/a[i]) + 1)));
                moneyLeftAfterPro[i] = Math.max(0,(daysForPromo[i] - 1) * a[i] - m);
                daysForPromo[i] += daysForPromo[i-1];
            }
        }

        int min  = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int days;
            if(i == 0){
                days = (int)Math.round(Math.ceil((float)c/a[i]));
            }
            else {
                int mNeeded = c - moneyLeftAfterPro[i - 1];
                days = daysForPromo[i-1] + (int)Math.round( Math.ceil((float) mNeeded / a[i]));
            }
                min = Math.min(min, days);
        }
        System.out.println(min);


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
