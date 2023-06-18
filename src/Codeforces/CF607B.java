package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF607B {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve()throws IOException{
        //Todo: write your implementation
        int n = nextInt();
        int[] arr =new int[n];
        int[][] dpTable = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int start = j;
                int end = j + i;
                if(start == end){
                    dpTable[start][end] = 1;
                }
                else if(end - start == 1){
                    if(arr[start] == arr[end]){
                        dpTable[start][end] = 1;
                    }
                    else{
                        dpTable[start][end] = 2;
                    }
                }
                else{
                    int MinV = Integer.MAX_VALUE;
                    if(arr[start] == arr[end]){
                         MinV = dpTable[start+1][end-1];
                    }
                    for (int k = start; k < end; k++) {
                        MinV = Math.min(dpTable[start][k] + dpTable[k+1][end],MinV);
                    }
                    dpTable[start][end] = MinV;
                }
            }
        }
        System.out.println(dpTable[0][n-1]);

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
