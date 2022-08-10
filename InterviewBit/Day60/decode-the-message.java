//Link: https://leetcode.com/contest/weekly-contest-300/problems/decode-the-message/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char ch = 'a';
        for(char c : key.toCharArray()){
            if(c!=' ' && map.get(c)==null){
                map.put(c, ch);
                if(ch=='z') break;
                ch++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : message.toCharArray()){
            if(c==' ')
                sb.append(c);
            else
                sb.append(map.get(c));
        }
        return sb.toString();
    }
}
