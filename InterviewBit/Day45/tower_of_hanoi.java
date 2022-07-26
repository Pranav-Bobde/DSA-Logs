//Link: https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1

//Time & Space Complexity: O(N) O(N)

class Hanoi {

    void solve(int s, int d, int h, int n, long[] ans){
        if(n==1){
            ans[0]++;
            System.out.println("move disk " + n + " from rod " + s + " to rod " +  d);
            return;
        }
        solve(s, h, d, n-1, ans);
        System.out.println("move disk " + (n) + " from rod " + s + " to rod " + d);
        ans[0]++;
        solve(h, d, s, n-1, ans);
    }
    
    public long toh(int N, int from, int to, int aux) {
        // Your code here
        long[] ans = new long[]{0};
        solve(from, to, aux, N, ans);
        return ans[0];
    }
}
