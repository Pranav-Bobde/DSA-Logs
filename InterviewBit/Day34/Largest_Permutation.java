//Link: https://www.interviewbit.com/problems/largest-permutation/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int[] posMax = new int[A.size()+1];
        
        int max = A.size();
        for(int k=0; k<A.size(); k++){
            posMax[A.get(k)] = k;
        }
        int i = 0, j = 0;
        while(B>0 && i<A.size()){
            j = posMax[max];
            if(i!=j){
                B--;
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
                posMax[max] = i;
                posMax[A.get(j)] = j;
            }
            i++;
            max--;
        }
        return A;
    }
}
