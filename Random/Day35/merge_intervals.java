

import java.util.*;
class Main{
  static Stack<int[]> mergedIntervals = new Stack<>();
  static void mergeIntervals(int[][] arr){
      mergedIntervals.push(arr[0]);

      for(int i=1; i<arr.length; i++){

          int[] prevInterval = mergedIntervals.pop();
          int[] currInterval = arr[i];

          if(currInterval[0] > prevInterval[1]){
              mergedIntervals.push(prevInterval);
              mergedIntervals.push(currInterval);
          }else{
              int[] toAdd = new int[2];
              toAdd[0] = prevInterval[0];
              toAdd[1] = Math.max(prevInterval[1], currInterval[1]);
              mergedIntervals.push(toAdd);
          }
      }

      for(int[] e : mergedIntervals){
          System.out.println(Arrays.toString(e));
      }

  }

  public static void main(String[] args){
    int[][] intervals = new int[][]{
           {2, 4},
           {3, 6},
           {6, 8},
           {9, 12},
           {11, 13}
       };
       mergeIntervals(intervals);
  }
}
