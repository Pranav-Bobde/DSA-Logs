//Link: https://leetcode.com/problems/valid-parentheses/

//Time & Space: O(N) O(N)

class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(char c : str.toCharArray()){
            if(
                c == '(' ||
                c == '[' ||
                c == '{'
              ){
                s.push(c);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if(c==')'){
                    if(s.peek() != '('){
                        return false;
                    }else{
                        s.pop();
                    }
                }else if(c==']'){
                    if(s.peek() != '['){
                        return false;
                    }else{
                        s.pop();
                    }
                }else{
                    if(s.peek() != '{'){
                        return false;
                    }else{
                        s.pop();
                    }
                }
            }
        }
        
        return s.isEmpty();
    }
}
