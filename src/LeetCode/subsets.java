package LeetCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class subsets {

  public List<List<Integer>> subsets(int[] nums) {
    ArrayList<List<Integer>> total = new ArrayList<>();
    total.add(new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      ArrayList<ArrayList<Integer>> newA = new ArrayList<>();
      for (List<Integer> a: total
           ) {
        ArrayList<Integer> thisN = new ArrayList<>();
        thisN.addAll(a);
        thisN.add(nums[i]);
        newA.add(thisN);
      }
      total.addAll(newA);
    }
    return total;
  }
}
