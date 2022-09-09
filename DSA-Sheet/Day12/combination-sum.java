//Link: https://leetcode.com/problems/combination-sum/

//Time & Space Complexity: O(2^T*N) O(T*N)

class Solution {
    void solve(int i, List<Integer> curr, int[] arr, int currSum, int t, List<List<Integer>> ans){
        if(i>=arr.length || currSum>t){
            return;
        }
        if(currSum == t){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        List<Integer> pass = new ArrayList<Integer>(curr);
        pass.add(arr[i]);
        solve(i, pass, arr, currSum+arr[i], t, ans);
        pass.remove(pass.size()-1);
        solve(i+1, pass, arr, currSum, t, ans);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        solve(0, new ArrayList<Integer>(), arr, 0, target, ans);
        return ans;
    }
}
