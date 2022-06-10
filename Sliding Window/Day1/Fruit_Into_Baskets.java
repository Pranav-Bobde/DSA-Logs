// Link: https://leetcode.com/problems/fruit-into-baskets/discuss/?currentPage=1&orderBy=most_votes

class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int i=0, j = 0, ans = Integer.MIN_VALUE;
        
        while(j<n){
            int curr = arr[j];
            if(map.size() <= 2)
                map.put(curr, j++);
            
            if(map.size() > 2){
                int min = Integer.MAX_VALUE;
                for(int m : map.values())
                    min = Math.min(min, m);
                i = min + 1;
                map.remove(arr[min]);
            }
            ans = Math.max(ans, j-i);
        }
        return ans;
    }
}
