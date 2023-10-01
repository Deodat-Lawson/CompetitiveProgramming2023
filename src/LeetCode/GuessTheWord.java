//package LeetCode;
//
//import java.util.*;
//
//public class GuessTheWord  {
//    //implementaion idea fails due to Strings with same letters
//    public void findSecretWord(String[] words, Master master) {
//        ArrayList<int[]> wordsGuessList = new ArrayList<>();
//        int[][] wordCountTracker = new int[7][26];
//        for (int i = 0; i < words.length; i++) {
//            String a = words[i];
//            int[] charCountArr = new int[26];
//            for (int j = 0; j < a.length(); j++) {
//                int aC = a.charAt(j);
//                charCountArr[aC - 'a']++;
//            }
//            wordsGuessList.add(charCountArr);
//        }
//
//        while(wordsGuessList.size() > 1){
//            //update wordCountTracker
//            wordCountTracker = new int[7][26];
//            for (int i = 0; i < wordsGuessList.size(); i++) {
//                int[] currCharCount = wordsGuessList.get(i);
//                for (int j = 0; j < 26; j++) {
//                    int count = currCharCount[j];
//                    wordCountTracker[count][j]++;
//                }
//            }
//            int min = Integer.MAX_VALUE;
//            int seperationVal = -1;
//            for (int i = 0; i < 26; i++) {
//                int max = 0;
//                for (int j = 0; j < 7; j++) {
//                    max = Math.max(wordCountTracker[j][i],max);
//                }
//                if(max < min){
//                    seperationVal = i;
//                    min = max;
//                }
//            }
//
//            String input = "";
//            for (int i = 0; i < 6; i++) {
//                input += (char)(seperationVal + 'a');
//            }
//            int result = Master.guess(input);
//
//            for (int i = 0; i < wordsGuessList.size(); i++) {
//                if(wordsGuessList.get(i)[seperationVal] != result){
//                    wordsGuessList.remove(i);
//                    i--;
//                }
//            }
//
//        }
//
//        Master.guess(wordsGuessList.get(0))
//
//        //guess word
//    }
//}
