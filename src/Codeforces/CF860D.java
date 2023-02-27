//package Codeforces;
//
//import java.util.*;
//import java.io.*;
//
//public class CF860D {
//
//    static ArrayList<Integer>[] adjList;
//    static int[] edgesSizes;
//    static HashMap<Integer, ArrayList<Integer>> connectedComponents;
//    static ArrayList<int[]> ans;
//
//
//    public static void main(String[] args){
//
//
//        //read input
//
//
//        //create DSU
//
//
//        //find connected components
//
//
//        //run algorithm
//
//
//
//
//
//
//
//
//
//
//    }
//
//
//    static int maxPaths(ArrayList<Integer> list, ArrayList<Integer>[] sizeOfEdges, int currentSmallestEdge){
//        int count = 0;
//        while(currentSmallestEdge != 0){
//
//            if(currentSmallestEdge == 1){
//                //try to move and change the smallest edge
//                int[] currM = new int[3];
//                //move to the only road
//                currM[0] = currentSmallestEdge;
//                currM[1] = adjList[currentSmallestEdge].get(0);
//
//                sizeOfEdges[1].remove(currentSmallestEdge);
//                sizeOfEdges[0].add(currentSmallestEdge);
//
//                sizeOfEdges[edgesSizes[currM[1]]].remove(edgesSizes[currM[1]]);
//                sizeOfEdges[edgesSizes[currM[1]]-1].add(edgesSizes[currM[1]]);
//
//
//            }
//
//
//
//
//        }
//
//
//    }
//
//
//}
//
//
//class CF860DSU{
//    int n;
//    int[] id;
//    int[] size;
//
//    CF860DSU(int n){
//        this.n = n;
//
//        id = new int[n];
//        size = new int[n];
//
//        for(int i = 0; i < n; i++){
//            id[i] = i;
//            size[i] = 1;
//        }
//
//    }
//
//    int find(int p){
//        while(p != id[p]){
//            p = id[p];
//        }
//        return p;
//    }
//
//    boolean connected(int p, int q){
//        return find(p) == find(q);
//    }
//
//    void union(int p, int q){
//        int i = find(p);
//        int j = find(q);
//        if(i == j) return;
//
//        if(size[i] > size[j]){
//            id[j] = i;
//            size[i] += size[j];
//        }
//        else{
//            id[i] = j;
//            size[j] += size[i];
//        }
//
//    }
//
//}
