package LeetCode;
public class houseRobber2 {

  /*
  spread and process two arrays
  first element to 2nd last element
  second element to last element

  see which result is greater




   */
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[1], nums[0]);
    }

    //length >= 3

    int[] dpFirstToSecondLast = new int[nums.length - 1];
    int[] dpSecondToLast = new int[nums.length - 1];

    dpFirstToSecondLast[0] = nums[0];
    dpFirstToSecondLast[1] = nums[1];

    int[] maxFirstToSecondLast = new int[nums.length - 1];
    maxFirstToSecondLast[0] = dpFirstToSecondLast[0];
    maxFirstToSecondLast[1] = Math.max(dpFirstToSecondLast[0], dpFirstToSecondLast[1]);
    for (int i = 2; i < dpFirstToSecondLast.length; i++) {
      dpFirstToSecondLast[i] = maxFirstToSecondLast[i - 2] + nums[i];
      maxFirstToSecondLast[i] = Math.max(dpFirstToSecondLast[i], maxFirstToSecondLast[i - 1]);
    }

    dpSecondToLast[0] = nums[1];
    dpSecondToLast[1] = nums[2];

    int[] maxSecondToLast = new int[nums.length - 1];
    maxSecondToLast[0] = dpSecondToLast[0];
    maxSecondToLast[1] = Math.max(dpSecondToLast[0], dpSecondToLast[1]);
    for (int i = 2; i < dpSecondToLast.length; i++) {
      dpSecondToLast[i] = maxSecondToLast[i - 2] + nums[i + 1];
      maxSecondToLast[i] = Math.max(dpSecondToLast[i], maxSecondToLast[i - 1]);
    }

    return Math.max(maxSecondToLast[maxSecondToLast.length - 1], maxFirstToSecondLast[maxFirstToSecondLast.length - 1]);


  }
}
