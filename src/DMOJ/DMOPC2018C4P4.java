package DMOJ;
import java.util.*;
import java.io.*;
public class DMOPC2018C4P4 {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;

    //initialization here
    static long[] BIT;
    public static void main(String[] args) throws IOException {
        //code here


        int N = nextInt();
        int Q = nextInt();

        BIT = new long[N+1];

        //get and initialize all the points
        ArrayList<Number> allNums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int a = nextInt();
            allNums.add(new Number(a, i));
            add(-a,i+1);
        }
        Collections.sort(allNums, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                int result = Integer.compare(o1.value, o2.value);
                return -result;
            }
        });

        //Numbers sorted from biggest number to smallest number

        //get and initialize all Query
        ArrayList<Query> allQuery = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            int l = nextInt();
            int r = nextInt();
            int k = nextInt();
            allQuery.add(new Query(l,r,k,i));
        }
        Collections.sort(allQuery, new Comparator<Query>() {
            @Override
            public int compare(Query o1, Query o2) {
                int result = Integer.compare(o1.k, o2.k);
                return -result;
            }
        });

        //Query sorted from biggest k to smallest k

        ArrayList<Answer> allAns= new ArrayList<>();

        int numIndex = 0;

        for (int i = 0; i < allQuery.size(); i++) {
            Query thisQ = allQuery.get(i);
            int pointK = thisQ.k;
            while(numIndex < allNums.size() && allNums.get(numIndex).value >= pointK){
                add(allNums.get(numIndex).value,allNums.get(numIndex).position +1);
                add(allNums.get(numIndex).value,allNums.get(numIndex).position +1);
                numIndex++;
            }

            long leftPointSum = sum(thisQ.left -1);
            long rightPointSum = sum(thisQ.right);
            long ans = rightPointSum - leftPointSum;
            allAns.add(new Answer(ans, thisQ.position));
        }

        Collections.sort(allAns, new Comparator<Answer>() {
            @Override
            public int compare(Answer o1, Answer o2) {
                int result = Long.compare(o1.pos, o2.pos);
                return result;
            }
        });

        for (int i = 0; i < allAns.size(); i++) {
            System.out.println(allAns.get(i).ans);
        }




    }

    static void add (int val, int pos){
        while(pos < BIT.length){
            BIT[pos] +=val;
            pos+= (pos & -pos);
        }
    }

    static long sum (int index){
        long s = 0;
        while(index > 0){
            s += BIT[index];
            index-= (index &-index);
        }
        return s;
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

class Number{
    int value, position;

    Number(int val, int pos){
        value = val;
        position = pos;
    }

}

class Query{
    int left, right, k, position;

    Query(int left, int right, int k, int position){
        this.left = left;
        this.right = right;
        this.k = k;
        this.position = position;
    }

}

class Answer{
    long ans, pos;

    Answer(long ans, int pos){
        this.ans = ans;
        this.pos = pos;
    }

}