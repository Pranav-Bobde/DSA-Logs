//Link: https://practice.geeksforgeeks.org/contest/interview-series-57/problems/#

//Time & Space Complexity: O(N) O(1)

// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            System.out.println(_result_val);
        }
    }
}
// } Driver Code Ends



class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        for(int i=0; i<m; i++){
            if(seats[i]==1){
                if(i>0)
                    seats[i-1] = -1;
                if(i<m-1 && seats[i+1] != 1)
                    seats[i+1] = -1;
            }
        }
        
        int i=0, j=0, c = 0;
        while(j<m){
            while(j<m && seats[j]==0) j++;
            int size = j-i;
            if((size&1) == 1){
                c+= ((size+1)/2);
            }else{
                c+=(size/2);
            }
            while(j<m && seats[j]!=0) j++;
            if(j==m) break;
            i=j;
        }
        return c>=n;
    }
}
        
