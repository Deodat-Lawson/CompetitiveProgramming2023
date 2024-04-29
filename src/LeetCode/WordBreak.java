package LeetCode;

import java.util.*;

public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    HashSet<String> allWord = new HashSet<>();
    for (int i = 0; i < wordDict.size(); i++) {
      allWord.add(wordDict.get(i));
    }

    for (int i = 1; i < s.length() + 1; i++) {

      for (int j = 0; j < i; j++) {
        if(dp[j]){
          String subString = s.substring(j, i);
          if(allWord.contains(subString)){
            dp[i] = true;
            break;
          }
          dp[i] = false;
        }
      }
    }

    return dp[dp.length - 1];
  }
}
