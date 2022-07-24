//Link: https://practice.geeksforgeeks.org/problems/sum-of-binary-tree/1

//Time & Space Complexity: O(N) O(N)

class BinaryTree
{
    static int dfs(Node root){
        if(root == null) return 0;
        return root.data + dfs(root.left) + dfs(root.right);
    }
    
    static int sumBT(Node head){
        //Code
        int sum = 0;
        if(head == null)
            return 0;
        return dfs(head);
    }
}
