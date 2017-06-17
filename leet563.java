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
    int res = 0;
    public int findTilt(TreeNode root) {
        postorder(root);
        return res;
        
    }
    public int  postorder(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = postorder(root.left);
        int right = postorder(root.right);
        res+=Math.abs(left-right);
        return left+right+root.val;
    }
}