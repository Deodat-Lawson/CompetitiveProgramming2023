package LeetCode;
import java.util.*;
import java.io.*;

public class Pattern132 {

  public boolean find132pattern(int[] nums) {
    Stack<Integer> largestClosest = new Stack<>();
    ArrayList<Integer> smallestFurthest = new ArrayList<>();


    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];
      int hasL = -1;
      int hasS = -1;

      while(!largestClosest.isEmpty()){
       int next = largestClosest.peek();
       if(nums[next] > val){
         hasL = next;
         break;
       }
       else{
         largestClosest.pop();
       }
      }
      largestClosest.add(i);

      int left = 0;
      int right = smallestFurthest.size() -1;
      while(left <= right){
        int mid = (left + right)/2;
        int indexMid = smallestFurthest.get(mid);
        int midVal = nums[indexMid];
        if(midVal < val){
          hasS = indexMid;
          right = mid -1;
        }
        else{
          left = mid + 1;
        }
      }

      if( smallestFurthest.isEmpty() || nums[i] < nums[smallestFurthest.get(smallestFurthest.size() - 1)]){
        smallestFurthest.add(i);
      }


      if(hasS != -1 && hasL != -1 && hasS < hasL) {
        return true;
      }

    }
    return false;

  }

}
