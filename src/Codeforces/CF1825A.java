package Codeforces;

import java.io.*;
import java.util.*;

public class CF1825A {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String s = nextLine();
        boolean[][] table = new boolean[s.length()][s.length()];

        for (int i = 0; i <table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = true;
            }
        }
        int longest = -1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j + i < table.length; j++) {
                if(i == 0){
                    table[j][j+i] = true;
                }
                else if(i == 1){
                    if(s.substring(j,j+1).equals(s.substring(j+i,j+i+1))){
                        table[j][j+i] = true;
                    }
                    else{
                        table[j][j+i] = false;
                    }
                }
                else{
                    if(s.substring(j,j+1).equals(s.substring(j+i,j+i+1))){
                        table[j][j+i] = table[j+1][i+j -1];
                    }
                    else{
                         table[j][j+i] = false;
                    }
                }

                if(!table[j][i+j]){
                    longest = Math.max(longest, i+1);
                }
            }
        }
        System.out.println(longest);


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
