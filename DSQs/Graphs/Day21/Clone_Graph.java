//Link: https://leetcode.com/problems/clone-graph/


//Time & Space Complexity: O(N2) O(N) - Brute Force

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node s) {
        if(s==null) return s;
        TreeMap<Integer, ArrayList<Integer>> adj = new TreeMap<Integer, ArrayList<Integer>>();
        Set<Integer> vis = new HashSet<>();
        dfs(s, vis, adj);
        TreeMap<Integer, Node> map = new TreeMap<Integer, Node>();
        
        for(Map.Entry<Integer, ArrayList<Integer>> e : adj.entrySet()){
            Node node = null;
            if(map.get(e.getKey()) == null){
                node = new Node(e.getKey());
                map.put(e.getKey(), node);
            }
            node = map.get(e.getKey());
            for(int i : e.getValue()){
                if(map.get(i) == null){
                    Node temp = new Node(i);
                    map.put(i, temp);
                    node.neighbors.add(temp);
                }else{
                    node.neighbors.add(map.get(i));
                }
            }
        }
        
        return map.get(1);
    }
    
    void dfs(Node node, Set<Integer> vis, TreeMap<Integer, ArrayList<Integer>> adj){
        int val = node.val;
        vis.add(val);
        
        if(adj.get(val)==null)
            adj.put(val, new ArrayList<Integer>());
            
        for(Node e : node.neighbors)
                adj.get(val).add(e.val);
        
        for(Node n : node.neighbors)
            if(!vis.contains(n.val))
                dfs(n, vis, adj);
    }
}
