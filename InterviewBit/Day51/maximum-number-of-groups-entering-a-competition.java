//Link: https://leetcode.com/contest/weekly-contest-304/problems/maximum-number-of-groups-entering-a-competition/

//Time & Space Complexity: O(NLogN) O(1)

class Solution {
    boolean isPossible(int total, int[] arr){
        int grps = 0, s = 1, i=0, n = arr.length, r = n;
        while(grps < total && r>=s){
            int t = s;
            while(t-->0){
                i++;
            }
            r = n-i;
            s++;
            grps++;
        }
        
        return grps == total;
    }
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        Arrays.sort(grades);
        int s = 1, e = n, ans = 1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(isPossible(mid, grades)){
                s = mid + 1;
                ans = mid;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
}
