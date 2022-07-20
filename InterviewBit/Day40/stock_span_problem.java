//Link: https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

//Time & Space Complexity: O(N) O(N)

class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    static class Node{
        int val;
        int idx;
        Node(int v, int i){
            val = v;
            idx = i;
        }
    }
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        ArrayList<Integer> A = new ArrayList<>();
        for(int i: price)
            A.add(i);
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        for(int i=0; i<A.size(); i++){
            if(s.isEmpty()){
                ans.add(i+1);
            }else if(s.peek().val > A.get(i)){
                ans.add(i - s.peek().idx);
            }else if(s.peek().val <= A.get(i)){
                while(!s.isEmpty() && s.peek().val <= A.get(i))
                    s.pop();
                if(s.isEmpty())
                    ans.add(i+1);
                else
                    ans.add(i - s.peek().idx);
            }
            s.push(new Node(A.get(i), i));
        }
        int[] arr = new int[A.size()];
        for(int i=0; i<A.size(); i++)
            arr[i] = ans.get(i);
        return arr;
    }
    
}
