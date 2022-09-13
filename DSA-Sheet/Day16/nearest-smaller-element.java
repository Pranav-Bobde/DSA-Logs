//Link: https://www.interviewbit.com/problems/nearest-smaller-element/

//Time & Space: O(N) O(N)

public class Solution {
    public int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        int idx = 0;
        Stack<Integer> s = new Stack<>();
        for(int i : A){
            while(!s.isEmpty() && i <= s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                ans[idx++] = -1;
            }else{
                ans[idx++] = s.peek();
            }
            s.push(i);
        }
        return ans;
    }
}

