package Codeforces;

import java.io.*;
import java.util.*;

public class CF339D {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    solve();
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
    int n = nextInt();
    int m = nextInt();
    int[] vals = new int[(int)Math.pow(2,n)];
    for (int i = 0; i < vals.length; i++) {
      vals[i] = nextInt();
    }
    CF339DSeg thisSegT = new CF339DSeg(vals);
    for (int i = 0; i < m; i++) {
      int pos = nextInt() - 1;
      int b = nextInt();
      thisSegT.update(pos, b, 1);
      thisSegT.query();
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

class CF339DSeg{
  int[] initialv;
  CF339DNode[] segTree;
  CF339DSeg(int[] iniArr){
    segTree = new CF339DNode[4*iniArr.length];
    initialv = new int[iniArr.length];
    int size = iniArr.length;
    for (int i = 0; i < size; i++) {
      initialv[i] = iniArr[i];
    }
    build(0, size - 1, 1);

  }


  void build(int l, int r, int index){
    segTree[index] =  new CF339DNode();
    segTree[index].l = l;
    segTree[index].r = r;
    if(l == r){
      segTree[index].val = initialv[l];
      segTree[index].or = true;
      return;
    }
    int mid = (l + r)/2;
    build(l, mid, index * 2);
    build(mid+ 1, r, index * 2 + 1);

    if(segTree[index*2].or){
      segTree[index].val = segTree[index*2].val | segTree[index*2 + 1].val;
      segTree[index].or = false;
    }
    else{
      segTree[index].val = segTree[index *2].val ^ segTree[index * 2 + 1].val;
      segTree[index].or = true;
    }

  }

  void update(int pos, int val, int index){
    if(segTree[index].l == pos && segTree[index].r == pos){
      segTree[index].val = val;
      return;
    }

    int mid = (segTree[index].l + segTree[index].r)/2;
    if(pos > mid){
      update(pos, val, index * 2 + 1);
    }
    else{
      update(pos, val, index * 2);
    }

    if(segTree[index*2].or){
      segTree[index].val = segTree[index*2].val | segTree[index*2 + 1].val;
      segTree[index].or = false;
    }
    else{
      segTree[index].val = segTree[index *2].val ^ segTree[index * 2 + 1].val;
      segTree[index].or = true;
    }

  }

  void query(){
    System.out.println(segTree[1].val);
  }


}


class CF339DNode{
  CF339DNode(){
    l = -1;
    r = -1;
    val = -1;
    or = true;
  }
  int l, r, val;
  boolean or;
}