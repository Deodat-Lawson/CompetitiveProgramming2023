package LeetCode;

import java.io.*;
import java.util.*;

public class copyListWithRandomPointer {
  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }


  public static void main(String[] args) {
    Node n = new Node(7);
    Node b = new Node(8);
    n.random = null;
    n.next = b;
    b.random = n;
    b.next = null;


    Solution sol = new Solution();
    sol.copyRandomList(n);
  }
  static class Solution {
    public Node copyRandomList(Node head) {
      if(head == null){
        return null;
      }
      ArrayList<Node> originalList = new ArrayList<>();
      ArrayList<Node> newList = new ArrayList<>();
      Node n = head;
      while (n != null) {
        originalList.add(n);
        newList.add(new Node(n.val));
        n = n.next;
      }

      for (int i = 0; i < originalList.size(); i++) {
        Node ogListN = originalList.get(i);
        Node newListN = newList.get(i);

        Node ogListNNext = ogListN.next;
        Node ogListNRand = ogListN.random;

        int nextInd = -1;
        int randInd = -1;
        for (int j = 0; j < originalList.size(); j++) {
          if(originalList.get(j).equals(ogListNNext)){
            nextInd = j;
          }
          if(originalList.get(j).equals(ogListNRand)){
            randInd = j;
          }
        }

        if(randInd != -1) {
          newListN.random = newList.get(randInd);
        }
        if(nextInd != -1) {
          newListN.next = newList.get(nextInd);
        }

        newList.set(i, newListN);
      }
      return newList.get(0);
    }
  }
}
