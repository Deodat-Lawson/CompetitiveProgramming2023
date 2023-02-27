package CodeforcesAnswers;

import java.io.*;
import java.util.*;

public class CF860DAns {
    static int n, m;
    static ArrayList<Edge>[] arr;
    static ArrayList<int[]> ans = new ArrayList<>();
    static boolean[] used, paired;

    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader file = new BufferedReader(new FileReader("file.in"));
        //PrintWriter outfile = new PrintWriter (new BufferedWriter(new FileWriter("WizardsTour.out")));
        StringTokenizer st = new StringTokenizer(file.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(file.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            arr[s].add(new Edge(e, i));
            arr[e].add(new Edge(s, i));
        }
        used = new boolean[n];
        paired = new boolean[m];
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                dfs(i, -1, -1);
            }
        }
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i)[0] + " " + ans.get(i)[1] + " " + ans.get(i)[2]);
        }
    }

    public static void dfs(int curr, int parent, int eid) {
        used[curr] = true;
        Edge prev = null;
        for (Edge e : arr[curr]) {
            if (!used[e.node]) {
                dfs(e.node, curr, e.id);
                if (!paired[e.id]) {
                    if (prev == null) {
                        prev = e;
                    } else {
                        ans.add(new int[]{prev.node + 1, curr + 1, e.node + 1});
                        prev = null;
                    }
                }
                paired[e.id] = true;
            } else if (!paired[e.id] && e.node != parent) {
                if (prev == null) {
                    prev = e;
                } else {
                    ans.add(new int[]{prev.node + 1, curr + 1, e.node + 1});
                    prev = null;
                }
                paired[e.id] = true;
            }
        }
        if (eid != -1 && prev != null && !paired[eid]) {
            ans.add(new int[]{prev.node + 1, curr + 1, parent + 1});
            paired[eid] = true;
        }
    }

    static class Edge {
        int id;
        int node;

        public Edge(int node, int id) {
            this.id = id;
            this.node = node;
        }
    }
}

