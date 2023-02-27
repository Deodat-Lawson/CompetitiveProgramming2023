package USACO;

import java.io.*;
import java.util.*;

public class fencedIn {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    public static void main(String[] args) throws IOException {
        long a = nextLong();
        long b = nextLong();

        int n = nextInt();
        int m = nextInt();

        Node[][] allNodes = new Node[n + 1][m + 1];
        long[] xL = new long[n + 1];
        long[] yL = new long[m + 1];


        for (int i = 0; i < n; i++) {
            xL[i] = nextLong();
        }
        xL[n] = a;
        for (int i = 0; i < m; i++) {
            yL[i] = nextLong();
        }
        yL[m] = b;

        Arrays.sort(yL);
        Arrays.sort(xL);

        long[] xL2 = new long[n + 1];
        long[] yL2 = new long[m + 1];
        xL2[0] = xL[0];
        yL2[0] = yL[0];
        for (int i = 1; i < n; i++) {
            xL2[i] = xL[i + 1] - xL[i];
        }
        for (int i = 1; i < m; i++) {
            yL2[i] = yL[i + 1] - yL[i];
        }


        int xLIndex = 0;
        int yLIndex = 0;
        for (int i = 0; i < allNodes.length; i++) {
            for (int j = 0; j < allNodes[0].length; j++) {
                Node newN = new Node(i, j);

                if (yLIndex == 0) {
                    newN.xSize = yL[yLIndex];
                } else {
                    newN.xSize = yL[yLIndex] - yL[yLIndex - 1];
                }

                if (xLIndex == 0) {
                    newN.ySize = xL[xLIndex];
                } else {
                    newN.ySize = xL[xLIndex] - xL[xLIndex - 1];
                }

                allNodes[i][j] = newN;
                yLIndex++;

                System.out.print(allNodes[i][j].ySize + "," + allNodes[i][j].xSize + "    ");
            }
            yLIndex = 0;
            xLIndex++;

            System.out.println();
        }

        ArrayList<Edge>[] adjList = new ArrayList[(m + 1)*(n + 1)];
        for (int i = 0; i < allNodes.length; i++) {
            for (int j = 0; j < allNodes[0].length; j++) {
                adjList[i*j].add(new Edge(adjList[i*j],));

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

class Node {
    int xPos, yPos;
    long xSize, ySize;

    Node(int a, int b) {
        xPos = a;
        yPos = b;
    }

}

class Edge{
    Node n;
    int weight;
    Edge(Node a, int b){
        n = a;
        weight = b;
    }

}

class MST {
    int[] id;


    MST(int a, int b) {

    }
}
