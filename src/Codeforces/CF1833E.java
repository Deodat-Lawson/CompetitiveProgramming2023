package Codeforces;

import java.io.*;
import java.util.*;


public class CF1833E {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    public static void solve() throws IOException {
        //Todo: write your implementation
        int n = nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        CF1833EDSU thisDSU = new CF1833EDSU(n);
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int c = nextInt() - 1;
            thisDSU.union(i, c);
            adj[i].add(c);
        }
        int max = thisDSU.count;
        int min = 0;

        boolean hasNonCycle = false;
        //check if cycle
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean[] v = new boolean[n];
                if(!checkCycle(-1, i,adj,v)){
                    hasNonCycle = true;
                }
                else{
                    min++;
                }
            }
        }

        if(hasNonCycle){
            min++;
        }

        System.out.println(min + " "+max);


        //use adjacency list to check cycle detection
        //use DSU to check connected components


    }


    static boolean checkCycle(int s, int n, ArrayList<Integer>[] adjList, boolean[] v) {
        visited[n] = true;

        if (!v[n]) {
            v[n] = true;
        } else {
            return true;
        }

        for (int a : adjList[n]
        ) {
            if (a != s) {
                return checkCycle(n, a, adjList, v);
            }
        }
        return false;
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

class CF1833EDSU {
    int count;
    int[] id;

    CF1833EDSU(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    void union(int p, int q) {
        if (find(p) != find(q)) {
            //connect them
            id[p] = id[q];
            count--;
        }
    }

    int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

}
