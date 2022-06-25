//Link: 

//Time & Space Complexity: O(N) O(N)
//Optimised Space a bit
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n==1) return 1;
        int[] count = new int[n+1];
        
        for(int[] arr : trust){
            count[arr[1]]++;
            count[arr[0]]--;
        }
        
        int ans = -1;
        for(int i=0; i<n+1; i++){
            if(count[i] == n-1)
            {
                ans = i;
                break;
            }
        }
            
        return ans;
    }
}

//Time & Space Complexity: O(N) O(N)
//Optimised Time
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n==1) return 1;
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];
        
        for(int[] arr : trust){
            indegree[arr[1]]++;
            outdegree[arr[0]]++;
        }
        
        int ans = -1;
        for(int i=0; i<n+1; i++){
            if(indegree[i] == n-1 && outdegree[i]==0)
            {
                ans = i;
                break;
            }
        }
            
        return ans;
    }
}

//Time & Space Complexity: O(N2) O(N)
//Brute Force
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n==1) return 1;
        int[] indegree = new int[n+1];
        for(int[] arr : trust){
            indegree[arr[1]]++;
        }
        int ans = -1;
        for(int i=0; i<n+1; i++){
            if(indegree[i] == n-1 && checkTrust(i, trust))
            {
                ans = i;
                break;
            }
        }
            
        return ans;
    }
    
    boolean checkTrust(int i, int[][] t){
        for(int[] arr : t){
            if(arr[0] == i)
                return false;
        }
        return true;
    }
}
