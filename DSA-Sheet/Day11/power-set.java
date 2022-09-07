//Link: https://practice.geeksforgeeks.org/problems/power-set4302/1

//Time & Space: O(2^N*N) O(2*N)

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<(1<<n); i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if((i & (1<<j)) != 0){
                    sb.append(s.charAt(j));
                }
            }
            if(!sb.toString().isEmpty())
                ans.add(sb.toString());
        }
        Collections.sort(ans);
        return ans;
    }
}
