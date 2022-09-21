//Link: https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

//Time & Space: O(N*N) O(N)

public class Solution {
    public static void add(Stack<Integer> s, int x){
        if(s.isEmpty() || s.peek() <= x){
            s.push(x);
            return;
        }
        int y = s.pop();
        add(s, x);
        s.push(y);
    }
    public static void sort(Stack<Integer> s){
        if(s.isEmpty()) return;
        int x = s.pop();
        sort(s);
        add(s, x);
    }
	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        sort(stack);
	}
}
