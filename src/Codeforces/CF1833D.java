package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF1833D {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    public static void solve() throws IOException {
        //Todo: write your implementation
        int n = nextInt();
        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int c = nextInt();
            original.add(c);
            sorted.add(c);
        }
        Collections.sort(sorted);
        Collections.reverse(sorted);
        int largestNumToFind = -1;
        boolean greatestOrSec = false;
        for (int i = 0; i < n; i++) {

            if (!sorted.get(i).equals(original.get(i))) {
                largestNumToFind = sorted.get(i);
                if (i == 0 || i == 1) {
                    greatestOrSec = true;
                }
                break;
            }

        }

        if (largestNumToFind == -1) {
            //put the first element to the back
            for (int i = 1; i < sorted.size(); i++) {
                ans.add(sorted.get(i));
            }
            ans.add(sorted.get(0));
        } else if (!greatestOrSec) {
            for (int i = 1; i < n; i++) {
                ans.add(original.get(i));
            }
            ans.add(original.get(0));
        } else {
            int index = -1;
            for (int i = 0; i < original.size(); i++) {
                if (original.get(i) == largestNumToFind) {
                    index = i;
                    break;
                }
            }
            if(index == -1){
                System.out.println("?");
                return;
            }


            for (int i = 0; i < index; i++) {
                if (ans.isEmpty()) {
                    for (int j = index; j < original.size(); j++) {
                        ans.add(original.get(j));
                    }
                    //front part done

                    for (int j = index - 1; j >= i; j--) {
                        ans.add(original.get(j));
                    }

                    for (int j = 0; j < i; j++) {
                        ans.add(original.get(j));
                    }
                } else {
                    ArrayList<Integer> newArr = new ArrayList<>();
                    for (int j = index; j < original.size(); j++) {
                        newArr.add(original.get(j));
                    }
                    //front part done

                    for (int j = index - 1; j >= i; j--) {
                        newArr.add(original.get(j));
                    }

                    for (int j = 0; j < i; j++) {
                        newArr.add(original.get(j));
                    }

                    for (int j = 0; j < n; j++) {
                        if (newArr.get(j) > ans.get(j)) {
                            ans = newArr;
                            break;
                        } else if (ans.get(j) > newArr.get(j)) {
                            break;
                        }
                    }
                }
            }

            if (index == n - 1) {
                if (ans.isEmpty()) {
                    ans.add(original.get(n - 1));
                    for (int j = 0; j < n - 1; j++) {
                        ans.add(original.get(j));
                    }
                } else {
                    ArrayList<Integer> newArr2 = new ArrayList<>();
                    newArr2.add(original.get(n - 1));
                    for (int j = 0; j < n - 1; j++) {
                        newArr2.add(original.get(j));
                    }
                    for (int j = 0; j < n; j++) {
                        if (newArr2.get(j) > ans.get(j)) {
                            ans = newArr2;
                            break;
                        } else if (ans.get(j) > newArr2.get(j)) {
                            break;
                        }
                    }
                }
            }

        }


        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
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
