package LeetCode;

import java.io.*;
import java.util.*;

public class threeSum {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {

  }
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    HashSet<List<Integer>> ans = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int elementOne = nums[i];
        int elementTwo = nums[j];
        int left = j + 1;
        int right = nums.length - 1;
        while(left <= right){
          int mid = left + (right - left)/2;
          if(nums[mid] + elementTwo + elementOne == 0){
            ArrayList<Integer> a = new ArrayList<>();
            a.add(elementOne);
            a.add(elementTwo);
            a.add(nums[mid]);
            ans.add(a);
            break;
          }
          else if(nums[mid] + elementTwo + elementOne > 0){
            right = mid - 1;
          }
          else{
            left = mid + 1;
          }
        }

      }
    }
    ArrayList<List<Integer>> ansW = new ArrayList<>();
    for (List<Integer> thisA: ans
         ) {
      ansW.add(thisA);
    }
    return ansW;

  }




}
