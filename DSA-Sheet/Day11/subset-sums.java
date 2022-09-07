//Link: https://practice.geeksforgeeks.org/problems/subset-sums2234/1

//Time & Space: O(2^N) O(N)

class Solution{
    void f(int i, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> ans){
        if(i == N){
            ans.add(sum);
            return;
        }
        f(i+1, sum+arr.get(i), arr, N, ans);
        f(i+1, sum, arr, N, ans);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        f(0, 0, arr, N, ans);
        return ans;
    }
}
