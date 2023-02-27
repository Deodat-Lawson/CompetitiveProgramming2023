package Codeforces;
import java.util.*;

public class CF755C {

    static Scanner f = new Scanner(System.in);
    public static void main(String[] args){
        int numOfTestCase = f.nextInt();

        CF755CNode[] allNodes = new CF755CNode[numOfTestCase+1];

        int[] closeNeg = new int[numOfTestCase+1];

        for(int i = 1; i <= numOfTestCase; i++){
            CF755CNode currNode = new CF755CNode(i);
            allNodes[i] = currNode;
            closeNeg[i] = f.nextInt();
        }

        for(int i = 1; i <= numOfTestCase; i++){
            CF755CNode thisNode = allNodes[i];
            CF755CNode neighNode = allNodes[closeNeg[i]];

            if(thisNode.id != neighNode.id){
                thisNode.id = neighNode.id;
            }
        }

        HashSet<Integer> numOfIds = new HashSet<>();

        for(int i = 1; i <= numOfTestCase; i++){
            numOfIds.add(allNodes[i].id);
        }

        System.out.println(numOfIds.size());

    }


}


class CF755CNode{
   int ballVal;
   int id;

   CF755CNode(int i){
       ballVal = i;
       id = i;
   }

}