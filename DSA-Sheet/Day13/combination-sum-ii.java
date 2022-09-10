//Link: https://leetcode.com/problems/combination-sum-ii/

//Time & Space: O(2*N) O(N*N)

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    void solve(int pos, List<Integer> curr, int[] arr, int n, int target){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target <= 0) return;
        int prev = -1;
        for(int i = pos; i<n; i++){
            if(arr[i] == prev) continue;
            List<Integer> list = new ArrayList<>(curr);
            list.add(arr[i]);
            solve(i+1, list, arr, n, target-arr[i]);
            prev = arr[i];
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        solve(0, new ArrayList<Integer>(), arr, arr.length, target);
        return ans;
    }
}
