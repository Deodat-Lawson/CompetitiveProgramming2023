package CodeforcesPract.SegTree;

import java.io.*;
import java.util.*;

public class CF121E extends PrintWriter {
        CF121E() { super(System.out); }
        static class Scanner {
            Scanner(InputStream in) { this.in = in; } InputStream in;
            int k, l; byte[] bb = new byte[1 << 15];
            byte getc() {
                if (k >= l) {
                    k = 0;
                    try { l = in.read(bb); } catch (IOException e) { l = 0; }
                    if (l <= 0) return -1;
                }
                return bb[k++];
            }
            int nextInt() {
                byte c = 0; while (c <= 32) c = getc();
                int a = 0;
                while (c > 32) { a = a * 10 + c - '0'; c = getc(); }
                return a;
            }
            int m = 1 << 7; byte[] cc = new byte[m];
            int read() {
                byte c = 0; while (c <= 32) c = getc();
                int n = 0;
                while (c > 32) {
                    if (n == m) cc = Arrays.copyOf(cc, m <<= 1);
                    cc[n++] = c; c = getc();
                }
                return n;
            }
            String next() { int n = read(); return new String(cc, 0, n); }
        }
        Scanner sc = new Scanner(System.in);
        public static void main(String[] $) {
            CF121E o = new CF121E(); o.main(); o.flush();
        }

        static final int INF = 20000;
        int n, m;
        int[] aa, tt, ll, rr, xx;
        int h_, n_;
        int[] max, cnt, lz;
        void init() {
            h_ = 0;
            while (1 << h_ < n)
                h_++;
            n_ = 1 << h_;
            max = new int[n_ * 2]; cnt = new int[n_ * 2]; lz = new int[n_];
        }
        void put(int i, int x) {
            max[i] += x;
            if (i < n_)
                lz[i] += x;
        }
        void pull1(int i) {
            int l = i << 1, r = l | 1;
            if (max[l] > max[r]) {
                max[i] = max[l]; cnt[i] = cnt[l];
            } else if (max[l] < max[r]) {
                max[i] = max[r]; cnt[i] = cnt[r];
            } else {
                max[i] = max[l]; cnt[i] = cnt[l] + cnt[r];
            }
        }
        void push(int i) {
            for (int h = h_; h > 0; h--) {
                int a = i >> h;
                if (lz[a] != 0) {
                    put(a << 1, lz[a]);
                    put(a << 1 | 1, lz[a]);
                    lz[a] = 0;
                }
            }
        }
        void pull(int i) {
            while (i > 1) {
                i >>= 1;
                if (lz[i] == 0)
                    pull1(i);
            }
        }
        void build(int y) {
            for (int i = 0; i < n_; i++) {
                max[n_ + i] = -INF; cnt[n_ + i] = 0;
            }
            for (int i = 0; i < n; i++)
                if (aa[i] <= y) {
                    max[n_ + i] = aa[i]; cnt[n_ + i] = 1;
                }
            for (int i = n_ - 1; i > 0; i--)
                pull1(i);
            Arrays.fill(lz, 0);
        }
        void update_(int i, int x, int y) {
            put(i, x);
            if (max[i] <= y)
                return;
            if (i >= n_) {
                max[i] = -INF; cnt[i] = 0;
                return;
            }
            x = lz[i]; lz[i] = 0;
            update_(i << 1, x, y);
            update_(i << 1 | 1, x, y);
            pull1(i);
        }
        void update(int l, int r, int x, int y) {
            int l_ = l += n_, r_ = r += n_;
            push(l_); push(r_);
            for ( ; l <= r; l >>= 1, r >>= 1) {
                if ((l & 1) == 1)
                    update_(l++, x, y);
                if ((r & 1) == 0)
                    update_(r--, x, y);
            }
            pull(l_); pull(r_);
        }
        int query(int l, int r, int y) {
            push(l += n_); push(r += n_);
            int ans = 0;
            for ( ; l <= r; l >>= 1, r >>= 1) {
                if ((l & 1) == 1) {
                    if (max[l] == y)
                        ans += cnt[l];
                    l++;
                }
                if ((r & 1) == 0) {
                    if (max[r] == y)
                        ans += cnt[r];
                    r--;
                }
            }
            return ans;
        }
        void solve(int y) {
            build(y);
            for (int h = 0; h < m; h++) {
                int l = ll[h], r = rr[h];
                if (tt[h] == 0)
                    update(l, r, xx[h], y);
                else
                    xx[h] += query(l, r, y);
            }
        }
        void main() {
            n = sc.nextInt();
            m = sc.nextInt();
            aa = new int[n];
            for (int i = 0; i < n; i++)
                aa[i] = sc.nextInt();
            tt = new int[m]; ll = new int[m]; rr = new int[m]; xx = new int[m];
            for (int h = 0; h < m; h++) {
                tt[h] = sc.next().charAt(0) == 'a' ? 0 : 1;
                ll[h] = sc.nextInt() - 1;
                rr[h] = sc.nextInt() - 1;
                if (tt[h] == 0)
                    xx[h] = sc.nextInt();
            }
            init();
            for (int b = 2; b < 32; b++) {
                int y = 0;
                for (int a = b; a > 1; a >>= 1)
                    y = y * 10 + ((a & 1) == 0 ? 4 : 7);
                solve(y);
            }
            for (int h = 0; h < m; h++)
                if (tt[h] == 1)
                    println(xx[h]);
        }
    }

