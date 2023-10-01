package Codeforces;

import java.io.*;
import java.util.*;

public class CF1083E {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long[] DP = new long[n+1];
        ArrayList<rectangle> allRectSorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            allRectSorted.add(new rectangle(nextLong(), nextLong(), nextLong()));
        }
        Collections.sort(allRectSorted);
        long[] X = new long[n + 1];
        X[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            X[i] = allRectSorted.get(i-1).X;
        }

        DP[0] = 0;

        PriorityQueue<slopeFunction> pq = new PriorityQueue<>();
        pq.add(new slopeFunction(0,0));

        for (int i = 1; i < DP.length; i++) {
            rectangle getIRect = allRectSorted.get(i-1);
            long constantValue = (long)getIRect.X * getIRect.Y - getIRect.cost;

            long maxVal = 0;
            slopeFunction thisF = pq.poll();
            maxVal = thisF.cal(getIRect.Y);
            while(!pq.isEmpty()){
                slopeFunction nextF = pq.peek();
                if(nextF.cal(getIRect.Y) <= thisF.cal(getIRect.Y)){
                    maxVal = thisF.cal(getIRect.Y);
                    break;
                }
                maxVal = nextF.cal(getIRect.Y);
                thisF = nextF;
                pq.poll();
            }

            DP[i] = constantValue + maxVal;
            pq.add(new slopeFunction(X[i],DP[i]));

            pq.add(thisF);
        }

        long maxV = 0;
        for (int i = 0; i < DP.length; i++) {
            maxV = Math.max(maxV, DP[i]);
        }
        System.out.println(maxV);



    }

    static class slopeFunction implements Comparable<slopeFunction>{
        long m;
        long b;

        slopeFunction(long m, long b){
            this.m = m;
            this.b = b;
        }

        public long cal(long Y){
            return (long)b - (long)Y*m;
        }

        @Override
        public int compareTo(slopeFunction o1){
            return Long.compare(o1.m,m);
        }
    }

    static class rectangle implements Comparable<rectangle>{
        long X;
        long Y;
        long cost;

        rectangle(long x, long y, long c){
            X = x;
            Y = y;
            cost = c;
        }

        @Override
        public int compareTo(rectangle o1){
            return Long.compare(o1.Y, Y);
        }

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
