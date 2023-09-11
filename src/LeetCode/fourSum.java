package LeetCode;

import java.io.*;
import java.util.*;

public class fourSum {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    HashSet<List<Integer>> ans = new HashSet<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          for (int l = k + 1; l < nums.length; l++) {

            if(nums[i] + nums[j] + nums[k] + nums[l] == target){
              List<Integer> a = new ArrayList<>();
              a.add(nums[i]);
              a.add(nums[j]);
              a.add(nums[k]);
              a.add(nums[l]);
              ans.add(a);
            }
          }
        }
      }
    }
    ArrayList<List<Integer>> answ = new ArrayList<>();
    for (List<Integer> thisA: ans
         ) {
      answ.add(thisA);
    }
    return answ;
  }

}
