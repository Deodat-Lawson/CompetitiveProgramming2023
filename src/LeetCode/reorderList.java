package LeetCode;
import java.util.ArrayList;
import java.util.List;
public class reorderList {
  class Solution {
    public void reorderList(ListNode head) {
      ArrayList<Integer> nodes = new ArrayList<>();
      while(head != null){
        nodes.add(head.val);
        head = head.next;
      }
      ListNode newHead = null;
      ListNode current = null;

      for (int i = 0; i < nodes.size()/2; i++) {
        int currVal = i;
        int currOpp = nodes.size() - 1 - i;

        if(newHead == null){
          newHead = new ListNode(nodes.get(currVal));
          current = newHead;
        }
        else{
          current.next = new ListNode(nodes.get(currVal));
          current = current.next;
        }

        if(currVal != currOpp){
          current.next = new ListNode(nodes.get(currOpp));
          current = current.next;
        }

      }

      head = newHead;

      while(head != null){
        System.out.println(head.val);
        head = head.next;
      }


    }

    public void swap(ListNode a, ListNode b){
      a.next;


    }
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
}
