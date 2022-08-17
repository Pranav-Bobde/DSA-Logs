//Link: https://leetcode.com/problems/partition-equal-subset-sum/

//Time & Space Complexity: O(N*K) O(N*K)

class Solution {
    boolean subsetSum(int[] arr, int sum){
        int N = arr.length;
        boolean[][] t = new boolean[N+1][sum+1];
        for(int i=0; i<=N; i++){
            t[i][0] = true;
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] | t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[N][sum];
        
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i:nums)
            sum+=i;
        if( (sum&1) == 1 ) return false;
        return subsetSum(nums, sum/2);
    }
}
