//Link: https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

//Time & Space: O(N) O(N)

class GfG
{
    int maxLen(int arr[], int n)
    {
        int max = 0, sum = 0, currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            currSum+=arr[i];
            if(currSum == sum){
                max = Math.max(i+1, max);
            }else if(map.containsKey(currSum-sum)){
                max = Math.max(i-map.get(currSum-sum), max);
            }
            if(!map.containsKey(currSum-sum)){
                map.put(currSum, i);
            }
        }
        return max;
        
    }
}
