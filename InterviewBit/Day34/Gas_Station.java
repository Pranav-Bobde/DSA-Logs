//Link: https://www.interviewbit.com/problems/gas-station/

//Time & Space Complexity: O(N) O(1)

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int curr = 0, start = 0;
        
        for(int i=0; i<2*n && start<n; i++){
            
            if(i == start+n) return start;
            
            int g = A.get(i%n);
            int c = B.get(i%n);
            
            curr += g - c;
            
            if(curr < 0){
                curr = 0;
                start = i + 1;
            }
        }
        return -1;
    }
}
