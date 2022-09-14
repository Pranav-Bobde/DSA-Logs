//Link: https://leetcode.com/problems/sliding-window-maximum/

//Time & Space: O(N) O(N)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int i=0, j=0, idx = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        while(j<n){
            while(!q.isEmpty() && q.peekLast() < nums[j]){
                q.removeLast();
            }
            q.add(nums[j]);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                ans[idx++] = q.peek();
                if(q.peek() == nums[i]){
                    q.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
