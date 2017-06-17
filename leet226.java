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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode p = root;
        TreeNode l = root.left;
        TreeNode r = root.right;
        invertTree(l);
        invertTree(r);
        root.left = r;
        root.right = l;
        return p;
    }
}