//Link: https://practice.geeksforgeeks.org/problems/level-order-traversal/1

//Time & Space Complexity: O(N) O(N)

class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node node) 
    {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>();
        if(node == null) return al;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node t = q.poll();
            al.add(t.data);
            if(t.left!=null) q.add(t.left);
            if(t.right!=null) q.add(t.right);
        }
        
        return al;
    }
}
