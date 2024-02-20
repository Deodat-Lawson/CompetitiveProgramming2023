package LeetCode;

import java.io.*;
import java.util.*;

public class removeNthNodeFromEnd {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
  }

  class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      int size = 0;
      ListNode a = head;
      while(a != null){
        a = a.next;
        size++;
      }

      int rem = size - n - 1;
      if(rem < 0){
        return head.next;
      }
      ListNode ln = head;
      for (int i = 0; i < rem; i++) {
        ln = ln.next;
      }
      ln.next = ln.next.next;

      return head;

    }
  }


  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
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
