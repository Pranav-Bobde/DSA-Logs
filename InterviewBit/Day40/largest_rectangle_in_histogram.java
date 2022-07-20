//Link: https://www.interviewbit.com/problems/largest-rectangle-in-histogram/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> nsr = new ArrayList<Integer>();
        ArrayList<Integer> nsl = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            if(s.isEmpty()){
                nsl.add(-1);
            }else if(A.get(s.peek()) < A.get(i)){
                nsl.add(s.peek());
            }else if(A.get(s.peek()) >= A.get(i)){
                while(!s.isEmpty() && A.get(s.peek()) >= A.get(i))
                    s.pop();
                if(s.isEmpty())
                    nsl.add(-1);
                else
                    nsl.add(s.peek());
            }
            s.push(i);
        }
        s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(s.isEmpty()){
                nsr.add(n);
            }else if(A.get(s.peek()) < A.get(i)){
                nsr.add(s.peek());
            }else if(A.get(s.peek()) >= A.get(i)){
                while(!s.isEmpty() && A.get(s.peek()) >= A.get(i))
                    s.pop();
                if(s.isEmpty())
                    nsr.add(n);
                else
                    nsr.add(s.peek());
            }
            s.push(i);
        }
        Collections.reverse(nsr);
        for(int i = 0; i<n; i++){
            int area = A.get(i) * ( i - nsl.get(i) + nsr.get(i) - i - 1);
            if(area > max)
                max = area;
        }
        return max;
    }
}

