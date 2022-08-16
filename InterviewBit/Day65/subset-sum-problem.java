//Link: https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

//Time & Space Complexity: O(N*K) O(N*K)

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
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
}
