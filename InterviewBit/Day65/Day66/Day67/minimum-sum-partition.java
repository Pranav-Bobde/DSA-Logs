//Link: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1

//Time & Space Complexity: O(N*K) O(N*K); N-> arr length, K-> n value

class Solution
{
    boolean subsetSum(int[] arr, int sum, boolean[][] t){
        int N = arr.length;
    
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
	public int minDifference(int arr[], int n) 
	{ 
        int sum = 0;
        for(int i: arr)
            sum += i;
        boolean[][] t = new boolean[n+1][sum+1];
        subsetSum(arr, sum, t);
        ArrayList<Integer> al = new ArrayList<>();
        for(int j=0; j<sum/2+1; j++)
            if(t[n][j]==true) al.add(j);
        int min = Integer.MAX_VALUE;
        for(int i: al)
            min = Math.min(min, Math.abs(sum - 2*i));
        return min;
	} 
}
