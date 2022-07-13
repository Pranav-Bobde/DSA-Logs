//Link: https://www.interviewbit.com/problems/interview-questions/

//Time & Space Complexity: O(N) O(1)

public class Solution {
    public int bulbs(ArrayList<Integer> A) {
        int cost = 0;
        for(int i=0; i<A.size(); i++){
            if( (cost & 1) == 1 ){
                if(A.get(i) == 1)
                    A.set(i, 0);
                else
                    A.set(i, 1);
            }
            
            if( A.get(i) == 0 )
                cost++;
        }
        return cost;
    }
}
