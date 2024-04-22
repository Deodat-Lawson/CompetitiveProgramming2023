package LeetCode;
import java.util.ArrayList;
import java.util.List;
public class reorderList {

  public static void main(String[] args) {
    Solution sol = new Solution();
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    sol.reorderList(n1);
  }
  static class Solution {
    public void reorderList(ListNode head) {
      if(head == null){
        return;
      }

      ArrayList<ListNode> nodes = new ArrayList<>();
      ListNode n = head;
      while (n != null) {
        nodes.add(n);
        n = n.next;
      }

      ListNode current = head;
      int count = 1;

      for (int i = 0; i <= nodes.size() / 2; i++) { //0,3,1,2
        int currVal = i;
        int currOpp = nodes.size() - 1 - i;

        if (!current.equals(nodes.get(currVal))) {
          current.next = nodes.get(currVal);
          current = current.next;
          count++;
        }
        if(count == nodes.size()){
          break;
        }
        if (!current.equals(nodes.get(currOpp))) {
          current.next = nodes.get(currOpp);
          current = current.next;
          count++;
        }
        if(count == nodes.size()){
          break;
        }

      }
      current.next = null;

    }
  }



  static class ListNode {
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
