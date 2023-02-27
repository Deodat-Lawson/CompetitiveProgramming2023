package Codeforces;

import java.util.*;
import java.io.*;

public class CF839C {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    static double[] leafDist;

    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        adjList = new ArrayList[n];
        leafDist = new double[n];


        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            leafDist[i] = -1;
        }
        for (int i = 0; i < n - 1; i++) {
            int edge1 = nextInt() - 1;
            int edge2 = nextInt() - 1;

            adjList[edge1].add(edge2);
            adjList[edge2].add(edge1);
        }


        dfs(0, 0,new boolean[n]);

        System.out.println(leafDist[0]);


    }


    static void dfs(int node, int dist, boolean[] visited) {
        visited[node] = true;
        boolean isLeaf = true;
        double sumIsLeaf = 0;
        double count = 0;
        for (int i = 0; i < adjList[node].size(); i++) {
            if (!visited[adjList[node].get(i)]) {
                //if not visited, then dfs
                isLeaf = false;
                dfs(adjList[node].get(i), dist + 1, visited);
                sumIsLeaf += leafDist[adjList[node].get(i)];
                count++;
            }
        }

        if (isLeaf) {
            leafDist[node] = dist;
        } else {
            leafDist[node] = sumIsLeaf / count;
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

/*
Main idea:
- We realize that greedy works in this case.
- For each connected component, when we run a DFS.
- If a Node has two unvisited connected edges, then they form a path.
- In the DFS, for each node we go to, we find


 */

