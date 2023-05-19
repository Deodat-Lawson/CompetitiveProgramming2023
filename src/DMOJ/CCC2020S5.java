package DMOJ;
import java.io.*;
import java.util.*;

public class CCC2020S5 {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    //initialization here
    public static void main(String[] args) throws IOException {
        //code here

        int n = nextInt();
        int[] burgers = new int[n];
        for (int i = 0; i < burgers.length; i++) {
            burgers[i] = nextInt();
        }

        HashMap<Integer, Integer> lastIndexForB = new HashMap<>();
        for (int i = burgers.length - 1; i >= 0; i--) {
            if(lastIndexForB.getOrDefault(burgers[i],-1) == -1){
                lastIndexForB.put(burgers[i],i);
            }
        }

        int coachFav = burgers[0];
        if(coachFav == burgers[n-1]){
            System.out.println((double) 1);
            return;
        }

        double[] dp = new double[n];
        double[] dpPsa = new double[n];
        for (int i = burgers.length - 1; i >= 0; i--) {

            if(burgers[i] == coachFav) dp[i] = 1;
            else{
                //if last
                if(lastIndexForB.get(burgers[i]) == i){
                    if(i == burgers.length - 1){
                        dp[i] = 0;
                    }
                    else dp[i] = (double)1/(n-i) + (dpPsa[i+1])/(n-i);
                }
                else{
                    int a = lastIndexForB.get(burgers[i]);
                    dp[i] = dp[a];
                }

            }
            if(i == burgers.length-1) {
                dpPsa[i] = dp[i];
            }
            else{
                dpPsa[i] = dpPsa[i+1] + dp[i];
            }
        }

        System.out.println((double)dpPsa[0]/n);






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
