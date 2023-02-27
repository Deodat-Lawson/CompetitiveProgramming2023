package Codeforces;

import java.util.*;
import java.io.*;


public class CF919D {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;


    static char[] vals;
    static CF919DNode[] allNodes;
    static ArrayList<Integer> topOrder;
    static Stack<Integer> top;
    static ArrayList<Integer>[] adjList;
    static boolean hasLoop = false;

    static boolean[] visited;
    static boolean[] loopVisited;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();

        vals = new char[n];
        adjList = new ArrayList[n];
        allNodes = new CF919DNode[n];
        top = new Stack<>();
        topOrder = new ArrayList<>();
        loopVisited = new boolean[n];


        String str = nextLine();

        for (int i = 0; i < n; i++) {
            vals[i] = str.charAt(i);
            allNodes[i] = new CF919DNode(vals[i]);
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = nextInt() - 1;
            int to = nextInt() - 1;
            allNodes[to].parent.add(from);
            adjList[from].add(to);
        }
        for (int i = 0; i < n; i++) {
            if (!loopVisited[i]) {
                checkLoop(i,new boolean[n]);
            }
        }

        if(hasLoop){
            System.out.printf("-1");
            return;
        }
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topSort(i);
            }
        }


        for(int i = 0; i < n; i++){
            topOrder.add(top.pop());
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            CF919DNode Node = allNodes[topOrder.get(i)];
            //reduce this time complexity
            for(int j = 0; j < Node.parent.size(); j++){
                for(int k = 0; k < 26; k++){
                    if(allNodes[Node.parent.get(j)].allAlp[k] > Node.allAlp[k]){
                        Node.allAlp[k] = allNodes[Node.parent.get(j)].allAlp[k];
                    }
                }
            }
            Node.allAlp[Node.value - 'a']++;
            for(int j = 0; j < 26; j++){
                if(Node.allAlp[j] > max) {
                    max = Node.allAlp[j];
                }
            }
        }


        System.out.println(max);


    }

    static void checkLoop(int v, boolean[] visited){
        visited[v] = true;
        loopVisited[v] = true;

        for (int i = 0; i < adjList[v].size(); i++) {
            int child = adjList[v].get(i);
            if(visited[child]){
                hasLoop = true;
            }
            else{
                checkLoop(child,visited);
                visited[child] = false;
            }
        }
    }
    static void topSort(int v) {
        visited[v] = true;
        for (int i = 0; i < adjList[v].size(); i++) {
            int child = adjList[v].get(i);
            if (!visited[child]) {
                topSort(child);
            }
        }
        top.add(v);
    }


        static String next () throws IOException {
            while (tok == null || !tok.hasMoreTokens()) {
                tok = new StringTokenizer(f.readLine().trim());
            }
            return tok.nextToken();
        }

        static long nextLong () throws IOException {
            return Long.parseLong(next());
        }

        static int nextInt () throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble () throws IOException {
            return Double.parseDouble(next());
        }

        static char nextCharacter () throws IOException {
            return next().charAt(0);
        }

        static String nextLine () throws IOException {
            return f.readLine().trim();
        }
    }

    class CF919DNode {
        ArrayList<Integer> parent;
        char value;

        char[] allAlp;

        CF919DNode(char val) {
            value = val;
            parent = new ArrayList<>();
            allAlp = new char[26];
        }

    }