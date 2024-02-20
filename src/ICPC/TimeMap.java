package ICPC;
import com.sun.source.tree.Tree;
import org.jetbrains.annotations.NotNull;

import java.util.*;
class TimeMap {
  HashMap<String, TreeSet<StringStamp>> maps;

  public TimeMap() {
    maps = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    TreeSet<StringStamp> currentList = maps.getOrDefault(key, new TreeSet<>());
    currentList.add(new StringStamp(timestamp, value));
    maps.put(key, currentList);
  }

  public String get(String key, int timestamp) {
    TreeSet<StringStamp> currentList = maps.getOrDefault(key, new TreeSet<>());
    StringStamp thisStamp = currentList.floor(new StringStamp(timestamp, ""));
    if(thisStamp == null){
      return "";
    }
    return thisStamp.value;
  }


  class StringStamp implements Comparable<StringStamp>{
    int time;
    String value;

    StringStamp(int timeSt, String val){
      time = timeSt;
      value = val;
    }
    @Override
    public int compareTo(StringStamp o) {
      return Integer.compare(time, o.time);
    }
  }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
