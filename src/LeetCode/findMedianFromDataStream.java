package LeetCode;
import java.util.Comparator;
import java.util.PriorityQueue;
public class findMedianFromDataStream {

  class MedianFinder {
    int size = 0;
    PriorityQueue<Integer> beforeMed = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    PriorityQueue<Integer> afterMed = new PriorityQueue<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
      if(size == 0){
        beforeMed.add(num);
        size++;
        return;
      }
      size++;
      if(num > beforeMed.peek()){
        afterMed.add(num);
      }
      else{
        beforeMed.add(num);
      }
      if(afterMed.size() > beforeMed.size()){
        beforeMed.add(afterMed.poll());
      }
      if(beforeMed.size() > afterMed.size() + 1){
        afterMed.add(beforeMed.poll());
      }
    }

    public double findMedian() {
      if(size%2 == 0){
        return ((double)beforeMed.peek() + (double)afterMed.peek())/2;
      }
      else{
        return beforeMed.peek();
      }
    }
  }

}
