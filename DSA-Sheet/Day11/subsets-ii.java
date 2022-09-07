//Link: https://leetcode.com/problems/subsets-ii/

//Time & Space: O(2^N*N) O(2^N*K)

class Solution {
    void f(int idx, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i=idx; i<nums.length; i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            f(i+1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        f(0, nums, new ArrayList<Integer>(), ans);
        return ans;
    }
}
