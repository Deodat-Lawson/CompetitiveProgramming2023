package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF755C2 {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    public static void main(String[] args) throws IOException {
        int balls = nextInt();
        int edges = nextInt();

        CF755CDSU thisDSU = new CF755CDSU(balls);
        for (int i = 0; i < edges; i++) {
            int ed1 = nextInt() - 1;
            int ed2 = nextInt() - 1;

            thisDSU.union(ed1, ed2);
        }

        System.out.println(thisDSU.count);
        f.close();

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


class CF755CDSU {
    int[] size;
    int[] id;
    int count;

    CF755CDSU(int i) {
        count = i;
        id = new int[count];
        for (int j = 0; j < count; j++) {
            id[j] = j;
        }

        size = new int[count];
        for (int j = 0; j < count; j++) {
            size[j] = 1;
        }
    }

    int find(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        if (size[i] < size[j]) {
            size[j] += size[i];
            id[i] = j;
        } else {
            size[i] += size[j];
            id[j] = i;
        }
        count--;
    }

    boolean connected(int i, int j) {
        return find(i) == find(j);
    }


}