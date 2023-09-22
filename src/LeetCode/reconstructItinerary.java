package LeetCode;

import java.io.*;
import java.util.*;

public class reconstructItinerary {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {

  }

  public List<String> findItinerary(List<List<String>> tickets) {
    HashSet<String> allAirports = new HashSet<>();
    ArrayList<String> allAirportsSorted = new ArrayList<>();

    HashMap<String, Integer> AirportMap = new HashMap<>();

    for (int i = 0; i < tickets.size(); i++) {
      List<String> thisDestination = tickets.get(i);
      for (int j = 0; j < thisDestination.size(); j++) {
        allAirports.add(thisDestination.get(j));
      }
    }

    allAirportsSorted.addAll(allAirports);
    Collections.sort(allAirportsSorted);

    for (int i = 0; i < allAirportsSorted.size(); i++) {
      AirportMap.put(allAirportsSorted.get(i),i);
    }

    ArrayList<Integer>[] adjList = new ArrayList[allAirportsSorted.size()];
    for (int i = 0; i < allAirportsSorted.size(); i++) {
      adjList[i] = new ArrayList<>();
    }

    for (int i = 0; i < tickets.size(); i++) {
      List<String> a = tickets.get(i);
      int from = AirportMap.get(a.get(0));
      int to = AirportMap.get(a.get(1));
      adjList[from].add(to);
    }

    for (int i = 0; i < allAirportsSorted.size(); i++) {
      Collections.sort(adjList[i]);
    }


  }

  public int dfs(int currentNode, ArrayList<Integer>[] adjList, ArrayList<Integer> values){
    for (int i = 0; i < ; i++) {
      
    }
    
  }



}
