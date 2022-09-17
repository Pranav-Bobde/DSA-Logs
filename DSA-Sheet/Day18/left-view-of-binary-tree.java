//Link: https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

//Time & Space: O() O()

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    void dfs(Node root, int i){
        if(root == null){
            return;
        }
        if(!map.containsKey(i)){
            map.put(i, root.data);
            ans.add(root.data);
        }
        dfs(root.left, i+1);
        dfs(root.right, i+1);
    }
    ArrayList<Integer> leftView(Node root)
    {
        dfs(root, 0);
        return ans;
    }
}
