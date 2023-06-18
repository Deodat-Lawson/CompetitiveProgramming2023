package DMOJ;

import java.util.*;
import java.io.*;

public class CCO2011P4 {

    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    //initialization here
    public static void main(String[] args) throws IOException {
        //code here
        int N = nextInt();
        int[] allPPl = new int[N];
        for (int i = 0; i < N; i++) {
            allPPl[i] = nextInt();
        }

        int[] allPPlTrack = new int[N];
        ReorgBST newBST = new ReorgBST();

        for (int i = 0; i < N; i++) {
            if (newBST.size() == 0) {
                newBST.put(allPPl[i],i);
            } else {
                if (allPPl[i] < newBST.min()) {
                    System.out.println("NO");
                    return;
                } else {
                    int toConnectValue = newBST.floor(allPPl[i]);
                    int toConnectIndex = newBST.get(toConnectValue);
                    allPPlTrack[toConnectIndex]++;
                    if (allPPlTrack[toConnectIndex] == 2) {
                        newBST.delete(toConnectValue);
                    }
                    newBST.put(allPPl[i],i);
                }

            }
        }
        System.out.println("YES");


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

class ReorgBST {
    BSTNode root;

    private class BSTNode {
        private int key; // key
        private int val; // associated value
        private BSTNode left, right; // links to subtrees
        private int N; // # nodes in subtree rooted here

        public BSTNode(int key, int val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    int size() {
        return size(root);
    }

    int size(BSTNode x) {
        if (x == null) return 0;
        return x.N;
    }

    public int get(int key) {
        return get(root, key);
    }

    int get(BSTNode x, int key) {
        if (x == null) return -1;
        if (x.key > key) return get(x.left, key);
        else if (key > x.key) return get(x.right, key);
        else return x.val;
    }

    public void put(int key, int val) {
        root = put(root, key, val);
    }

    BSTNode put(BSTNode x, int key, int val) {
        if (x == null) return new BSTNode(key, val, 1);
        if (x.key > key) x.left = put(x.left, key, val);
        else if (key > x.key) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int min() {
        return min(root).key;
    }

    private BSTNode min(BSTNode x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public int floor(int key) {
        BSTNode x = floor(root, key);
        if (x == null) return -1;
        return x.key;
    }

    private BSTNode floor(BSTNode x, int key) {
        if (x == null) return null;
        if (key == x.key) return x;
        if (key < x.key) return floor(x.left, key);
        BSTNode t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }


    public int select(int k) {
        return select(root, k).key;
    }

    private BSTNode select(BSTNode x, int k) { // Return Node containing key of rank k.
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }


    public void deleteMin() {
        root = deleteMin(root);
    }

    private BSTNode deleteMin(BSTNode x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private BSTNode delete(BSTNode x, int key) {
        if (x == null) return null;
        if (key < x.key) x.left = delete(x.left, key);
        else if (key > x.key) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            BSTNode t = x;
            x = min(t.right); // See page 407.
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


}
