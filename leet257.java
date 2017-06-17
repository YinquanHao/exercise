public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return new ArrayList();
        }
        if(root.left == null && root.right==null){
            ArrayList temp =  new ArrayList();
            temp.add(Integer.toString(root.val));
            return temp;
        }
        List<String> leftres = binaryTreePaths(root.left);
        List<String> rightres = binaryTreePaths(root.right);
         ArrayList newleft = new ArrayList();
        if(leftres!=null){
            for(int i=0;i<leftres.size();i++){
                String it = leftres.get(i);
                it = Integer.toString(root.val)+"->"+it;
                newleft.add(it);
            }
        }
        ArrayList newright = new ArrayList();
        if(rightres!=null){
            for(int i=0;i<rightres.size();i++){
                String it = rightres.get(i);
                it = Integer.toString(root.val)+"->"+it;
                newright.add(it);
            }
        }
        if(newright.size()!=0&&newleft.size()!=0) {
            newleft.addAll(newright);
            return newleft;
        }
        else if(newright.size()!=0&&newleft.size()==0) {
            return newright;
        }else if(newright.size()==0&&newleft.size()!=0){
            return newleft;
        }else{
            return null;
        }
    }
}