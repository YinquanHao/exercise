/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        help(root);
        return res;
    }
    public int help(TreeNode root){
        if(root == null){
            return 0;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int leftDepth = help(root.left);
        int rightDepth = help(root.right);
        if(Math.abs(leftDepth-rightDepth)>1){
            res = false;
        }
        return Math.max(leftDepth,rightDepth)+1;
    }
}