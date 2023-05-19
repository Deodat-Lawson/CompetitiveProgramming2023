package DMOJ;

import java.util.*;

public class CCC2015S4 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int K = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        DijGraph G = new DijGraph(N,K);

        for (int i = 0; i < M; i++) {
            G.addEdge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt(), sc.nextInt());
        }

        //bulid a dij graph and added all the edges
        int point1 = sc.nextInt()-1;
        int point2 = sc.nextInt()-1;
        Dij thisDij = new Dij(G,point1, point2);
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < thisDij.dist.length; i++) {
            smallest = Math.min(thisDij.dist[i][point2],smallest);
        }
        if(smallest == Integer.MAX_VALUE){
            System.out.println("-1");
            return;
        }
        System.out.println(smallest);

    }


}

class DijGraph {
    int V;
    int E;
    int H;
    LinkedList<p>[] adjList;

    DijGraph(int V, int H) {
        this.H = H;
        this.V = V;
        this.E = 0;
        adjList = (LinkedList<p>[]) new LinkedList[V];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }


    }

    void addEdge(int src, int to, int time, int hull) {
        adjList[src].addFirst(new p(to, time, hull,-1));
        adjList[to].addFirst(new p(src, time, hull,-1));
        E++;

    }


}


class p implements Comparable<p> {

    int to;
    int time;
    int hull;
    int par;

    p(int to, int time, int hull, int par) {
        this.to = to;
        this.time = time;
        this.hull = hull;
        this.par = par;
    }

    public int compareTo(p other) {
        if (time > other.time) {
            return 1;
        }
        return -1;

    }


}

class Dij {
    int[][] dist;
    PriorityQueue<p> pairs;


    Dij(DijGraph G, int src, int to) {
        dist = new int[G.H][G.V]; // each vertex with H hull
        pairs = new PriorityQueue<>();
        for (int i = 0; i < G.H; i++) {
            for (int j = 0; j < G.V; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][src] = 0; // the source vertex needs to have a time 0 with a hull of 0

        pairs.add(new p(src, 0, 0,-1)); //start at this

        while (!pairs.isEmpty()) {
            p currentP = pairs.poll();

            LinkedList<p> routes = G.adjList[currentP.to];
            for (p childP : routes
            ) {
                int time = dist[currentP.hull][currentP.to];
                time += childP.time;
                int hull = currentP.hull;
                hull += childP.hull;
                if (hull < G.H && childP.to != currentP.par && dist[hull][childP.to] > time) {
                    dist[hull][childP.to] = Math.min(dist[hull][childP.to],time);
                    pairs.add(new p(childP.to, time, hull, currentP.to));
                }

            }


        }


    }


}