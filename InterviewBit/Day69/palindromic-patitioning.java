//Link: https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1

//Time & Space Complexity: O(N^2) O(N^2)

class Solution{
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
            int temp = 1 + solve(s, i, k, dp) + solve(s, k+1, j, dp);
            if(temp < min) min = temp;
        }
        return dp[i][j]=min;
    }
    static int palindromicPartition(String str)
    {
        int i=0, j=str.length()-1;
        int[][] dp = new int[501][501];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return solve(str, i, j, dp);
    }
}
