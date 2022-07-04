//Link: https://www.interviewbit.com/problems/clone-graph/

//Time & Space Complexity: O(N) O(N)

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> oldnew){
        if(oldnew.containsKey(node))
            return oldnew.get(node);
            
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        oldnew.put(node, copy);
        
        for(UndirectedGraphNode n : node.neighbors){
            copy.neighbors.add(clone(n, oldnew));
        }
        
        return copy;
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> oldnew = n1ew HashMap<>();
        
        return clone(node, oldnew);
        
    }
}
