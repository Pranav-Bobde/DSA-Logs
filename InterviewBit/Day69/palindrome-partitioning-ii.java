//Link: https://www.interviewbit.com/problems/palindrome-partitioning-ii/

//Time & Space Complexity: O(N^2) O(N^2)

public class Solution {
    public int minCut(String A) {
        int i=0, j=A.length()-1;
        int[][] dp = new int[501][501];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return solve(A, i, j, dp);
    }
    static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    static int solve(String s, int i, int j, int[][] dp){
        if(i>=j) return 0;
        if(isPalindrome(s, i, j)==true) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int left = -1, right = -1;
            if(dp[i][k]!=-1) 
                left = dp[i][k];
            else
                left = solve(s, i, k, dp);
            if(dp[k+1][j]!=-1) 
                right = dp[k+1][j];
            else
                right = solve(s, k+1, j, dp);
            
            int temp = 1 + left + right;
            if(temp < min) min = temp;
        }
        return dp[i][j]=min;
    }
}

