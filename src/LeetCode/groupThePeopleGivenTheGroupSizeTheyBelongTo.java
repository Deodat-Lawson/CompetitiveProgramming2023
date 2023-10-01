package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class groupThePeopleGivenTheGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int max = groupSizes.length + 1;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer>[] allL = new ArrayList[max];
        for (int i = 0; i < allL.length; i++) {
            allL[i] = new ArrayList<>();
        }

        for (int i = 0; i < groupSizes.length; i++) {
            allL[groupSizes[i]].add(i);
        }

        for (int i = 0; i < allL.length; i++) {
            int s = i;
            ArrayList<Integer> a = allL[i];
            ArrayList<Integer> current = new ArrayList<>();

            for (int j = 0; j < a.size(); j++) {
                current.add(a.get(j));
                if(current.size() == s){
                    ans.add(current);
                    current = new ArrayList<>();
                }
            }

        }

        return ans;


    }


}
