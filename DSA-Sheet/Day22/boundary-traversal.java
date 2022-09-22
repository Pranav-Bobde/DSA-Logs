//Link: https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

//Time & Space: O(N) O(N)

public class Solution {
    public static boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null) return true;
        return false;
    }
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static void addLeft(TreeNode root){
        if(root == null) return;
        if(!isLeaf(root)) ans.add(root.data);
        if(root.left!=null)
            addLeft(root.left);
        else
            addLeft(root.right);
    }
    public static void addLeaf(TreeNode root){
        if(root==null) return;
        if(isLeaf(root)) ans.add(root.data);
        addLeaf(root.left);
        addLeaf(root.right);
    }
    public static void addRight(TreeNode root){
        if(root==null) return;
        if(root.right!=null)
            addRight(root.right);
        else
            addRight(root.left);
        if(!isLeaf(root)) ans.add(root.data);
    }
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
        if(!isLeaf(root)) ans.add(root.data);
        addLeft(root.left);
        addLeaf(root);
        addRight(root.right);
        ArrayList<Integer> al = new ArrayList<>(ans);
        ans = new ArrayList<>();
        return al;
	}
}
