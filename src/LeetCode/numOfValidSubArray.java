package LeetCode;

import java.io.*;
import java.util.*;

public class numOfValidSubArray {

  public static void main(String[] args) throws IOException {
  }

  public int validSubarrays(int[] nums) {
    int dp[] = new int[nums.length];
    Stack<n> smallestGreater = new Stack<>();

    for (int i = nums.length - 1; i >= 0 ; i--) {
      n newN = new n(nums[i], i);
      int finalL = nums.length;

      while(! smallestGreater.empty()){
        n comp = smallestGreater.peek();
        if(comp.value >= newN.value){
          smallestGreater.pop();
        }
        else{
          finalL = comp.index;
          break;
        }
      }

      smallestGreater.push(newN);
      int ans = finalL - newN.index;
      if(i != nums.length - 1) {
        dp[i] = dp[i + 1] + ans;
      }
      else{
        dp[i] = ans;
      }
    }
    return dp[0];



  }

  class n{
    int value, index;
    n(int v, int i){
      value = v;
      index = i;
    }
  }

}
