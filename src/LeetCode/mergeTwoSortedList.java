package LeetCode;
public class mergeTwoSortedList {

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode() {}
   * ListNode(int val) { this.val = val; }
   * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode new1 = null;
      ListNode current = null;
      while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
          if (new1 == null) {
            new1 = new ListNode(list1.val);
            current = new1;
          } else {
            current.next = new ListNode(list1.val);
            current = current.next;
          }
          list1 = list1.next;
        } else {
          if (new1 == null) {
            new1 = new ListNode(list2.val);
            current = new1;
          } else {
            current.next = new ListNode(list2.val);
            current = current.next;
          }
          list2 = list2.next;
        }
      }

      while (list1 != null) {
        if (new1 == null) {
          new1 = new ListNode(list1.val);
          current = new1;
        } else {
          current.next = new ListNode(list1.val);
          current = current.next;
        }

        list1 = list1.next;
      }

      while (list2 != null) {
        if (new1 == null) {
          new1 = new ListNode(list2.val);
          current = new1;
        } else {
          current.next = new ListNode(list2.val);
          current = current.next;
        }
        list2 = list2.next;
      }

      return new1;

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
}
