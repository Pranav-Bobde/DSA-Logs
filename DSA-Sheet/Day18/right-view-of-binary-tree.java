//Link: https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1

//Time & Space: O(N) O()

class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> map = new TreeMap<>();
    void dfs(Node root, int i){
        if(root == null){
            return;
        }
        map.put(i, root.data);
        dfs(root.left, i+1);
        dfs(root.right, i+1);
    }
    ArrayList<Integer> rightView(Node root)
    {
        dfs(root, 0);
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}
