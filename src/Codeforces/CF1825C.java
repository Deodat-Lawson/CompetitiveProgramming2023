package Codeforces;

import java.io.*;
import java.util.*;

public class CF1825C {
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
        int m = nextInt();

        int splitIn2 = 0;
        int onlyneg1 = 0;
        int onlyneg2 = 0;

        int neg1N = 0;
        int neg2N = 0;

        HashSet<Integer> allN = new HashSet<>();
        int smallest = Integer.MAX_VALUE;
        int largest = 0;
        for (int i = 0; i < n; i++) {
            int thisN = nextInt();
            if(thisN == -1){
                neg1N++;
            }
            else if(thisN == -2){
                neg2N++;
            }
            else {
                allN.add(thisN);
                smallest = Math.min(smallest, thisN);
                largest = Math.max(largest, thisN);
            }
        }

        if(allN.size() == 0){
            System.out.println(Math.min(m,Math.max(neg2N,neg1N)));
            return;
        }

        int remaining1 = neg1N - (smallest - 1);
        splitIn2 += Math.min(neg1N, smallest - 1);
        int remaining2 = neg2N - (m - largest);
        splitIn2 += Math.min(neg2N, m - largest);
        int remainingA = 0;

        if(remaining2 > 0){
            remainingA += remaining2;
        }
        if(remaining1 > 0){
            remainingA += remaining1;
        }

        splitIn2 += allN.size();

        splitIn2 += Math.max(Math.min(remainingA, largest - smallest - 1 - allN.size()),0);

        onlyneg1 = Math.min(m, allN.size() + neg1N);
        onlyneg2 = Math.min(m, allN.size() + neg2N);

        System.out.println(Math.max(onlyneg1,Math.max(onlyneg2,splitIn2)));

        
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
