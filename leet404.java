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
    public int sumOfLeftLeaves(TreeNode root) { 
        int res = 0;
        if(root==null){
            return 0;
        }
        if(root.left!=null){
            if(root.left.left ==null && root.left.right==null){
                res+= root.left.val;
            }else{
                res+=sumOfLeftLeaves(root.left);
            }
        }
        res+=sumOfLeftLeaves(root.right);
        return res;
    }
}