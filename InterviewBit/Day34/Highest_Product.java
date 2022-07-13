//Link: https://www.interviewbit.com/problems/highest-product/

//Time & Space Complexity: O(NlogN) O(1)

public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        return Math.max(
            A.get(n-1)*A.get(n-2)*A.get(n-3),
            A.get(0)*A.get(1)*A.get(n-1)
        );
    }
}
