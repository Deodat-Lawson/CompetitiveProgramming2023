package DMOJ;

import java.io.*;
import java.util.*;

public class SegmentTreeTest {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int m = nextInt();
    int[] list = new int[n];
    for (int i = 0; i < n; i++) {
      list[i] = nextInt();
    }

    segTreeMin thisSegM = new segTreeMin(list);
    segTreeGCD thisSegG = new segTreeGCD(list);

    for (int i = 0; i < m; i++) {
      char c = nextCharacter();
      //need to think of an idea for Q
      if(c == 'C'){
        int x = nextInt();
        int v = nextInt();

        thisSegM.update(x,v,1);
        thisSegG.update(x,v,1);
      }
      else if(c == 'M'){
        int l = nextInt();
        int r = nextInt();
        System.out.println(thisSegM.query(l, r, 1));
      }
      else if(c == 'G'){
        int l = nextInt();
        int r = nextInt();
        System.out.println(thisSegG.query(l, r, 1));
      }
      else{
        int l = nextInt();
        int r = nextInt();
        int result = thisSegG.query(l, r, 1);
        if(result == thisSegM.query(l,r,1)){
          System.out.println(thisSegM.queryQ(l,r,1,result));
        }
        else{
          System.out.println(0);
        }

      }
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

class segTreeGCD {
  gcdNode[] segTree;
  int[] initialVal;

  segTreeGCD(int[] v) {
    initialVal = new int[v.length];
    segTree = new gcdNode[v.length*4];

    for (int i = 0; i < v.length; i++) {
      initialVal[i] = v[i];
    }
    build(1, v.length, 1);
  }

  void build(int l, int r, int index) {
    segTree[index] = new gcdNode();
    segTree[index].l = l;
    segTree[index].r = r;

    if (l == r) {
      segTree[index].gcd = initialVal[l - 1];
      return;
    }

    int mid = (l + r) / 2;
    build(l, mid, index * 2);
    build(mid + 1, r, index * 2 + 1);
    segTree[index].gcd = gcd(segTree[index*2].gcd, segTree[index * 2 +1].gcd);

  }

  void update(int pos, int val, int index){
    if(segTree[index].l == pos && segTree[index].r == pos){
      segTree[index].gcd = val;
      return;
    }

    int mid = (segTree[index].l + segTree[index].r)/2;
    if(pos <= mid){
      update(pos, val, 2*index);
    }
    else{
      update(pos, val, 2*index +1);
    }
    segTree[index].gcd = gcd(segTree[index*2].gcd, segTree[index*2 + 1].gcd);
  }

  int query(int l, int r, int index){
    if(l == segTree[index].l && r == segTree[index].r){
      return segTree[index].gcd;
    }
    if(segTree[index].r == segTree[index].l){
      return segTree[index].gcd;
    }

    int mid = (segTree[index].l + segTree[index].r)/2;

    if(mid < l){
      return query(l, r, index * 2 + 1);
    }
    else if(r <= mid){
      return query(l, r, index * 2);
    }
    else{
      return gcd(query(l, mid, index * 2),query(mid + 1, r, index * 2 +1));
    }
  }


  int gcd(int a, int b){
    if(b == 0){
      return a;
    }
    return gcd(b, a%b);
  }


}

class segTreeMin {
  minNode[] segTree;
  minNumNode[] segTreeMinN;
  int[] initialVal;


  segTreeMin(int[] v) {
    initialVal = new int[v.length];
    segTree = new minNode[v.length*4];
    segTreeMinN = new minNumNode[v.length*4];

    for (int i = 0; i < initialVal.length; i++) {
      initialVal[i] = v[i];
    }

    build(1, v.length, 1);
    buildMinN(1,v.length,1);
  }

  void build(int left, int right, int index) {
    segTree[index] = new minNode();
    segTree[index].l = left;
    segTree[index].r = right;

    if (left == right) {
      segTree[index].minVal = initialVal[left - 1];
      return;
    }

    int mid = (left + right) / 2;

    build(left, mid, index * 2);
    build(mid + 1, right, index * 2 + 1);

    segTree[index].minVal = Math.min(segTree[index * 2].minVal, segTree[index * 2 + 1].minVal);
  }

  void buildMinN(int left, int right, int index){
    segTreeMinN[index] = new minNumNode();
    segTreeMinN[index].l = left;
    segTreeMinN[index].r = right;

    if(left == right){
      segTreeMinN[index].minValCount = 1;
      return;
    }

    int mid = (left + right)/2;
    buildMinN(left, mid, index * 2);
    buildMinN(mid + 1, right, index * 2 + 1);

    if(segTree[index * 2].minVal == segTree[index* 2 + 1].minVal){
      segTreeMinN[index].minValCount = segTreeMinN[index * 2].minValCount + segTreeMinN[index * 2 + 1].minValCount;
    }
    else if (segTree[index * 2].minVal > segTree[index* 2 + 1].minVal){
      segTreeMinN[index].minValCount = segTreeMinN[index * 2 + 1].minValCount;
    }
    else{
      segTreeMinN[index].minValCount = segTreeMinN[index * 2].minValCount;
    }
  }



  void update(int pos, int val, int index) {
    if (segTree[index].l == pos && segTree[index].r == pos) {
      segTree[index].minVal = val;
      return;
    }

    int mid = (segTree[index].l + segTree[index].r) / 2;
    if (pos <= mid) {
      update(pos, val, index * 2);
    } else {
      update(pos, val, index * 2 + 1);
    }

    segTree[index].minVal = Math.min(segTree[index * 2].minVal, segTree[index * 2 + 1].minVal);

    if(segTree[index * 2].minVal == segTree[index* 2 + 1].minVal){
      segTreeMinN[index].minValCount = segTreeMinN[index * 2].minValCount + segTreeMinN[index * 2 + 1].minValCount;
    }
    else if (segTree[index * 2].minVal > segTree[index* 2 + 1].minVal){
      segTreeMinN[index].minValCount = segTreeMinN[index * 2 + 1].minValCount;
    }
    else{
      segTreeMinN[index].minValCount = segTreeMinN[index * 2].minValCount;
    }

  }

  int query(int left, int right, int index) {
    if (segTree[index].l == left && segTree[index].r == right) {
      return segTree[index].minVal;
    }
    if(segTree[index].r == segTree[index].l){
      return segTree[index].minVal;
    }

    int mid = (segTree[index].l + segTree[index].r) / 2;
    if (right <= mid) {
      return query(left, right, index * 2);
    } else if (mid < left) {
      return query(left, right, index * 2 + 1);
    } else {
      return Math.min(query(mid + 1, right, index * 2 + 1), query(left, mid, index * 2));
    }

  }



  int queryQ(int left, int right, int index, int gcd){
    if (segTreeMinN[index].l == left && segTreeMinN[index].r == right) {
      if(segTree[index].minVal == gcd) {
        return segTreeMinN[index].minValCount;
      }
      else {
        return 0;
      }
    }
    if(segTreeMinN[index].l == segTreeMinN[index].r){
      if(segTree[index].minVal == gcd) {
        return segTreeMinN[index].minValCount;
      }
      else{
        return 0;
      }
    }

    int mid = (segTree[index].l + segTree[index].r) / 2;
    if (right <= mid) {
      return queryQ(left, right, index * 2,gcd);
    } else if (mid < left) {
      return queryQ(left, right, index * 2 + 1,gcd);
    } else {
      return queryQ(mid + 1, right, index * 2 + 1, gcd) + queryQ(left, mid, index * 2, gcd);
    }

  }
}

class minNode {
  int l;
  int r;
  int minVal;
}

class minNumNode{
  int l;
  int r;
  int minValCount;


}

class gcdNode {
  int l;
  int r;
  int gcd;
}