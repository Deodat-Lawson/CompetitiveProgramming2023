package LeetCode;

public class CountAllValidPickupAndDeliveryOptions {

    public int countOrders(int n) {
        long[] allNums = new long[501];
        int[] spaceCount = new int[501];
        for (int i = 0; i < spaceCount.length; i++) {
            spaceCount[i] = i * 2 + 1;
        }

        allNums[1] = 1;
        for (int i = 2; i < allNums.length; i++) {
             allNums[i] = (long)( allNums[i-1] * (spaceCount[i - 1] * (spaceCount[i - 1] + 1))/2) % (long)(1e9 + 7);
        }
        return (int) allNums[n];
    }
}
