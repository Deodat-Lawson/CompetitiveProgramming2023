package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF149D {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        //Todo: write your implementation
        String a = nextLine();
        //use stack to get cor brackets
        int[] corBrack = new int[a.length()];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(c == '('){
                stk.add(i);
            }
            else{
                int corB = stk.pop();
                corBrack[corB] = i;
                corBrack[i] = corB;
            }
        }


        int size = a.length();
        int[][] dpTable = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dpTable[i][j] = 1;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j + i < size; j++) {
                int start = j;
                int end = i + j;

                if (start == end) {
                    dpTable[start][end] = 1;
                } else if (end - start == 1) {
                    if(corBrack[end] == start){
                        dpTable[start][end] = 4;
                    }
                    else {
                        dpTable[start][end] = 1;
                    }
                }
                else {
                    if(a.charAt(end) == '('){
                        dpTable[start][end] = dpTable[start][end - 1];
                    }
                    else{
                        int corrP = corBrack[end];
                        if(start <= corrP && corrP <= end){
                            if(start == corrP){
                                if(corBrack[start + 1] == end - 1) {
                                    dpTable[start][end] = (dpTable[start + 1][end - 1] * 3) % mod;
                                }
                                else{
                                    dpTable[start][end] = (dpTable[start+1][end - 1] * 4 - 2*dpTable[start + 2][end - 1] - 2*dpTable[start + 1][end -2])%mod;
                                }
                            }
                            else{
                                int prevNum = corBrack[corrP - 1];
                                if(prevNum < start || prevNum > end){
                                    dpTable[start][end] = (dpTable[start][corrP - 1] * dpTable[corrP][end])%mod;
                                }
                                else{
                                    dpTable[start][end] = (dpTable[start][corrP - 1] * dpTable[corrP][end] - 2*dpTable[start][corrP - 2] *dpTable[corrP+1][end]);
                                }
                            }
                        }else{
                            dpTable[start][end] = dpTable[start][end - 1];
                        }
                    }

                }
            }
        }

        System.out.println(dpTable[0][size-1]);
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

