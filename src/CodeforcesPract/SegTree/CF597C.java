package CodeforcesPract.SegTree;
import java.io.*;
import java.util.*;

class CF597C{
    private static class Fenwick {
        long[] f;

        public Fenwick(int n) {
            f = new long[n + 1];
        }

        public void add(int i, long value) {
            for (; i < f.length; i += (i & -i))
                f[i] += value;
        }

        public long get(int i) {
            long sum = 0;
            for (; i > 0; i -= (i & -i))
                sum += f[i];
            return sum;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        if (k == 0) {
            System.out.println(n);
            System.exit(0);
        }

        Fenwick[] dp = new Fenwick[k];
        for (int i = 0; i < k; i++)
            dp[i] = new Fenwick(n);
        long result = 0;
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            dp[0].add(a, 1);
            for (int j = 1; j < k; j++)
                dp[j].add(a, dp[j - 1].get(a - 1));
            result += dp[k - 1].get(a - 1);
        }
        System.out.println(result);
        scan.close();
    }
}
