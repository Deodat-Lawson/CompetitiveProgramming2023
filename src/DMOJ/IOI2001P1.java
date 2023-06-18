package DMOJ;

import java.util.*;
import java.io.*;

public class IOI2001P1 {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    //initialization here
    static int N;
    public static void main(String[] args) throws IOException {
        //code here
        int[][] BIT = null;
        while(true){
            int a = nextInt();
            if(a == 3){
                return;
            }
            else if(a == 1){
                int xPos = nextInt()+1;
                int yPos = nextInt()+1;
                int addVal = nextInt();
                updateBIT(BIT,xPos,yPos,addVal);
            }
            else if(a == 0){
                N = nextInt();
                BIT = new int[N+2][N+2];
            }
            else if(a == 2){
                int l = nextInt()+1;
                int b = nextInt()+1;
                int r = nextInt()+1;
                int t = nextInt()+1;

                int output = getSum(BIT,r,t);
                output-=getSum(BIT,r,b-1);
                output-=getSum(BIT,l-1,t);
                output+=getSum(BIT,l-1,b-1);
                System.out.println(output);
            }


        }
    }


    static int getSum(int BIT[][], int x, int y)
    {
        int sum = 0;

        for(; x > 0; x -= x&-x)
        {
            // This loop sum through all the 1D BIT
            // inside the array of 1D BIT = BIT[x]
            for(int g = y; g > 0; g -= g&-g)
            {
                sum += BIT[x][g];
            }
        }
        return sum;
    }


    static void updateBIT(int BIT[][], int x,
                          int y, int val)
    {
        for (; x <= N; x += (x & -x))
        {
            // This loop update all the 1D BIT inside the
            // array of 1D BIT = BIT[x]
            for (int g = y; g <= N; g += (g & -g))
                BIT[x][g] += val;
        }
        return;
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