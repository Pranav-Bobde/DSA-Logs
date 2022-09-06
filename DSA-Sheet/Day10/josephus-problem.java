//Link: https://practice.geeksforgeeks.org/problems/josephus-problem/1

//Time & Space: O(N^2) O(N)

class Solution
{
    int ans = 0;
    ArrayList<Integer> al = new ArrayList<>();
    ArrayList<Integer> al2 = new ArrayList<>();
    void solve(int i, int k){
        if(al.size()==1){ 
            ans = al2.indexOf(al.get(0)) + 1;
            return;
        }
        i = (i+k)%al.size();
        al.remove(i);
        solve(i, k);
    }
    public int josephus(int n, int k)
    {
        k--;
        for(int i=0; i<n; i++) {
            al.add(i);
            al2.add(i);
        }
        solve(0, k);
        return ans;
    }
}
