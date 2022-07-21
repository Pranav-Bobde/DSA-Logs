//Link: https://practice.geeksforgeeks.org/contest/job-a-thon-11-hiring-challenge/problems/#

//Time & Space Complexity: O(N) O(1)

class Solution {
    public static String solve(int N, int[] arr) {
        // code here
        if(N<=1) return "YES";
        int a = arr[0];
        for(int i=1; i<N; i++){
            if(arr[i] != -a)
                return "NO";
            a = arr[i];
        }
        return "YES";
    }
}
