package LeetCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class longestIncreasingSubsequence {


  //1,6,2,3,4,5
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length + 1];
    ArrayList<Pair> arr = new ArrayList<>();


    dp[0] = 0;
    arr.add(new Pair(Integer.MIN_VALUE, 0));

    /*
    current arraylist: (-inf,  0), (1, 1), (2, 2), (3, 3)



     */

    //add a variable at the start, with length 0

    for (int i = 0; i < nums.length; i++) {
      //we find a number that has the longest length smaller than our current number

      int maxLength = 0;
      int left = 0;
      int right = arr.size() - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        Pair midPair = arr.get(mid);
        if (midPair.val < nums[i]) {
          maxLength = Math.max(midPair.length + 1, maxLength);
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      //maxL = 2

      boolean setPair = false;
      left = 0;
      right = arr.size() - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        Pair midPair = arr.get(mid);
        if (midPair.length < maxLength) {
          left = mid + 1;
        } else if(midPair.length == maxLength) {
          Pair equalP = arr.get(mid);
          equalP.val = Math.min(equalP.val, nums[i]);
          arr.set(mid, equalP);
          setPair = true;
          break;
        }
        else{
          right = mid - 1;
        }
      }

      if(!setPair){
        arr.add(new Pair(nums[i], maxLength));
      }
    }

    return arr.get(arr.size() - 1).length;

  }

  public class Pair implements Comparable<Pair> {
    int val;
    int length;
    Pair(int val, int length) {
      this.val = val;
      this.length = length;
    }

    @Override
    public int compareTo(Pair p) {
      return Integer.compare(this.val, p.val);
    }
  }

}
