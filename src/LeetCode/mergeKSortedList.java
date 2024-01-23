package LeetCode;

import java.io.*;
import java.util.*;

public class mergeKSortedList {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {

  }

  class ListNode {
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

  class NodeWithIndex implements Comparable<NodeWithIndex>{
    ListNode l;
    int index;
    NodeWithIndex(ListNode l, int i){
      this.l = l;
      index = i;
    }

    public int compareTo(NodeWithIndex o1){
      return Integer.compare(l.val, o1.l.val);
    }

  }



  public ListNode mergeKLists(ListNode[] lists) {
    ListNode[] listNodes = lists;
    PriorityQueue<NodeWithIndex> allN = new PriorityQueue<>();
    for (int i = 0; i < lists.length; i++) {
      allN.add(new NodeWithIndex(listNodes[i], i));
    }

    ListNode head = null;
    ListNode prev = null;


    while(!allN.isEmpty()){
      NodeWithIndex current = allN.poll();

      ListNode curr = current.l;
      int index = current.index;

      if(head == null){
        head = curr;
        prev = curr;
      }
      else{
        prev.next = curr;
        prev = prev.next;
      }

      listNodes[index] = listNodes[index].next;
      if(listNodes[index] != null){
        allN.add(new NodeWithIndex(listNodes[index], index));
      }
    }

    return head;

  }



}
