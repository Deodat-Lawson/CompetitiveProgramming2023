package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF1828D1 {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        if(n == 1){
            System.out.println(0);
            return;
        }

        CF1828D1SegSmall minV = new CF1828D1SegSmall(arr);
        CF1828D1SegBig maxV = new CF1828D1SegBig(arr);

        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if(i == 0){
                    dp[j][i + j] = 0;
                }
                else if(i == 1){
                    if(arr[j] > arr[j + i]){
                        dp[j][i+j] = 1;
                    }
                    else{
                        dp[j][i+j] = 0;
                    }
                }
                else{
                    long maxVal = maxV.query(j+1,i+j+1,1);
                    long minVal = minV.query(j+1, i+j+1, 1);

                    if(minVal == arr[j] && maxVal == arr[i+j]){
                        dp[j][j+i] = dp[j + 1][j+i-1];
                    }
                    else if(minVal == arr[j]){
                        dp[j][j+i] = dp[j+1][j+i];
                    }
                    else if(maxVal == arr[i+j]){
                        dp[j][j+i] = dp[j][j+i-1];
                    }
                    else{
                        dp[j][j+i] = dp[j+1][j+i-1] + 2;
                    }
                }
            }
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count+= dp[i][j];
            }
        }
        System.out.println(count);


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


class CF1828D1SegBig{
    CF1828D1maxNode[] segTree;
    int[] initialVal;


    CF1828D1SegBig(int[] v) {
        initialVal = new int[v.length];
        segTree = new CF1828D1maxNode[v.length*4];

        for (int i = 0; i < initialVal.length; i++) {
            initialVal[i] = v[i];
        }

        build(1, v.length, 1);
    }

    void build(int left, int right, int index) {
        segTree[index] = new CF1828D1maxNode();
        segTree[index].l = left;
        segTree[index].r = right;

        if (left == right) {
            segTree[index].maxVal = initialVal[left - 1];
            return;
        }

        int mid = (left + right) / 2;

        build(left, mid, index * 2);
        build(mid + 1, right, index * 2 + 1);

        segTree[index].maxVal = Math.max(segTree[index * 2].maxVal, segTree[index * 2 + 1].maxVal);
    }


    void update(int pos, int val, int index) {
        if (segTree[index].l == pos && segTree[index].r == pos) {
            segTree[index].maxVal = val;
            return;
        }

        int mid = (segTree[index].l + segTree[index].r) / 2;
        if (pos <= mid) {
            update(pos, val, index * 2);
        } else {
            update(pos, val, index * 2 + 1);
        }

        segTree[index].maxVal = Math.max(segTree[index * 2].maxVal, segTree[index * 2 + 1].maxVal);
    }

    int query(int left, int right, int index) {
        if (segTree[index].l == left && segTree[index].r == right) {
            return segTree[index].maxVal;
        }
        if(segTree[index].r == segTree[index].l){
            return segTree[index].maxVal;
        }

        int mid = (segTree[index].l + segTree[index].r) / 2;
        if (right <= mid) {
            return query(left, right, index * 2);
        } else if (mid < left) {
            return query(left, right, index * 2 + 1);
        } else {
            return Math.max(query(mid + 1, right, index * 2 + 1), query(left, mid, index * 2));
        }

    }
}

class CF1828D1maxNode {
    int l;
    int r;
    int maxVal;
}



class CF1828D1SegSmall{
    CF1828D1minNode[] segTree;
    int[] initialVal;


    CF1828D1SegSmall(int[] v) {
        initialVal = new int[v.length];
        segTree = new CF1828D1minNode[v.length*4];

        for (int i = 0; i < initialVal.length; i++) {
            initialVal[i] = v[i];
        }

        build(1, v.length, 1);
    }

    void build(int left, int right, int index) {
        segTree[index] = new CF1828D1minNode();
        segTree[index].l = left;
        segTree[index].r = right;

        if (left == right) {
            segTree[index].minVal = initialVal[left - 1];
            return;
        }

        int mid = (left + right) / 2;

        build(left, mid, index * 2);
        build(mid + 1, right, index * 2 + 1);

        segTree[index].minVal = Math.min(segTree[index * 2].minVal, segTree[index * 2 + 1].minVal);
    }


    void update(int pos, int val, int index) {
        if (segTree[index].l == pos && segTree[index].r == pos) {
            segTree[index].minVal = val;
            return;
        }

        int mid = (segTree[index].l + segTree[index].r) / 2;
        if (pos <= mid) {
            update(pos, val, index * 2);
        } else {
            update(pos, val, index * 2 + 1);
        }

        segTree[index].minVal = Math.min(segTree[index * 2].minVal, segTree[index * 2 + 1].minVal);
    }

    int query(int left, int right, int index) {
        if (segTree[index].l == left && segTree[index].r == right) {
            return segTree[index].minVal;
        }
        if(segTree[index].r == segTree[index].l){
            return segTree[index].minVal;
        }

        int mid = (segTree[index].l + segTree[index].r) / 2;
        if (right <= mid) {
            return query(left, right, index * 2);
        } else if (mid < left) {
            return query(left, right, index * 2 + 1);
        } else {
            return Math.min(query(mid + 1, right, index * 2 + 1), query(left, mid, index * 2));
        }

    }
}

class CF1828D1minNode {
    int l;
    int r;
    int minVal;
}