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
    public int res = 0;
    public int longestConsecutive(TreeNode root) {
        longestConsecutivehelp(root);
        return res;
    }
    public int longestConsecutivehelp(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftlength = longestConsecutivehelp(root.left);
        int rightlength = longestConsecutivehelp(root.right);
        if(root.left!=null&&root.left.val == (root.val+1)){
            leftlength++;
        }else{
            leftlength = 1;
        }
        if(root.right!=null&&root.right.val == (root.val+1)){
            rightlength++;
        }else{
            rightlength = 1;
        }
        int length =  Math.max(leftlength,rightlength);
        res = Math.max(res,length);
        return length;
    }
}