package LeetCode;

import java.io.*;
import java.util.*;

public class validNumber {


  public static void main(String[] args) throws IOException {

  }

  public boolean isNumber(String s) {
    //first check if e exists
    boolean containsE = false;
    int eIndex = -1;
    for (int i = 0; i < s.length(); i++) {
      char currC = s.charAt(i);
      if(Character.isAlphabetic(currC)){
       if(containsE){
         return false;
       }
       else{
         if(currC == 'e' || currC == 'E') {
           containsE = true;
           eIndex = i;
         }
         else{
           return false;
         }
       }
      }
    }

    if(containsE){
      boolean left = checkDecimal(s.substring(0, eIndex)) || checkInt(s.substring(0, eIndex));
      boolean right = checkInt(s.substring(eIndex + 1));
      return left && right;
    }
    else{
      return checkDecimal(s.substring(0, eIndex)) || checkInt(s.substring(0, eIndex));
    }


  }

  public boolean checkDecimal(String s){
    //check first sign
    if(s.isEmpty()){
      return false;
    }
    char firstC = s.charAt(0);
    boolean hasDot = false;

    if(!(Character.isDigit(firstC) || !Character.isDigit(firstC) && (firstC == '+' || firstC == '-' || firstC == '.'))){
      return false;
    }
    if(firstC == '.'){
      hasDot = true;
    }

    for (int i = 1; i < s.length(); i++) {
      char currC = s.charAt(i);
      if(!Character.isDigit(currC)){
        if(currC == '.'){
          if(hasDot){
            return false;
          }
          else{
            hasDot = true;
          }
        }
        else{
          return false;
        }
      }
    }
    return true;


  }

  public boolean checkInt(String s){
    if(s.isEmpty()){
      return false;
    }
    char firstC = s.charAt(0);
    if(!(Character.isDigit(firstC) || !Character.isDigit(firstC) && (firstC == '+' || firstC == '-'))){
      return false;
    }
    for (int i = 1; i < s.length(); i++) {
      char currC = s.charAt(i);
      if(!Character.isDigit(currC)){
        return false;
      }
    }
    return true;
  }


}
