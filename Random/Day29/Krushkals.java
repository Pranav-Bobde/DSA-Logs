//Link: https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1#

//Time & Space Complexity: O(NLogN) O(N)

class Solution
{
    static class Node implements Comparator<Node>{
        int u;
        int v;
        int w;
        Node(){};
        Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compare(Node n1, Node n2){
            if(n1.w < n2.w){
                return -1;
            }else if(n1.w  > n2.w){
                return 1;
            }else{
                return 0;
            }
        }
    }
    
    static class UnionFind{
        int[] parent;
        int[] rank;
        UnionFind(int n){
            rank = new int[n];
            parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }
        
        void union(int u, int v){
            int pu = findPar(u);
            int pv = findPar(v);
            
            if(pu == pv) return;
            
            if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }else if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }else{
                parent[pu] = pv;
                rank[pv]++;
            }
        }
        
        int findPar(int node){
            if(parent[node] == node){
                return node;
            }
            int temp = findPar(parent[node]);
            parent[node] = temp;
            return temp;
        }
    }
    
    
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        for(int i=0; i<adj.size(); i++){
            for(ArrayList<Integer> al : adj.get(i)){
                pq.add(new Node(i, al.get(0), al.get(1)));
            }
        }
        int cost = 0;
        UnionFind uf = new UnionFind(adj.size());
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int u = node.u;
            int v = node.v;
            int w = node.w;
            
            int p1 = uf.findPar(u);
            int p2 = uf.findPar(v);
            
            if(p1 != p2){
                cost+=w;
                uf.union(u, v);
            }
        }
        return cost;
    }
}
