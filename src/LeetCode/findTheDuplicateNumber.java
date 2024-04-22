package LeetCode;
public class findTheDuplicateNumber {

  class Solution {
    public int findDuplicate(int[] nums) {
      long sum = 0;
      long numsSum = 0;
      for (int i = 0; i < nums.length; i++) {
        numsSum += i;
        sum += nums[i];
      }
      return (int) (sum - numsSum);
    }
  }
}
