//Link: https://leetcode.com/contest/weekly-contest-304/problems/find-closest-node-to-given-two-nodes/

//Time & Space Complexity: O(NLogN) O(N)

class Node implements Comparator<Node>{
    int node, dist;
    Node(){}
    Node(int n, int d){
        node = n;
        dist = d;
    }
    @Override
    public String toString(){
        return "node: "+node+" maxdist: "+dist;
    }
    @Override
    public int compare(Node n1, Node n2){
        if(n1.dist < n2.dist){
            return -1;
        }else if(n1.dist > n2.dist){
            return 1;
        }else{
            if(n1.node < n2.node){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
class Solution {
    void dfs(int node, int[] vis, int[] dfsvis, int[] adj, int[] bothvis, int[] dist){
        vis[node] = dfsvis[node] = 1;
        bothvis[node]++;
        int to = adj[node];
        if(to!=-1 && dfsvis[to] != 1){ 
            dist[to] = dist[node] + 1;
            dfs(to, vis, dfsvis, adj, bothvis, dist);
        }
        dfsvis[node] = 0;
    }
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] vis = new int[n];
        int[] dfsvis = new int[n];
        int[] bothvis = new int[n];
        int[] distN1 = new int[n];
        int[] distN2 = new int[n];
        dfs(node1, vis, dfsvis, edges, bothvis, distN1);
        vis = new int[n];
        dfsvis = new int[n];
        dfs(node2, vis, dfsvis, edges, bothvis, distN2);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        for(int i=0; i<n; i++){
            if(bothvis[i]>1){
                pq.add(new Node(i, Math.max(distN1[i], distN2[i]) ));
            }
        }
        return pq.isEmpty() ? -1 : pq.poll().node;
    }
}
