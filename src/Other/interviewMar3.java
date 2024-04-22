package Other;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
public class interviewMar3 {
  /**
   * - a set of cards
   *  - 3 or more cards
   *  - all the cards must have the same rank or suit + consective ranks
   *
   */

  public static void main(String[] args) {
    //testcases
    String[] arr = {"AC", "AD", "AS"}; //valid
    String[] arr2 = {"5C", "5D", "5H", "5S"}; //valid
    String[] arr3 = {"2C", "3C", "4H"}; //Invalid
    String[] arr4 = {"2C", "3C", "5C"}; //Invalid
    String[] arr5 = {}; //Invalid
  }

  public boolean checkValid(String[] arr){
    //O(1)
    if(arr.length < 3){
      return false;
    }

    //special case where there are three characters and the first two are 10
    //since the only possibility for this to happen is where 10 is the rank. All the length must be 3


    //O(N)
    //flag is false when all the cards do not have the same rank
    boolean flag = true;
    if(arr[0].length() == 3){
      for (int i = 0; i < arr.length; i++) {
        if(arr[i].length() != 3){
          flag = false;
          break;
        }
      }
    }
    else{
      char currRank = arr[0].charAt(0);
      for (int i = 0; i < arr.length; i++) {
        if(arr[i].charAt(0) != currRank){
          flag = false;
          break;
        }
      }
    }

    //if all the cards are the same rank, we return true
    //O(1)
    if(flag){
      return true;
    }

    //O(N)
    ArrayList<Integer> allRanks = new ArrayList<>();
    //check for same suit and convert rank to numbers
    char currSuit = arr[0].charAt(arr[0].length() - 1);
    for (int i = 0; i < arr.length; i++) {
      if(arr[i].length() == 3){
        allRanks.add(Integer.parseInt(arr[i].substring(0,2)));
      }
      else{
        String thisCharacter = arr[i].substring(0,1);
        if(thisCharacter.equals("A")){
          allRanks.add(1);
        }
        else if(thisCharacter.equals("J")){
          allRanks.add(11);
        }
        else if(thisCharacter.equals("Q")){
          allRanks.add(12);
        }
        else if(thisCharacter.equals("K")){
          allRanks.add(13);
        }
        else{
          allRanks.add(Integer.parseInt(thisCharacter));
        }
      }
      if(arr[i].charAt(arr[i].length() - 1) != currSuit){
        return false;
      }
    }


    //O(N logN)
    Collections.sort(allRanks); //2,3,5
    //O(N)
    for (int i = 0; i < allRanks.size() - 1; i++) {
      if(allRanks.get(i) + 1 != allRanks.get(i + 1)){
        return false;
      }
    }
    return true;

  }
  //O(NlogN)

}
