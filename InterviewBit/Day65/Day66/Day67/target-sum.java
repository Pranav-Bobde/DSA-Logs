//Link: https://leetcode.com/problems/target-sum/

//Time & Space Complexity: O(N*K) O(N*K)

class Solution {
    int solve(int[] arr, int sum){
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];
        for(int i=0; i<=n; i++){
            t[i][0] = 1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return (int)(t[n][sum]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums) sum+=i;
        if(sum < Math.abs(target) || (target+sum) %2 != 0) return 0;
	    int newTarget = (sum - target)/2;
        return solve(nums, newTarget);   
    }
}
