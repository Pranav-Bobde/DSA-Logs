//Link: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

//Time & Space: O(N) O(N)

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class Noode {
        Node node;
        int val;
        Noode(Node n, int i){
            node = n;
            val = i;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Noode> q = new LinkedList<>();
        q.add(new Noode(root, 0));
        while(!q.isEmpty()){
            Noode noode = q.poll();
            Node node = noode.node;
            int val = noode.val;
            if(!map.containsKey(val)){
                map.put(val, node.data);
            }
            if(node!=null){
                if(node.left!=null){
                    q.add(new Noode(node.left, val-1));
                }
                if(node.right!=null){
                    q.add(new Noode(node.right, val+1));
                }
            }
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}
