package CodeforcesAnswers;

import java.io.*;
import java.util.*;


public class CF1779DAns {

    public static void solve(IO io) {
        int n = io.getInt();
        int b[] = new int[n];
        boolean u[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            b[i] = io.getInt();
        }
        boolean impossible = false;
        for (int i = 0; i < n; i++) {
            int x = io.getInt();
            u[i] = (x == b[i]);
            if (x > b[i]) {
                impossible = true;
            }
            b[i] = x;
        }
        int m = io.getInt();
        int[] r = new int[m];
        HashMap<Integer, Integer> rs = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = io.getInt();
            if (rs.containsKey(x)) {
                rs.put(x, rs.get(x) + 1);
            } else {
                rs.put(x, 1);
            }
        }
        if (impossible) {
            System.out.println("NO");
            return;
        }
        TreeSet<Integer> on = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            on.headSet(b[i]).clear();
            //this function clears all the elements that are smaller than the specific value

            /*
            If the number is greater than the previous numbers, then we need to recount all the previous numbers
            As a result, we delete all the previous numbers.
            Using a TreeSet proves to be the most efficient
             */

            if (!u[i] && !on.contains(b[i])) {
                on.add(b[i]);
                if (!rs.containsKey(b[i]) || rs.get(b[i]) <= 0) {
                    System.out.println("NO");
                    return;
                }
                rs.put(b[i], rs.get(b[i]) - 1);
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
        IO io = new IO();
        int t = io.getInt();
        for (int testIndex = 0; testIndex < t; testIndex++) {
            solve(io);
        }
        io.close();
    }

    static class IO extends PrintWriter {

        public IO() {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(System.in));
        }

        public IO(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public IO(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }

        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null)
                            return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }

}
