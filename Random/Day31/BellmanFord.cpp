//Link: https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1#

//Time & Space Complexity: O(VE) O(V)

class Solution {
public:
	int isNegativeWeightCycle(int n, vector<vector<int>>edges){
	    int m = edges.size();
      int inf = 10000000; 
      vector<int> dist(n, inf); 
      dist[0] = 0; 
      for(int j = 0; j<n-1; j++){
      for(int i = 0;i<m;i++) {
        if(dist[edges[i][0]] + edges[i][2] < dist[edges[i][1]]) {
            dist[edges[i][1]] = dist[edges[i][0]] + edges[i][2]; 
        }
      }
    } 
    
    for(int i = 0;i<m;i++) {
      if(dist[edges[i][0]] + edges[i][2] < dist[edges[i][1]]) {
         return 1;
      }
    }
    return 0;
	}
};
