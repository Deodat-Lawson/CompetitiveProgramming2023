package Codeforces;
import java.io.*;
import java.util.*;
public class CF1921E {

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
    int h = nextInt();
    int w = nextInt();
    int x1 = nextInt();
    int y1 = nextInt();
    int x2 = nextInt();
    int y2 = nextInt();


    if(x1 >= x2){
      System.out.println("Draw");
      return;
    }

    if ((x1 - x2) % 2 == 0) {
      //even then who ever moves first looses. Meaning that A wants to escape from B as fast as possible

      while (x2 > x1) {
        //A makes move to run away from B

        if (y1 > y2) {
          if (y1 < w) {
            y1++;
          }
        } else {
          if (y1 > 1) {
            y1--;
          }
        }
        x1++;

        if (y1 - y2 == 0) {
          System.out.println("Bob");
          return;
        }


        //B tries to catch up
        if (y1 > y2) {
          if (y2 < w) {
            y2++;
          }
        } else if (y2 > y1) {
          if (y2 > 1) {
            y2--;
          }
        }
        x2--;

        if (y1 - y2 == 0) {
          System.out.println("Bob");
          return;
        }

      }

      System.out.println("Draw");
      return;
    } else {
      x1++;
      if(y1 > y2){
        y1--;
      }
      else if(y1 < y2){
        y1++;
      }

      if (y1 - y2 == 0) {
        System.out.println("Alice");
        return;
      }

      while (x2 > x1) {
        if (y2 > y1) {
          if (y2 < w) {
            y2++;
          }
        } else if (y2 < y1) {
          if (y2 > 1) {
            y2--;
          }
        }
        x2--;

        if (y1 - y2 == 0) {
          System.out.println("Alice");
          return;
        }


        //A tries to catch up
        if (y2 > y1) {
          if (y1 < w) {
            y1++;
          }
        } else if (y1 > y2) {
          if (y1 > 1) {
            y1--;
          }
        }

        x1++;

        if (y1 - y2 == 0) {
          System.out.println("Alice");
          return;
        }

      }

      System.out.println("Draw");
      return;
    }

  }


static String next()throws IOException{
    while(tok==null||!tok.hasMoreTokens()){
    tok=new StringTokenizer(f.readLine().trim());
    }
    return tok.nextToken();
    }

static long nextLong()throws IOException{
    return Long.parseLong(next());
    }

static int nextInt()throws IOException{
    return Integer.parseInt(next());
    }

static double nextDouble()throws IOException{
    return Double.parseDouble(next());
    }

static char nextCharacter()throws IOException{
    return next().charAt(0);
    }

static String nextLine()throws IOException{
    return f.readLine().trim();
    }
    }
