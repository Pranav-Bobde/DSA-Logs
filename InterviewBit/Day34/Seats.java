//Link: https://www.interviewbit.com/problems/seats/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    public int seats(String A) {
        int n = A.length();
        int m = 10000003;
        ArrayList<Integer> crosses = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            if(A.charAt(i)=='x'){
                crosses.add(i);
            }
        }
        if(crosses.size() == 0) return 0;
        for(int i=0; i<crosses.size(); i++){
            crosses.set(i, crosses.get(i) - i);
        }
        
        int ans = Integer.MAX_VALUE;
        int i = crosses.get(crosses.size()/2);
        int sum = 0;
        for(int e : crosses){
            sum+=Math.abs(e - i);
            sum%=m;
        }
        ans = Math.min(ans, sum);
        return ans;
    }
}
