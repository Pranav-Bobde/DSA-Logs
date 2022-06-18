//Link: https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        
        int i = 0, j = n-1, ans = 0, area = 0;
        
        while(i<j){
            if(height[i] < height[j]){
                area = height[i] * (j-i);
                i++;
            }else if(height[i] > height[j]) {
                area = height[j] * (j-i);
                j--;
            }else{
                area = height[i] * (j-i);
                i++;
                j--;
            }
            ans = Math.max(ans, area);
        }
        
        return ans;
    }
}
