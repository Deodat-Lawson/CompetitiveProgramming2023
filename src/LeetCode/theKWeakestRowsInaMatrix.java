package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class theKWeakestRowsInaMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<R> allR = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int rCount = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rCount++;
                }
            }
            allR.add(new R(rCount, i));
        }

        Collections.sort(allR);
        int[] output = new int[k];
        for (int i =0; i < k; i++) {
            output[i]= allR.get(i).row;
        }
        return output;
    }

    class R implements Comparable<R> {
        int sold;
        int row;

        R(int s, int r) {
            sold = s;
            row = r;
        }

        @Override
        public int compareTo(R o1) {
            if (sold < o1.sold) {
                return -1;
            } else if (o1.sold < sold) {
                return 1;
            } else {
                return Integer.compare(row, o1.row);
            }
        }


    }
}
