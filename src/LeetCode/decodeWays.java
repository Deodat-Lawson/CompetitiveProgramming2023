//package LeetCode;
//public class decodeWays {
//
//  public int numDecodings(String s) {
//    int[][] dpTable = new int[s.length()][s.length()];
//    for (int i = 0; i < s.length(); i++) {
//      for (int j = 0; j + i < s.length(); j++) {
//        int start = i;
//        int end = i + j;
//
//        if(start == end){
//          if(!s.substring(start, start+1).equals("0")){
//            dpTable[start][end] = 1;
//          }
//          else{
//            dpTable[start][end] = 0;
//          }
//        }
//
//        if(i == 1){
//          String startChar = s.substring(start, start + 1);
//          String endChar = s.substring(end, end + 1);
//          if(startChar.equals("0")){
//
//          }
//        }
//
//      }
//    }
//  }
//}
