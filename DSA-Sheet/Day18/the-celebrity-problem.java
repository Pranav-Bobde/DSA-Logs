//Link: https://www.codingninjas.com/codestudio/problems/the-celebrity-problem_982769?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

//Time & Space: O(N) O(N)

public class Solution {
	public static int findCelebrity(int n) {
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++) s.push(i);
        while(s.size()>1){
            int b = s.pop();
            int a = s.pop();
            if(Runner.knows(a, b)){
                s.push(b);
            }else{
                s.push(a);
            }
        }
        int ans = s.pop();        
        for(int i=0; i<n; i++){
            if(i!=ans && !(!Runner.knows(ans, i) && Runner.knows(i, ans))){
                return -1;
            }
        }
        return ans;
    }
}
