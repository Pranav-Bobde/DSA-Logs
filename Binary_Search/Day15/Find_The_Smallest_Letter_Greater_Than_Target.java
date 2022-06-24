//Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/

//Time & Space Complexity: O(logN) O(1)

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if(target > letters[n-1]) return letters[0];
        int s = 0, e = n-1;
        char ans = letters[0];
        while(s<=e){
            int mid = s + (e-s)/2; 
            char m = letters[mid];
            if(m > target){
                ans = m;
                e = mid-1;
            }else if(m < target){
                s = mid+1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }
}
