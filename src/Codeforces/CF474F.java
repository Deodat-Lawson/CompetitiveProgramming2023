package Codeforces;

import java.io.*;
import java.util.*;

public class CF474F {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
    }

    CF474FSeg thisT = new CF474FSeg(arr);

    int m = nextInt();
    for (int i = 0; i < m; i++) {
      int a = nextInt() - 1;
      int b = nextInt() - 1;
      int gcd = thisT.gcdGet(a,b,1);

      int ans = thisT.query(a,b,1,gcd);

      ans = (b-a-ans+1);
      System.out.println(ans);
    }


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


class CF474FSeg{
  int[] iniVal;
  CF474SegNode[] segTree;

  CF474FSeg(int[] v){
    segTree = new CF474SegNode[4*v.length];
    iniVal = new int[v.length];
    for (int i = 0; i < v.length; i++) {
      iniVal[i] = v[i];
    }

    build(0, v.length -1,1);

  }

  void build(int l, int r, int index){
    segTree[index] = new CF474SegNode();
    segTree[index].l = l;
    segTree[index].r = r;

    if(l == r){
      segTree[index].gcd = iniVal[l];
      segTree[index].eq = 1;
      return;
    }

    int mid = (r + l)/2;
    build(l, mid, index*2);
    build(mid + 1, r, index*2 + 1);

    segTree[index].gcd = gcd(segTree[index*2].gcd, segTree[index*2 + 1].gcd);
    int e = 0;
    if(segTree[index].gcd == segTree[index*2].gcd){
      e+=segTree[index*2].eq;
    }
    if(segTree[index].gcd == segTree[index*2 + 1].gcd){
      e+=segTree[index*2 + 1].eq;
    }
    segTree[index].eq = e;

  }


  int gcdGet(int l, int r, int index){
    if(segTree[index].l == l && segTree[index].r == r){
      return segTree[index].gcd;
    }

    int mid = (segTree[index].l + segTree[index].r)/2;
    if(l > mid){
      return gcdGet(l,r,index*2 + 1);
    }
    else if(r <= mid){
      return gcdGet(l,r,index*2);
    }
    else{
      int gcd1 = gcdGet(mid+1, r, index*2 + 1);
      int gcd2 = gcdGet(l,mid, index*2);
      return gcd(gcd1, gcd2);
    }

  }

  int query(int l, int r, int index, int gcd){
    if(segTree[index].l == l && segTree[index].r == r){
      if(segTree[index].gcd == gcd){
        return segTree[index].eq;
      }
      else{
        return 0;
      }
    }

    int mid = (segTree[index].l + segTree[index].r)/2;
    if(l > mid){
      return query(l,r,index*2 + 1,gcd);
    }
    else if(r <= mid){
      return query(l,r,index*2,gcd);
    }
    else{
      int gcd1 = query(l, mid, index*2, gcd);
      int gcd2 = query(mid+1,r, index*2 +1, gcd);
      return gcd2 + gcd1;
    }


  }



  int gcd(int a, int b){
    if(b == 0){
      return a;
    }
    return gcd(b, a%b);
  }



}


class CF474SegNode{
  int l, r,eq;
  int gcd;


}