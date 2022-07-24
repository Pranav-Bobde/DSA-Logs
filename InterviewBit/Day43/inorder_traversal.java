//Link: https://practice.geeksforgeeks.org/problems/inorder-traversal/1

//Time & Space Complexity: O(N) O(N)

class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    
    void dfs(ArrayList<Integer> al, Node root){
        if(root==null)
            return;
        dfs(al, root.left);
        al.add(root.data);
        dfs(al, root.right);
    }
    
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> al = new ArrayList<>();
        dfs(al, root);
        return al;
    }
}
