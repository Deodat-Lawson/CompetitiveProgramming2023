package LeetCode;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class taskSchedule {

  public int leastInterval(char[] tasks, int n) {
    int[] tasksS = new int[26];
    ArrayList<Tasks>[] inputAtTime = new ArrayList[tasks.length * (n + 1) + 1];
    int lastRemoveTime = 0;

    for (int i = 0; i < inputAtTime.length; i++) {
      inputAtTime[i] = new ArrayList<>();
    }

    for (int i = 0; i < tasks.length; i++) {
      tasksS[tasks[i] - 'A']++;
    }

    for (int i = 0; i < tasksS.length; i++) {
      if(tasksS[i] != 0){
        inputAtTime[0].add(new Tasks((char)(i + 'A'), tasksS[i]));
      }
    }
    PriorityQueue<Tasks> allQ = new PriorityQueue<>();
    for (int i = 0; i < inputAtTime.length; i++) {
      for (Tasks t: inputAtTime[i]
           ) {
        allQ.add(t);
      }

      if(!allQ.isEmpty()){
        Tasks T = allQ.poll();
        T.freq--;
        if(T.freq > 0) {
          inputAtTime[i + n + 1].add(T);
        }
        lastRemoveTime = i + 1;
      }

    }

    return lastRemoveTime;

  }

  class Tasks implements Comparable<Tasks>{
    char currentTask;
    int freq;

    Tasks(char currentTask, int freq){
      this.currentTask = currentTask;
      this.freq = freq;
    }

    @Override
    public int compareTo(Tasks o){
      return Integer.compare(o.freq, this.freq);
    }
  }

}
