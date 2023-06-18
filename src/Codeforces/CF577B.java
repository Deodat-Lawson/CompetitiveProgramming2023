package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF577B {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve()throws IOException{
        //Todo: write your implementation
        int n = nextInt();
        int m = nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(nextInt()%m);
        }

        if(n >= m){
            System.out.println("YES");
        }
        else{
            boolean[] table = new boolean[m];
            for (int i = 0; i < n; i++) {
                int a = arr.get(i);
                boolean[] newT = new boolean[m];
                for (int j = 0; j < m; j++) {
                    if(table[j]) {
                        newT[j] = true;
                        newT[(j + a) % m] = true;
                    }
                }
                newT[a] = true;
                table = newT;
                if(table[0]){
                    System.out.println("YES");
                    return;
                }
            }

            if(table[0]){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }


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
