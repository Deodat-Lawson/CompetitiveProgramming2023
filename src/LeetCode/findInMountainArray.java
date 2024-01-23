package LeetCode;
import javax.swing.plaf.ProgressBarUI;
public class findInMountainArray {
  interface MountainArray {
    public default int get(int index) {
      return index;
    }
    public default int length(){
      return 0;
    }

  }


  public int findInMountainArray(int target, MountainArray mountainArr) {


    int highestIndex = -1;

    //bsearch for highest point
    int left = 1;
    int right = mountainArr.length() - 2;
    while(left <= right){
      int mid = (left + right)/2;
      int val = mountainArr.get(mid);
      int prev = mountainArr.get(mid - 1);
      int next = mountainArr.get(mid + 1);

      if(prev < val && next < val){
        highestIndex = mid;
        break;
      }
      else if(prev < val){
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }

    int ans = -1;
    left = 0;
    right = highestIndex;
    while(left <= right){
      int mid = (left + right)/2;
      int val = mountainArr.get(mid);
      if(val == target){
        return mid;
      }
      else if(val < target){
        left = mid + 1;
      }
      else{
        right = mid - 1;
      }
    }

    left = highestIndex;
    right = mountainArr.length() - 1;
    while(left <= right){
      int mid = (left + right)/2;
      int val = mountainArr.get(mid);
      if(val == target){
        return mid;
      }
      else if(val > target){
        left = mid + 1;
      }
      else{
        right = mid - 1;
      }
    }

    return -1;

  }


}
