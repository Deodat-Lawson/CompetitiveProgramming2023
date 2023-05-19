package CodeforcesPract.Treap;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CF455D {
    private static final int maxSize = 100000 + 13;
    private static final int blockSize = 350;
    private static final int blockCount = maxSize / blockSize + 13;

    private static int[] a = new int[maxSize];

    private static int currBlock;
    private static int[][] values = new int[blockCount][2 * blockSize + 13];
    private static int[] valBlockSize = new int[blockCount];
    private static int[][] stored = new int[blockCount][2 * blockSize + 13];
    private static int[] storedBlockSize = new int[blockCount];
    private static short[][] cnt = new short[blockCount][maxSize];

    private static int arraySize;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        arraySize = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < arraySize; i++)
            a[i] = Integer.parseInt(tokenizer.nextToken());

        build();

        int q = Integer.parseInt(reader.readLine());
        int lastAns = 0;
        int c = 1;

        while (q-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int type = Integer.parseInt(tokenizer.nextToken());
            int lt = Integer.parseInt(tokenizer.nextToken());
            int rt = Integer.parseInt(tokenizer.nextToken());

            int l = (lt + lastAns - 1) % arraySize;
            int r = (rt + lastAns - 1) % arraySize;

            if (l > r) {
                int t = l;
                l = r;
                r = t;
            }

            if (type == 1) {
                shift(l, r);
                c++;
            } else {
                int kt = Integer.parseInt(tokenizer.nextToken());
                int k = (kt + lastAns - 1) % arraySize + 1;

                int res = count(l, r, k);
                lastAns = res;

                writer.println(res);
            }

            if (c % blockSize == 0)
                reBuild();
        }

        writer.flush();
        writer.close();

    }

    private static void build() {
        currBlock = 0;
        for (int i = 0; i < arraySize; i += blockSize, currBlock++)
            for (int j = i; j < Math.min(arraySize, i + blockSize); j++) {
                values[currBlock][valBlockSize[currBlock]++] = a[j];
                stored[currBlock][storedBlockSize[currBlock]++] = a[j];
                cnt[currBlock][a[j]]++;
            }
    }

    private static void reBuild() {
        int at = 0;

        for (int i = 0; at < arraySize; i++)
            for (int j = 0; j < valBlockSize[i]; j++)
                a[at++] = values[i][j];

        for (int i = 0; i < blockCount; i++) {
            for (int j = 0; j < valBlockSize[i]; j++)
                values[i][j] = 0;
            for (int j = 0; j < storedBlockSize[i]; j++) {
                cnt[i][stored[i][j]] = 0;
                stored[i][j] = 0;
            }

            valBlockSize[i] = storedBlockSize[i] = 0;
        }

        build();
    }

    private static int count(int l, int r, int k) {
        return count(r, k) - count(l - 1, k);
    }

    private static int count(int r, int k) {
        if (r < 0)
            return 0;

        int res = 0;
        int sum = 0;
        for (int i = 0; i < currBlock; i++) {
            sum += valBlockSize[i];
            if (sum <= r + 1)
                res += cnt[i][k];
            else {
                sum -= valBlockSize[i];
                for (int j = 0; sum <= r; j++, sum++)
                    if (values[i][j] == k)
                        res++;

                break;
            }
        }

        return res;
    }

    private static void shift(int l, int r) {
        if (l == r)
            return;
        int x = erase(r);
        insert(l, x);
    }

    private static void insert(int l, int x) {
        int sum = 0;
        for (int i = 0; ; i++) {
            sum += valBlockSize[i];
            if (sum > l) {
                stored[i][storedBlockSize[i]++] = x;
                cnt[i][x]++;
                int pos = l - (sum - valBlockSize[i]);

                for (int j = valBlockSize[i]; j > pos; j--)
                    values[i][j] = values[i][j - 1];
                values[i][pos] = x;
                valBlockSize[i]++;

                return;
            }
        }
    }

    private static int erase(int r) {
        int sum = 0;
        for (int i = 0; ; i++) {
            sum += valBlockSize[i];
            if (sum > r) {
                int pos = r - (sum - valBlockSize[i]);
                cnt[i][values[i][pos]]--;
                int res = values[i][pos];
                valBlockSize[i]--;

                for (int j = pos; j < valBlockSize[i]; j++)
                    values[i][j] = values[i][j + 1];

                return res;
            }
        }
    }
}

