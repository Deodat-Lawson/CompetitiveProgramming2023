package LeetCode;

import java.io.*;
import java.util.*;

public class MeetingRooms3 {

  static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer tok;

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      solve();
    }
  }

  public static void solve() throws IOException {
    //Todo: write your implementation
  }

  public int mostBooked(int n, int[][] meetings) {
    ArrayList<Meetings> allMeetings = new ArrayList<>();
    for (int i = 0; i < meetings.length; i++) {
      allMeetings.add(new Meetings(meetings[i][0], meetings[i][1]));
    }
    Collections.sort(allMeetings);
    PriorityQueue<Integer> smallestRoomAvailable = new PriorityQueue<>();
    PriorityQueue<MeetingsEnd> endTimes = new PriorityQueue<>();

    int[] count = new int[n];

    for (int i = 0; i < n; i++) {
      smallestRoomAvailable.add(i);
    }

    for (int i = 0; i < meetings.length; i++) {
      Meetings currMeeting = allMeetings.get(i);

      while (!endTimes.isEmpty() && endTimes.peek().endTime < currMeeting.plannedStart){
        smallestRoomAvailable.add(endTimes.poll().room);
      }

      if (!smallestRoomAvailable.isEmpty()) {
        int room = smallestRoomAvailable.poll();
        currMeeting.actualStart = currMeeting.plannedStart;
        currMeeting.actualEnd = currMeeting.actualStart + currMeeting.length;
        count[room]++;
        endTimes.add(new MeetingsEnd(currMeeting.actualEnd, room));
      }
      else{
        MeetingsEnd ME = endTimes.poll();
        currMeeting.actualStart = ME.endTime + 1;
        currMeeting.actualEnd = currMeeting.actualStart + currMeeting.length;
        count[ME.room]++;
        endTimes.add(new MeetingsEnd(currMeeting.actualEnd, ME.room));
      }


    }

    int maxC = 0;
    int room = -1;
    for (int i = 0; i < n; i++) {
      if(count[i] > maxC){
        maxC = count[i];
        room = i;
      }
    }

    return room;


  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(f.readLine().trim());
    }
    return tok.nextToken();
  }

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char nextCharacter() throws IOException {
    return next().charAt(0);
  }

  static String nextLine() throws IOException {
    return f.readLine().trim();
  }

  class Meetings implements Comparable<Meetings> {
    long plannedStart, length, actualStart, actualEnd;

    Meetings(long start, long end) {
      plannedStart = start;
      length = end - start - 1;
    }

    @Override
    public int compareTo(Meetings o1) {
      return Long.compare(plannedStart, o1.plannedStart);
    }

  }

  class MeetingsEnd implements Comparable<MeetingsEnd> {

    long endTime;
    int room;

    MeetingsEnd(long end, int r){
      endTime = end;
      room = r;
    }

    @Override
    public int compareTo(MeetingsEnd o1){
      if(endTime != o1.endTime){
        return Long.compare(endTime, o1.endTime);
      }
      else{
        return Integer.compare(room, o1.room);
      }

    }
  }

}
