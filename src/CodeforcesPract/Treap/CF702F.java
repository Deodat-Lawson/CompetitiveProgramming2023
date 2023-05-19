package CodeforcesPract.Treap;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CF702F {static final Random rand = new Random();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // 1. Read tshirts and sort them
        int n = sc.nextInt(), c[] = new int[n], q[] = new int[n];
        Integer[] tIdx = new Integer[n];
        for (int i = 0; i < n; ++i) {
            c[i] = sc.nextInt();
            q[i] = sc.nextInt();
            tIdx[i] = i;
        }
        Arrays.sort(tIdx, (x, y) -> q[x] != q[y] ? q[y] - q[x] : c[x] - c[y]);

        // 2. Construct treap one node for each customer with initial budget
        int m = sc.nextInt(), b[] = new int[m];
        Integer[] bIdx = new Integer[m];
        for (int i = 0; i < m; ++i)
            b[bIdx[i] = i] = sc.nextInt();
        Arrays.sort(bIdx, (x, y) -> b[x] - b[y]);

        ICPC100488L.Node treap = null;
        for (int i : bIdx)
            treap = merge(treap, new ICPC100488L.Node(b[i], i));


        // 3. Simulate by buying tshirts one by one
        for (int i : tIdx)
        {
            // + X: customers with budget < c[i] will not be affected
            // + Y: customers with budget >= c[i] will have answer increased by 1 and
            //      their budgets will be decreased by c[i]

            // A. Split customers into the above two types (X and Y)
            ICPC100488L.TwoNode tt = split(treap, c[i]);
            // B. Update customers of the type Y
            updateCustomers(tt.right, c[i]);

            // C. If smallest budget in Y is < largest budget in X, then move this
            //    budget to its correct place in X
            if(tt.left == null || tt.right == null)
                continue;
            ICPC100488L.Node lr = rightMost(tt.left), rl = leftMost(tt.right);
            while(rl.budget < lr.budget)
            {
                ICPC100488L.TwoNode tt1 = split(tt.left, rl.budget + 1);
                ICPC100488L.TwoNode tt2 = split(tt.right, rl.budget + 1);
                tt.left = merge(tt1.left, merge(tt2.left, tt1.right));
                tt.right = tt2.right;

                if(tt.left == null || tt.right == null)
                    break;
                lr = rightMost(tt.left);
                rl = leftMost(tt.right);
            }
            // D. Merge the two customers back
            treap = merge(tt.left, tt.right);
        }

        // 4. Traverse the treap to get the solution
        ans = new int[m];
        traverse(treap);
        for (int x : ans)
            out.print(x + " ");
        out.close();
    }

    static int[] ans;


    static ICPC100488L.Node merge(ICPC100488L.Node l, ICPC100488L.Node r) {
        if (l == null || r == null)
            return l == null ? r : l;
        push(l); push(r);
        if (l.prior > r.prior) {
            l.right = merge(l.right, r);
            return l;
        } else {
            r.left = merge(l, r.left);
            return r;
        }
    }

    static ICPC100488L.TwoNode split(ICPC100488L.Node t, int minBudget)
    {
        if(t == null)
            return new ICPC100488L.TwoNode(null, null);
        push(t);
        if(t.budget >= minBudget)
        {
            ICPC100488L.TwoNode tn = split(t.left, minBudget);
            t.left = tn.right;
            return new ICPC100488L.TwoNode(tn.left, t);
        }
        else
        {
            ICPC100488L.TwoNode tn = split(t.right, minBudget);
            t.right = tn.left;
            return new ICPC100488L.TwoNode(t, tn.right);
        }
    }

    static void traverse(ICPC100488L.Node t)
    {
        if(t == null)
            return;
        push(t);
        ans[t.id] = t.tshirts;
        traverse(t.left);
        traverse(t.right);
    }

    static void updateCustomers(ICPC100488L.Node t, int price)
    {
        if(t == null)
            return;
        t.lazyBudget -= price;
        t.lazyTshirts += 1;
    }

    static void push(ICPC100488L.Node t)
    {
        t.budget += t.lazyBudget;
        t.tshirts += t.lazyTshirts;

        if(t.left != null)
        {
            t.left.lazyBudget += t.lazyBudget;
            t.left.lazyTshirts += t.lazyTshirts;
        }

        if(t.right != null)
        {
            t.right.lazyBudget += t.lazyBudget;
            t.right.lazyTshirts += t.lazyTshirts;
        }
        t.lazyBudget = t.lazyTshirts = 0;
    }

    static ICPC100488L.Node leftMost(ICPC100488L.Node t)
    {
        push(t);
        if(t.left == null)
            return t;
        return leftMost(t.left);
    }

    static ICPC100488L.Node rightMost(ICPC100488L.Node t)
    {
        push(t);
        if(t.right == null)
            return t;
        return rightMost(t.right);
    }

    static class Node
    {
        ICPC100488L.Node left, right;
        int budget, lazyBudget;
        int tshirts, lazyTshirts;
        int id, prior;

        Node(int b, int i) { budget = b; id = i; prior = rand.nextInt(); }

    }

    static class TwoNode
    {
        ICPC100488L.Node left, right;

        TwoNode(ICPC100488L.Node a, ICPC100488L.Node b) { left = a; right = b; }
    }

}
