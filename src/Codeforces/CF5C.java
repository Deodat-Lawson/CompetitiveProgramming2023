package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF5C {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve()throws IOException{
        //Todo: write your implementation
        String a = nextLine();
        Stack<Integer> stack = new Stack<>();
        int[] val = new int[a.length()];

        int max = 0, count = 1;

        for (int i = 0; i < a.length(); i++) {
            char thisC = a.charAt(i);
            if(thisC == '('){
                val[i] = 0;
                stack.add(i);

            }
            else{
                if(!stack.isEmpty()){
                    int p = stack.pop();
                    int addOn = 0;
                    if(p > 0){
                        addOn = val[p-1];
                    }
                    int c = i - p + 1 + addOn;
                    val[i] = c;
                    if(c > max){
                        max = c;
                        count = 1;
                    }
                    else if(c == max){
                        count++;
                    }
                }
                else{
                    val[i] = 0;
                }
            }
        }

        System.out.println(max + " " + count);
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
