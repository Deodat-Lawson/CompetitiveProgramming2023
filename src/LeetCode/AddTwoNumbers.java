package LeetCode;
import java.util.ArrayList;
import java.util.List;
public class AddTwoNumbers {

  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode head = null;
      ListNode current = head;
      boolean extraOne = false;

      while(l1 != null && l2 != null){
        int val = l1.val + l2.val;
        if(extraOne){
          val += 1;
        }
        if(val >= 10){
          extraOne = true;
          val -= 10;
        }
        else{
          extraOne = false;
        }

        if(head == null){
          head = new ListNode(val);
          current = head;
        }
        else{
          current.next = new ListNode(val);
          current = current.next;
        }
        l1 = l1.next;
        l2 = l2.next;
      }

      while(l1 != null){
        int val = l1.val;
        if(extraOne){
          val += 1;
        }
        if(val >= 10){
          extraOne = true;
          val -= 10;
        }
        else{
          extraOne = false;
        }

        if(head == null){
          head = new ListNode(val);
          current = head;
        }
        else{
          current.next = new ListNode(val);
          current = current.next;
        }
        l1 = l1.next;
      }

      while(l2 != null){
        int val = l2.val;
        if(extraOne){
          val += 1;
        }
        if(val >= 10){
          extraOne = true;
          val -= 10;
        }
        else{
          extraOne = false;
        }

        if(head == null){
          head = new ListNode(val);
          current = head;
        }
        else{
          current.next = new ListNode(val);
          current = current.next;
        }
        l2 = l2.next;
      }

      if(extraOne){
        current.next = new ListNode(1);
      }

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
}