package LeetCode;

import java.io.*;
import java.util.*;

public class reverseLinkedList {
  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  class Solution {

    public ListNode reverseList(ListNode head) {
      ListNode newHead = null;
      while(head != null){
        ListNode current = new ListNode(head.val);
        current.next = newHead;
        newHead = current;
        head = head.next;
      }
      return newHead;
    }

  }


 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
