// Link: https://leetcode.com/problems/sliding-window-maximum/

//Time Complexity: O(N)
//Space Complexity: O(K)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int idx = 0;
        int i=0;
        for(; i<k; i++){
            while((!dq.isEmpty()) && nums[i] >=nums[dq.peekLast()])
                dq.removeLast();
            
            dq.addLast(i);
        }
        
        for(; i<n; i++){
            ans[idx++] = nums[dq.peek()];
            
            while((!dq.isEmpty()) && dq.peek()<=i-k)
                dq.removeFirst();
            
            while((!dq.isEmpty()) && nums[i] >=nums[dq.peekLast()])
                dq.removeLast();
            
            dq.addLast(i);
        }
        ans[idx] = nums[dq.peek()];
        return ans;
    }
}
