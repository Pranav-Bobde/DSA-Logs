//Link: https://www.interviewbit.com/problems/commutable-islands/

//Time & Space Complexity: O(N) O(N)

public class Solution {
    int[] par;
    int[] size;
    
    int findPar(int u){
        if(u == par[u]){
            return u;
        }
        return par[u] = findPar(par[u]);
    }
    
     boolean join(int u, int v){
        int pu = findPar(u);
        int pv = findPar(v);

        if(pu == pv) {
          return false; 
        }

        if(size[pu]>=size[pv]){
            par[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            par[pu] = pv;
            size[pv] += size[pu];
        }
        return true;
    }
    
    public int solve(int n, ArrayList<ArrayList<Integer>> b) {
        par = new int[n+1];
        size = new int[n+1];
        
        for(int i = 1;i <= n;i++){
            par[i] = i;
            size[i] = 1;
        }
    
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new Comparator<ArrayList<Integer>>(){

            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2){
                return o1.get(2) - o2.get(2);
            }
        });

        for(ArrayList<Integer> cur : b) {
          pq.add(cur);
        }

        int ans = 0;
        
        while(!pq.isEmpty()){
            ArrayList<Integer> cur = pq.poll();
            if(join(cur.get(0), cur.get(1))){
                ans = ans + cur.get(2);
            }
        }
        return ans;
    }
}
