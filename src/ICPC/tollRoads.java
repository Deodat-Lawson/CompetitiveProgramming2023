//package ICPC;
//
//import java.io.*;
//import java.util.*;
//
//public class tollRoads {
//    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer tok;
//
//
//    public static void main(String[] args) throws IOException {
//        int n = nextInt();
//        int m = nextInt();
//        int q = nextInt();
//
//        int[] firstPosForEdge = new int[n + 1];
//        Map<Integer, ArrayList<tollRoadQuery>> allMap = new HashMap<>();
//        Map<Integer, ArrayList<cityPair>> allPairMap = new HashMap<>();
//
//        ArrayList<Integer> weights = new ArrayList<>();
//        HashSet<Integer> containW = new HashSet<>();
//
//        for (int i = 0; i <= n; i++) {
//            firstPosForEdge[i] = Integer.MAX_VALUE;
//        }
//
//        for (int i = 0; i < m; i++) {
//            int a = nextInt();
//            int b = nextInt();
//            int w = nextInt();
//
//            if (containW.contains(w)) {
//                weights.add(w);
//                containW.add(w);
//            }
//
//            ArrayList<cityPair> thisP = allPairMap.getOrDefault(w, new ArrayList<>());
//            thisP.add(new cityPair(a, b, w));
//            allPairMap.put(w, thisP);
//        }
//
//        Collections.sort(weights);
//
//
//        for (ArrayList<cityPair> currentP : allPairMap.values()
//        ) {
//            for (int i = 0; i < currentP.size(); i++) {
//                cityPair cityPairI = currentP.get(i);
//                firstPosForEdge[cityPairI.a] = Math.min(firstPosForEdge[cityPairI.a], cityPairI.w);
//                firstPosForEdge[cityPairI.b] = Math.min(firstPosForEdge[cityPairI.b], cityPairI.w);
//            }
//        }
//
//        //gets everything put in the map
//
//        for (int i = 0; i < q; i++) {
//            int a = nextInt();
//            int b = nextInt();
//            int maxPosForPts = Math.max(firstPosForEdge[a], firstPosForEdge[b]);
//            ArrayList<tollRoadQuery> queryAtThisVal = allMap.getOrDefault(maxPosForPts, new ArrayList<>());
//            queryAtThisVal.add(new tollRoadQuery(a, b, i));
//            allMap.put(maxPosForPts, queryAtThisVal);
//        }
//
//
//        for (int i = 0; i < weights.size(); i++) {
//
//
//        }
//
//
//    }
//
//    static String next() throws IOException {
//        while (tok == null || !tok.hasMoreTokens()) {
//            tok = new StringTokenizer(f.readLine().trim());
//        }
//        return tok.nextToken();
//    }
//
//    static long nextLong() throws IOException {
//        return Long.parseLong(next());
//    }
//
//    static int nextInt() throws IOException {
//        return Integer.parseInt(next());
//    }
//
//    static double nextDouble() throws IOException {
//        return Double.parseDouble(next());
//    }
//
//    static char nextCharacter() throws IOException {
//        return next().charAt(0);
//    }
//
//    static String nextLine() throws IOException {
//        return f.readLine().trim();
//    }
//
//}
//
//class tollRoadQuery {
//    int posa, posb;
//    int arrayPosition;
//    int answer;
//    int city;
//
//    tollRoadQuery(int a, int b, int index) {
//        posa = a;
//        posb = b;
//        arrayPosition = index;
//    }
//
//}
//
//class cityPair {
//    int a, b;
//    int w;
//
//    cityPair(int a, int b, int w) {
//        this.a = a;
//        this.b = b;
//        this.w = w;
//    }
//
//    public static Comparator<cityPair> c = new Comparator<cityPair>() {
//        @Override
//        public int compare(cityPair o1, cityPair o2) {
//            return Integer.compare(o1.w, o2.w);
//        }
//    };
//
//}
//
//class tollDSU {
//    int[] parent;
//    int nodes;
//
//    tollDSU(int n) {
//        parent = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//    }
//
//    boolean connected(int p, int q){
//        return
//    }
//
//    boolean addE(int p, int q){
//
//    }
//
//    boolean findParent(int p){
//        while( p)
//    }
//}