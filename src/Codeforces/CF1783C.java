package Codeforces;

import java.io.*;
import java.util.*;

public class CF1783C {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    public static void main(String[] args) throws IOException {
        int numOfTest = nextInt();

        for (int i = 0; i < numOfTest; i++) {
            int n = nextInt();
            int m = nextInt();

            int[] opponents = new int[n];
            int[] opponentW = new int[n];
            int maxNumOfOpponents = 0;
            int sum = 0;
            boolean flag = false;
            int maxNumFirstNP1 = 0;
            for (int j = 0; j < n; j++) {
                opponents[j] = nextInt();

            }

            Arrays.sort(opponents);


            for (int j = 0; j < n; j++) {
                if(j != 0 && (opponents[j] > opponents[j-1])){
                    opponentW[j] = j;
                }
                else if(j != 0){
                    opponentW[j] = opponentW[j-1];
                }
                sum += opponents[j];
                if(!flag){
                    maxNumFirstNP1 = sum;
                }
                if (sum <= m) {
                    maxNumOfOpponents++;
                }
                else{
                    flag = true;
                }



            }

            if(maxNumOfOpponents >= opponents.length){
                System.out.println("1");
                continue;
            }

            //max NumOfOpponents found



            int left = 0;
            int right = maxNumOfOpponents + 1;
            int mid;
            int ans = maxNumOfOpponents;

            while(left <= right){
                mid = left + (right - left)/2;
                if(maxNumFirstNP1 - opponents[mid] > m){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                    ans = mid;
                }
            }

            ArrayList<Integer> placeDeterminer = new ArrayList<>();
            int wins = maxNumOfOpponents;
            for (int j = 0; j < opponents.length; j++) {
                if(j <= maxNumOfOpponents && j!= ans){

                }
                else{
                    opponentW[j]++;
                }
                placeDeterminer.add(opponentW[j]);
            }

            Collections.sort(placeDeterminer);
            Collections.reverse(placeDeterminer);
            int as = 1;
            for(int j = 0; j < placeDeterminer.size();j++){
                if(wins < placeDeterminer.get(j)){
                    as++;
                }
                else{
                    break;
                }
            }

            System.out.println(as);

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
