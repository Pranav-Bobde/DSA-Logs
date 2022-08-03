//Link: https://leetcode.com/contest/weekly-contest-302/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

//Time & Space Complexity: O(N) O(N)
class Solution {
    int digiSum(int num){
        int sum = 0;
        while(num>0){
            int lastD = num%10;
            sum+=lastD;
            num/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> sumToNumsMap = new HashMap<>();
        for(int i : nums){
            int dSum = digiSum(i);
            if(sumToNumsMap.get(dSum) == null){
                sumToNumsMap.put(dSum, new PriorityQueue<>(Collections.reverseOrder()));
            }
            sumToNumsMap.get(dSum).add(i);
        }
        int ans = -1;
        for(Map.Entry<Integer, PriorityQueue<Integer>> e : sumToNumsMap.entrySet()){
            if(e.getValue().size() > 1 ){
                    ans = Math.max(ans, e.getValue().poll() + e.getValue().poll());
            }
        }
        
        return ans;
    }
}

//Better
//Time & Space Complexity: O(N) O(N)
class Solution {
    int digiSum(int num){
        int sum = 0;
        while(num>0){
            int lastD = num%10;
            sum+=lastD;
            num/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for(int i : nums){
            int dSum = digiSum(i);
            if(!map.containsKey(dSum)){
                map.put(dSum, i);
            }else{
                ans = Math.max(ans, map.get(dSum) + i);
                map.put(dSum, Math.max(i, map.get(dSum)));
            }
        }
        return ans;
    }
}
