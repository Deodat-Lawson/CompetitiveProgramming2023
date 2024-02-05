package LeetCode;

class MinStack {
  long[] arr = new long[100001];
  long[] smallest = new long[100001];
  int smallestPointer;
  int pointer;
  public MinStack() {
    pointer = 0;
    smallestPointer = 1;
    smallest[0] = Integer.MAX_VALUE;
  }

  public void push(int val) {
    arr[pointer] = val;
    pointer++;
    if(smallest[smallestPointer - 1] >= val){
      smallest[smallestPointer] = val;
      smallestPointer++;
    }
  }

  public void pop() {
    if(arr[pointer - 1] == smallest[smallestPointer - 1]){
      smallestPointer--;
    }
    pointer--;
  }

  public int top() {
    return (int) arr[pointer - 1];
  }

  public int getMin() {
    return (int) smallest[smallestPointer - 1];
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */