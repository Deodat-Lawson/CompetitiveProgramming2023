package CodeforcesPract.SegTree;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.*;

public class CF609F {

    static void solve() throws IOException {
        int fn = nextInt();
        int kn = nextInt();
        Frog[] f = new Frog[fn];
        for ( int i = 0; i < fn; i ++ ) {
            f[i] = new Frog( i, nextInt(), nextInt() );
        }
        Arrays.sort( f, ( f1, f2 ) -> Integer.compare( f1.x, f2.x ) );
        Comparator< Frog > setComparator = ( f1, f2 ) -> Long.compare( f1.x + f1.t, f2.x + f2.t );
        TreeSet<Frog> set = new TreeSet<>( setComparator );
        for ( Frog frog : f ) {
            if ( set.isEmpty() || setComparator.compare( frog, set.last() ) > 0 ) {
                set.add( frog );
            }
        }
        TreeMap<Integer, Kom> map = new TreeMap<>();
        for ( ; kn > 0; kn -- ) {
            int pos = nextInt();
            int size = nextInt();
            if ( map.containsKey( pos ) ) {
                Kom kom = map.get( pos );
                map.put( pos, new Kom( kom.size + size, kom.cnt + 1 ) );
            } else {
                map.put( pos, new Kom( size, 1 ) );
            }
            SortedSet< Frog > tailSet = set.tailSet( new Frog( -1, pos, 0 ) );
            if ( tailSet.isEmpty() ) continue;
            Frog frog = tailSet.first();
            set.remove( frog );
            while ( true ) {
                SortedMap< Integer, Kom > tailMap = map.tailMap( frog.x );
                if ( tailMap.isEmpty() ) break;
                Integer firstKey = tailMap.firstKey();
                if ( firstKey > frog.x + frog.t ) break;
                Kom kom = map.get( firstKey );
                frog.t += kom.size;
                frog.ate += kom.cnt;
                map.remove( firstKey );
            }
            Frog frog1 = frog.incTail();
            while ( true ) {
                SortedSet< Frog > headSet = set.headSet( frog1 );
                if ( headSet.isEmpty() ) break;
                Frog last = headSet.last();
                if ( last.x < frog.x ) break;
                set.remove( last );
            }
            set.add( frog );
        }
        Arrays.sort( f, ( f1, f2 ) -> Integer.compare( f1.id, f2.id ) );
        for ( Frog frog : f ) {
            out.println( frog.ate + " " + frog.t );
        }
    }

    private static class Kom {
        long size;
        int cnt;

        Kom( long s, int c ) {
            size = s;
            cnt = c;
        }
    }

    private static class Frog {
        int id;
        int x;
        long t;
        int ate;

        Frog( int Id, int X, long T ) {
            id = Id;
            x = X;
            t = T;
        }

        public Frog incTail() {
            return new Frog( -1, x, t + 1 );
        }
    }

    static StreamTokenizer in;
    static PrintWriter out;

    static int nextInt() throws IOException {
        in.nextToken();
        return ( int ) in.nval;
    }

    public static void main( String[] args ) throws IOException {
        in = new StreamTokenizer( new InputStreamReader( System.in ) );
        out = new PrintWriter( System.out );
        solve();
        out.close();
    }
}