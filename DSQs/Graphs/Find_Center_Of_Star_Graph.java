//Link: https://leetcode.com/problems/find-center-of-star-graph/

//Time & Space Complexity: O(1) O(1)
//Optimal Soln

class Solution {
    public int findCenter(int[][] arr) {
        return (arr[0][0] == arr[1][0] || arr[0][0] == arr[1][1]) ? arr[0][0] : arr[0][1];
    }
}

//Time & Space Complexity: O(N) O(N)
//Brute Force

class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1, ans = 1;
        int[] count = new int[n+1];
        for(int[] arr : edges){
            count[arr[1]]++;
            count[arr[0]]++;
        }
        for(int i=1; i<n+1; i++){
            if(count[i] == n-1){
                ans = i; 
                break;
            }
        }
        return ans;
    }
}
