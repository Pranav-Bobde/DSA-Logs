//Link: https://leetcode.com/problems/subsets-ii/

//Time & Space: O(2^N * N) O(2*N)

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    void solve(int i, List<Integer> curr, int[] arr, int n){
        
        if(i==n){
            List<Integer> toAdd = new ArrayList<>(curr);
            ans.add(toAdd);
            return;
        }
        
        List<Integer> list = new ArrayList<>(curr);
        list.add(arr[i]);
        solve(i+1, list, arr, n);
        if(!list.isEmpty())
            list.remove(list.size() - 1);
        while(i<n-1 && arr[i] == arr[i+1]) i++;
        solve(i+1, list, arr, n);
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        solve(0, new ArrayList<Integer>(), nums, n);
        return ans;
    }
}
