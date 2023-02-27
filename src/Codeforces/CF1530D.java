package Codeforces;
/*
question name "Secret Santa"

 */
import java.util.*;

public class CF1530D {


}


class CF1530DAlgo {


    boolean hasIndeg[];
    int outDeg[];

    int[] id;
    int[] size;
    PriorityQueue<CF1530DEdge> Edges;
    int count = 0;


    CF1530DAlgo(int s, PriorityQueue<CF1530DEdge> allEdges){
        hasIndeg = new boolean[s];


        Edges = allEdges;
        size = new int[s];
        id = new int[s];
        for (int i = 0; i < s; i++) {
            size[i] = 1;
            id[i] = i;
        }
    }


    int find(int p){
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    boolean connected (int p, int q){
        return find(p) == find(q);
    }
    void union(int p, int q){
        int a = find(p);
        int b = find(q);

        if(a != b){
            if(size[a] > size[b]){
                id[b] = id[a];
                size[a] += size[b];
            }
            else{
                id[a] = id[b];
                size[b] += size[a];
            }
        }
    }


    void solve(){
        while(!Edges.isEmpty()){
            CF1530DEdge curr = Edges.poll();
            if(!connected(curr.a, curr.b)){
                union(curr.a, curr.b);
                count+= curr.weight;
            }
        }
    }


}

class CF1530DEdge implements Comparable<CF1530DEdge>{
    int a, b;
    int weight;

    CF1530DEdge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.weight = w;
    }

    @Override
    public int compareTo(CF1530DEdge o) {
        return Integer.compare(o.weight, weight);
    }
}
