public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        help(root,res,0);
        Collections.reverse(res);
        return res;
    }
    public void help(TreeNode root,List<List<Integer>> res, int level){
        if(root == null){
            return;
        }
        if(level+1>res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        help(root.left,res,level+1);
        help(root.right,res,level+1);
        
    }
}