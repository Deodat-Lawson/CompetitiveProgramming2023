package DMOJ;
import java.util.*;

public class CCC2010S3 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> allHouse = new ArrayList<>();
    static int numOfFire;

    public static void main(String[] args) {
        //b search + greedy but with exception that 1000000 is also 0;
        int numOfHouses = sc.nextInt();


        for (int i = 0; i < numOfHouses; i++) {
            allHouse.add(sc.nextInt());
        }
        numOfFire = sc.nextInt();
        Collections.sort(allHouse);

        int left = 0;
        int right = 1000000;
        int answer = 1000000;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (check(middle)) {
                answer = Math.min(middle, answer);
                right = middle - 1;
            } else {
                left = middle + 1;

            }

        }

        System.out.println(answer);


    }


    static boolean check(int dist) {
        //not sure try both ways? we can afford to start from all the houses 1000^2

        for (int i = 0; i < allHouse.size(); i++) {
            if (checkHouse(i, dist)) {
                return true;
            }
        }
        return false;


    }


    static boolean checkHouse(int start, int dist) {

        int count = 0;
        int distOne = 0;
        boolean a = false;
        int distTwo = start;

        for (int i = start; i < allHouse.size(); i++) {
            if (i == start) {
                distTwo = allHouse.get(i) + (dist * 2);
                count++;
            }
            else if (allHouse.get(i) > distTwo) {
                distTwo = allHouse.get(i) + (dist * 2);
                count++;
            }
            if (count > numOfFire) {
                return false;
            }

            if (distTwo >= 1000000) {
                distOne = distTwo - 1000000;
                a = true;
                break;
            }
        }

        for (int i = 0; i < start; i++) {
            if(!a){
                if (i == 0) {
                    distOne = allHouse.get(i) + (dist * 2);
                    count++;
                    a = true;
                }
            }
            else if (allHouse.get(i) > distOne) {
                distOne = allHouse.get(i) + (dist * 2);
                count++;
            }
            if (count > numOfFire) {
                return false;
            }

        }

        return true;

    }


}