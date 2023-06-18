package DMOJ;
import java.util.*;
import java.io.*;

public class DMOPC2016C1P5 {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    static int[] BITVal;

    //initialization here
    public static void main(String[] args) throws IOException {
        //code here

        int N = nextInt();
        int[] order = new int[N];
        BITVal = new int[N+1];

        long totalInversion = 0;

        for (int i = 0; i < N; i++) {
            order[i] = nextInt();
        }

        add(order[0]);

        for (int i = 1; i < N; i++) {
            add(order[i]);
            long InversionAddRight = countInversionBigger(order[i],i+1);
            long InversionAddLeft = countInversionSmaller(order[i]);

            totalInversion+= Math.min(InversionAddLeft, InversionAddRight);
        }

        System.out.println(totalInversion);



    }

    static void add(int index){
        while(index < BITVal.length){
            BITVal[index]++;
            index+= (index & -index);
        }
    }
    static void remove(int index){
        while(index < BITVal.length){
            BITVal[index]--;
            index += (index & -index);
        }
    }
    static long countInversionBigger(int val, int total){
        long sum = 0;
        while(val > 0){
            sum+=BITVal[val];
            val-= (val&-val);
        }
        return total - sum;
    }
    static long countInversionSmaller(int val){
        val--;
        long sum = 0;
        while(val > 0){
            sum+=BITVal[val];
            val-= (val&-val);
        }
        return sum;
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
