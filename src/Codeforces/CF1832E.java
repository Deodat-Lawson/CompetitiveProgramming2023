package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1832E {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    static int[][] dpTable = new int[6][(int) (1e7 + 2)];

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < (int) (1e7 + 2); j++) {
                if(i == 1){
                    dpTable[i][j] = j;
                }
                else if(j < i){
                    dpTable[i][j] = 0;
                }
                else if(i == j){
                    dpTable[i][j] = 1;
                }
                else{
                    dpTable[i][j] = ((dpTable[i][j-1] + dpTable[i-1][j-1])%998244353);
                }
            }
        }

        solve();
    }

    public static void solve() throws IOException {
        //Todo: write your implementation
        int n = nextInt();
        int a1 = nextInt();
        int x = nextInt();
        int y = nextInt();
        int m = nextInt();
        int k = nextInt();

        int[] psa = new int[n+1];
        psa[0] = dpTable[0][k];
        for (int i = 1; i < n+1; i++) {
            psa[i] = dpTable[k][i] + psa[i-1];
        }

        int[] b = new int[n+1];
        b[1] = (psa[1]*a1)%998244353;
        for (int i = 2; i < n+1; i++) {
            b[i] = ((x*b[i-1])%m + (y*psa[i])%m)%998244353;
        }

        int c = 0;
        for (int i = 0; i < n+1; i++) {
            c^= b[i];
        }
        System.out.println(c);



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
