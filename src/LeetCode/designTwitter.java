package LeetCode;
import java.util.*;
public class designTwitter {

  class Twitter {

    int time = 0;
    ArrayList<Tweet>[] newestTweetsByUser;
    HashSet<Integer>[] follows;

    public Twitter() {
      newestTweetsByUser = new ArrayList[501];
      follows = new HashSet[501];
      for (int i = 0; i < newestTweetsByUser.length; i++) {
        newestTweetsByUser[i] = new ArrayList<>();
        follows[i] = new HashSet<>();
        follows[i].add(i);
      }
    }

    public void postTweet(int userId, int tweetId) {
      newestTweetsByUser[userId].add(new Tweet(time, tweetId));
      time++;
    }

    public List<Integer> getNewsFeed(int userId) {
      PriorityQueue<Tweet> allTweet = new PriorityQueue<>();
      for (int i: follows[userId]
           ) {
        for (Tweet t: newestTweetsByUser[i]
             ) {
          allTweet.add(t);
        }
      }
      ArrayList<Integer> newsF = new ArrayList<>();
      for (int i = 0; i < 10 ; i++){
        if(!allTweet.isEmpty()){
          newsF.add(allTweet.poll().id);
        }
      }
      return newsF;
    }

    public void follow(int followerId, int followeeId) {
      follows[followerId].add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
      follows[followerId].remove(Integer.valueOf(followeeId));
    }
  }

  class Tweet implements Comparable<Tweet>{
    int time;
    int id;

    Tweet(int time, int id){
      this.time = time;
      this.id = id;
    }

    @Override
    public int compareTo(Tweet t){
      return Integer.compare(t.time, time);
    }
  }



}
