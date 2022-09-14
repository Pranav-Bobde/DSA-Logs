//Link: https://leetcode.com/problems/min-stack/

//With one Stack
//Time & Space: O(N) O(N)
class MinStack {
    Stack<Integer> s;
    int min;
    public MinStack() {
        s = new Stack<>();
        min = -1;
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            min = val;
            s.push(val);
            return;
        }
        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
        
    }
    
    public void pop() {
        if(s.isEmpty()){
            return;
        }
        
        if(s.pop() == min){
            if(!s.isEmpty())
                min = s.pop();
        }
    }
    
    public int top() {
        return s.isEmpty() ? -1 : s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

//With 2 Stacks
//Time & Space: O(N) O(N)
class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();        
    }
    
    public void push(int val) {
        s1.push(val);
        if(s2.isEmpty() || val <= s2.peek()){
            s2.push(val);
        }
    }
    
    public void pop() {
        int e = s1.peek();
        if(!s1.isEmpty()){
            s1.pop();
            if(s2.peek() == e){
                s2.pop();
            }
        }
    }
    
    public int top() {
        return s1.isEmpty() ? -1 : s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
