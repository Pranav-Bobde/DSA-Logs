//Link: https://leetcode.com/problems/largest-rectangle-in-histogram/

//Time & Space: O(N) O(N)

class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int ans = 0;
        int[] sl = new int[n];
        int[] sr = new int[n];
        Stack<Integer> s = new Stack<>();
        int idx = 0;
        for(int i=0; i<n; i++){
            int num = h[i];
            while(!s.isEmpty() && num <= h[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                sl[idx++] = -1;
            }else{
                sl[idx++] = s.peek();
            }
            s.push(i);
        }
        s = new Stack<>();
        idx = n-1;
        for(int i=n-1; i>=0; i--){
            int num = h[i];
            while(!s.isEmpty() && num <= h[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                sr[idx--] = n;
            }else{
                sr[idx--] = s.peek();
            }
            s.push(i);
        }
        for(int i=0; i<n; i++){
            int left = sl[i];
            int right = sr[i];
            
            ans = Math.max(ans, h[i]*(right-left-1));
        }
        
        return ans;
    }
}
