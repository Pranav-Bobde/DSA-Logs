//Link: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1

//Time & Space Complexity: O(N*K) O(N*K)

class Solution{
    int solve(int[] arr, int sum){
        int n = arr.length;
        int mod = (int)1e9+7;
        long[][] t = new long[n+1][sum+1];
        for(int i=0; i<=n; i++){
            t[i][0] = 1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(arr[i-1]<=j){
                    t[i][j] = (t[i-1][j-arr[i-1]]%mod + t[i-1][j]%mod)%mod;
                }else{
                    t[i][j] = t[i-1][j]%mod;
                }
            }
        }
        
        return (int)(t[n][sum]%mod);
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    return solve(arr, sum);
	} 
}
