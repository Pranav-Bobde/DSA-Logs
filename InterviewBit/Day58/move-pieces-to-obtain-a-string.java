//Link: https://leetcode.com/contest/weekly-contest-301/problems/move-pieces-to-obtain-a-string/

//Time & Space Complexity: O(N) O(N)

class Solution {
    public boolean canChange(String start, String target) {
        if(start.length() != target.length()) return false;
        
        int idxS = 0, idxT = 0;
        while(idxS<start.length() || idxT<target.length()){
            while( idxS<start.length() && start.charAt(idxS) == '_' ) idxS++;
            while( idxT<target.length() && target.charAt(idxT) == '_' ) idxT++;
            
            if(idxS==start.length() && idxT==target.length())
                return true;
            
            if( idxS==start.length() || idxT==target.length() || start.charAt(idxS)!=target.charAt(idxT) ) return false;
            
            
            if(idxS<start.length() && idxT<target.length() && start.charAt(idxS)==target.charAt(idxT)){
                if(start.charAt(idxS)=='L' && idxS < idxT) return false;
                if(target.charAt(idxT)=='R' && idxS > idxT) return false;
            }
            
            idxS++;
            idxT++;
        }
        return true;
    }
}
