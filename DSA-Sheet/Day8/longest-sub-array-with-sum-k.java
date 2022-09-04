//Link: https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

//Time & Space: O(N) O(N)

class Solution{
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        
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
