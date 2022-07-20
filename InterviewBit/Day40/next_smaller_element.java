//Link: https://www.interviewbit.com/problems/nearest-smaller-element/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<A.size(); i++){
            if(s.isEmpty()){
                ans.add(-1);
            }else if(s.peek() < A.get(i)){
                ans.add(s.peek());
            }else if(s.peek() >= A.get(i)){
                while(!s.isEmpty() && s.peek() >= A.get(i))
                    s.pop();
                if(s.isEmpty())
                    ans.add(-1);
                else
                    ans.add(s.peek());
            }
            s.push(A.get(i));
        }
        return ans;
    }
}
