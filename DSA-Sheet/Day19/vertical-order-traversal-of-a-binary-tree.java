//Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

//Time & Space: O(N) O(N)

class Tuple {
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;


            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ());
            }
            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}


//Link: https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1

//Time & Space: O(N) O(N)

class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static class Noode{
        Node node;
        int d;
        Noode(Node n, int depth){
            node = n;
            d = depth;
        }
    }
    static ArrayList <Integer> verticalOrder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root==null) return ans;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Noode> q = new LinkedList<>();
        q.add(new Noode(root, 0));
        while(!q.isEmpty()){
            Noode n = q.poll();
            Node node = n.node;
            int i = n.d;
            if(map.get(i)==null){
                map.put(i, new ArrayList<Integer>());   
            }
            map.get(i).add(node.data);
            if(node.left!=null){
                q.add(new Noode(node.left, i-1));
            }
            if(node.right!=null){
                q.add(new Noode(node.right, i+1));
            }
        }
        for(Map.Entry<Integer, List<Integer>> e : map.entrySet()){
            ans.addAll(e.getValue());
        }
        return ans;
    }
}
