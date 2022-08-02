//Link: https://leetcode.com/contest/biweekly-contest-83/problems/best-poker-hand/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int n = ranks.length;
        int[] intf = new int[14];
        int[] charf = new int[4];
        
        for(int i=0; i<n; i++){
            intf[ranks[i]]++;
            charf[suits[i]-'a']++;
        }
        
        int val = -1;
        // all same?
        Arrays.sort(suits);
        if(suits[0] == suits[n-1]) val = 1;
        else{
            for(int i : intf){
                if(i>=3){
                    val = 2;
                }
            }
            if(val!=2){
                for(int i : intf){
                    if(i>=2){
                        val = 3;
                    }
                }
            }
        }
        if(val==-1) val = 4;
        
        switch(val){
            case 1: return "Flush";
            case 2: return "Three of a Kind";
            case 3: return "Pair";
            case 4: return "High Card";
        }
        return "" ;  
    }
}
