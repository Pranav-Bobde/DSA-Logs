//Link: https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1

//Time & Space: O(N) O(N)

class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                arr[i] = -1;
            }
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        int k = 0;
        
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum == k){
                max = Math.max(i+1 , max);
            }
            else if(map.containsKey(sum-k)){
                max = Math.max(i-map.get(sum-k) , max);
            }
            if(!(map.containsKey(sum))){
                map.put(sum, i);
            }
        }
        return max;
    }
}
