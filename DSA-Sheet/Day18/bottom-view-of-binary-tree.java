//Link: https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

//Time & Space: O(N) O(N)

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    static class Noode {
        Node node;
        int val;
        Noode(Node n, int i){
            node = n;
            val = i;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Noode> q = new LinkedList<>();
        q.add(new Noode(root, 0));
        while(!q.isEmpty()){
            Noode noode = q.poll();
            Node node = noode.node;
            int val = noode.val;
            map.put(val, node.data);
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
