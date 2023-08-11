package LeetCode;

import java.io.*;
import java.util.*;

public class findMedianSortedArrays {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int[] a = {1,2};
    int[] b = {3,4};
    System.out.println(findMedianSortedArrays(a,b));
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

      if((nums1.length + nums2.length)%2 == 1){
        //first assume one of the median is in num1
        int left = 0;
        int right = nums1.length - 1;
        int mid;
        while (left <= right){
          mid = (left + right)/2;
          //how many elements are greater than mid in nums[1]
          int[] n1Res = lessEqualGreater(nums1[mid],nums1);
          int[] n2Res = lessEqualGreater(nums1[mid],nums2);

          int less = n1Res[0] + n2Res[0];
          int eq = n1Res[1] + n2Res[1];
          int great = n1Res[2] + n2Res[2];

          if(less + eq >= great && great + eq >= less){
            return (double)nums1[mid];
          }
          else if (less > great){
            right = mid - 1;
          }
          else{
            left = mid + 1;
          }
        }

        left = 0;
        right = nums2.length - 1;
        while (left <= right){
          mid = (left + right)/2;
          //how many elements are greater than mid in nums[1]
          int[] n1Res = lessEqualGreater(nums2[mid],nums1);
          int[] n2Res = lessEqualGreater(nums2[mid],nums2);

          int less = n1Res[0] + n2Res[0];
          int eq = n1Res[1] + n2Res[1];
          int great = n1Res[2] + n2Res[2];

          if(less + eq >= great && great + eq >= less){
            return (double)nums2[mid];
          }
          else if (less > great){
            right = mid - 1;
          }
          else{
            left = mid + 1;
          }
        }

        return -1;

      }
      else{
        int ele1 = 0, ele2 = 0;


        int left = 0;
        int right = nums1.length - 1;
        int mid;
        while (left <= right){
          mid = (left + right)/2;
          //how many elements are greater than mid in nums[1]
          int[] n1Res = lessEqualGreater(nums1[mid],nums1);
          int[] n2Res = lessEqualGreater(nums1[mid],nums2);

          int less = n1Res[0] + n2Res[0];
          int eq = n1Res[1] + n2Res[1];
          int great = n1Res[2] + n2Res[2] - 1;

          if(less + eq >= great && great + eq >= less){
            ele1 = nums1[mid];
            break;
          }
          else if (less > great){
            right = mid - 1;
          }
          else{
            left = mid + 1;
          }
        }

        left = 0;
        right = nums2.length - 1;
        while (left <= right){
          mid = (left + right)/2;
          //how many elements are greater than mid in nums[1]
          int[] n1Res = lessEqualGreater(nums2[mid],nums1);
          int[] n2Res = lessEqualGreater(nums2[mid],nums2);

          int less = n1Res[0] + n2Res[0];
          int eq = n1Res[1] + n2Res[1];
          int great = n1Res[2] + n2Res[2] - 1;

          if(less + eq >= great && great + eq >= less){
            ele1 = nums2[mid];
            break;
          }
          else if (less > great){
            right = mid - 1;
          }
          else{
            left = mid + 1;
          }
        }


        left = 0;
        right = nums1.length - 1;
        while (left <= right){
          mid = (left + right)/2;
          //how many elements are greater than mid in nums[1]
          int[] n1Res = lessEqualGreater(nums1[mid],nums1);
          int[] n2Res = lessEqualGreater(nums1[mid],nums2);

          int less = n1Res[0] + n2Res[0] - 1;
          int eq = n1Res[1] + n2Res[1];
          int great = n1Res[2] + n2Res[2];

          if(less + eq >= great && great + eq >= less){
            ele2 = nums1[mid];
            break;
          }
          else if (less > great){
            right = mid - 1;
          }
          else{
            left = mid + 1;
          }
        }

        left = 0;
        right = nums2.length - 1;
        while (left <= right){
          mid = (left + right)/2;
          //how many elements are greater than mid in nums[1]
          int[] n1Res = lessEqualGreater(nums2[mid],nums1);
          int[] n2Res = lessEqualGreater(nums2[mid],nums2);

          int less = n1Res[0] + n2Res[0] - 1;
          int eq = n1Res[1] + n2Res[1];
          int great = n1Res[2] + n2Res[2];

          if(less + eq >= great && great + eq >= less){
            ele2 = nums2[mid];
            break;
          }
          else if (less > great){
            right = mid - 1;
          }
          else{
            left = mid + 1;
          }
        }

        return ((double) ele1 + (double) ele2)/2;


      }
  }

  static int[] lessEqualGreater(int val, int[] nums){
    int left = 0;
    int right = nums.length - 1;
    int mid;
    int[] ans = new int[3];
    //0 for numsOfSmallerThan, 1 for numsOfEqualTo, 2 for numsOfGreaterThan

    int smallerThan = 0;
    while (left <= right){
      mid = (left + right)/2;
      if(nums[mid] < val){
        smallerThan = Math.max(smallerThan, mid + 1);
        left = mid + 1;
      }
      else{
        right = mid - 1;
      }
    }

    left = 0;
    right = nums.length - 1;
    int greaterThan = 0;
    while (left <= right){
      mid = (left + right)/2;
      if(nums[mid] > val){
        greaterThan = Math.max(greaterThan, nums.length - mid);
        right = mid - 1;
      }
      else{
        left = mid + 1;
      }
    }

    ans[0] = smallerThan;
    ans[1] = nums.length - smallerThan - greaterThan;
    ans[2] = greaterThan;

    return ans;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(f.readLine().trim());
    }
    return tok.nextToken();
  }

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char nextCharacter() throws IOException {
    return next().charAt(0);
  }

  static String nextLine() throws IOException {
    return f.readLine().trim();
  }

}
