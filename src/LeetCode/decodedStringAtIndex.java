package LeetCode;

import java.io.*;
import java.util.*;

public class decodedStringAtIndex {
  

  public static void main(String[] args) throws IOException {
    System.out.println(decodeAtIndex("a23",6));
  }

  public static String decodeAtIndex(String s, int k) {
    if(k == 1){
      return "" + s.charAt(0);
    }
    k--;
    ArrayList<Pair> allPairs = new ArrayList<>();
    int index = 0;
    String currString = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(Character.isAlphabetic(c)){
        currString += c;
      }
      else{
        int count = (int)(c - '0');
        if(allPairs.isEmpty()){
          allPairs.add(new Pair(currString, count, 0));
        }
        else{
          Pair prevP = allPairs.get(index - 1);
          allPairs.add(new Pair(currString, count, prevP.length));
        }
        currString = "";
        index++;
      }
    }
    if(!currString.isEmpty()){
      allPairs.add(new Pair(currString, 1, 0));
    }

    for (int i = 0; i < allPairs.size(); i++) {
      if(allPairs.get(i).length > k){
        return "" + getCharacterAtIndex(allPairs, i, k);
      }
    }
    return "error";



  }


  public static char getCharacterAtIndex(ArrayList<Pair> allP, int pairIndex, int k){
    Pair currentP = allP.get(pairIndex);
    long sizeOfSection = currentP.length/currentP.count;
    k %= sizeOfSection;
    if(pairIndex == 0){
      return currentP.addition.charAt(k);
    }

    //the string have count symmetric sections, we first find the size of each section by Pair.length/Pair.count
    //for each section, from 0 - prevLength is stored in the previousPair, from prevLength to length is in current
    //pair

    Pair previousP = allP.get(pairIndex - 1);
    if(k >= previousP.length){
      long remainingIndex = k - previousP.length;
      return currentP.addition.charAt((int) remainingIndex);
    }
    return getCharacterAtIndex(allP, pairIndex - 1, k);
  }
  
  static class Pair{
    String addition;
    long length;
    int count;
    Pair(String addition, int count, long prevLength){
      this.addition = addition;
      this.count = count;
      length = (prevLength + addition.length()) * count;
    }
  }
  
}
