package CodeforcesPract.SegTree;
import java.util.*;
import java.io.*;
public class CF610E {
    public static int [][]cnt;
    public static void main(String[] args)throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        cnt = new int[200][200];
        int n = in.nextInt(), q = in.nextInt(), k = in.nextInt();
        char [] s = in.next().toCharArray();
        Interval_Map imap = new Interval_Map();
        imap.build(n, s);
        for(int i = 0; i < q; i++){
            int type = in.nextInt();
            if(type == 1){
                int l = in.nextInt() , r = in.nextInt();
                char c = in.next().charAt(0);
                imap.range_update(l, r, c);
            }
            else{
                char [] t = in.next().toCharArray();
                int ans = n;
                for(int a = 0; a < k; a++){
                    for(int b = a+1; b < k; b++){
                        ans -= cnt[t[a]][t[b]];
                    }
                }

                pw.println(ans);
            }
        }




        pw.close();
    }

    static class Interval_Map{
        TreeMap<Integer, Character> map;
        Interval_Map(){
            map = new TreeMap<>();
        }

        void build(int n, char[]s){
            map.put(0, '0');
            map.put(n+1, '1');
            for(int i = 0; i < n; i++){
                map.put(i+1, s[i]);
                if(i+1 < n) cnt[s[i]][s[i+1]]++;
            }
        }

        void range_update(int l, int r, char c){
            int left = map.lowerKey(l);
            int right = map.floorKey(r), right2 = map.higherKey(r);
            if(r+1 < right2){
                map.put(r+1, map.get(right));
                right2 = r+1;
            }

            int key1 = left;
            for(int key2: map.subMap(left, false, right2, true).keySet()){
                cnt[map.get(key1)][map.get(key2)]--;
                key1 = key2;
            }

            map.subMap(left, false, right2, false).clear();

            map.put(l, c);
            cnt[map.get(left)][c]++;
            cnt[c][map.get(right2)]++;
        }

    }

    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next()throws Exception {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        public String nextLine()throws Exception {
            String line = null;
            tokenizer = null;
            line =  reader.readLine();
            return line;
        }

        public int nextInt()throws Exception {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws Exception{
            return Double.parseDouble(next());
        }

        public long nextLong()throws Exception {
            return Long.parseLong(next());
        }

    }

}
