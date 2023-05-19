package DMOJ;

import java.util.*;
import java.io.*;

public class COCI2006C5P5 {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    //initialization here
    static int N;
    public static void main(String[] args) throws IOException {
        //code here
        N = nextInt();
        int[] allNum = new int[N];
        for (int i = 0; i < N; i++) {
            allNum[i] = nextInt();
        }

        int count = 0;
        for (int i = 0; i < N; i++) { //item I chooses first
            int result = 0;
            if(allNum[i]%2 == 1){
                result++;
            }
            int[] thisCoinList = new int[N-1];

            int index = 0;
            for (int j = i+1; j < N; j++) {
                thisCoinList[index] = allNum[j];
                index++;
            }
            for (int j = 0; j < i; j++) {
                thisCoinList[index] = allNum[j];
                index++;
            }

            int[][] DPTable = new int[N-1][N-1];
            int[] prefixSum = new int[N];
            for (int j = 0; j < N-1; j++) {
                if(thisCoinList[j]%2 == 1) prefixSum[j+1] = prefixSum[j]+1;
                else prefixSum[j+1] = prefixSum[j];
            }
            for (int j = N-1; j >= 0; j--) {
                for (int k = j; k < N-1; k++) {
                    if(j == k){
                        if(thisCoinList[j]%2 == 1) DPTable[j][k] = 1;
                        else DPTable[j][k] = 0;
                    }
                    else{
                        int removeK = DPTable[j][k-1];
                        int removeJ = DPTable[j+1][k];

                        DPTable[j][k] = prefixSum[k+1] - prefixSum[j] - (Math.min(removeK,removeJ));
                    }


                }
            }
            result+=prefixSum[N-1];
            result-= DPTable[0][N-2];
            result-= DPTable[0][N-2];
            if(result > 0)
            {
                count++;
            }
        }
        System.out.println(count);

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