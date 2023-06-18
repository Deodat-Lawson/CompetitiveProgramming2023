package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF1114D {


    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve()throws IOException{
        //Todo: write your implementation
        int n = nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1;
        for (int i = 0; i < n; i++) {
            int s = nextInt();
            if(s != prev){
                list.add(s);
            }
            prev = s;
        }

        int[][] dp = new int[list.size()][list.size()];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j+i < list.size(); j++) {
                int start = j;
                int end = i+j;
                if(start == end){
                    dp[start][end] = 0;
                }
                else if(end - start == 1){
                    dp[start][end] = 1;
                }
                else {
                    if(Objects.equals(list.get(start), list.get(end))){
                        dp[start][end] = dp[start + 1][end - 1] + 1;
                    }
                    else {
                        dp[start][end] = Math.min(dp[start + 1][end], dp[start][end - 1]) + 1;
                    }
                }

            }
        }

        System.out.println(dp[0][list.size()-1]);
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
