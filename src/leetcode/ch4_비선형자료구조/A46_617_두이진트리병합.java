package leetcode.ch4_비선형자료구조;

public class A46_617_두이진트리병합 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1,new TreeNode(4,new TreeNode(4),new TreeNode(4)),new TreeNode(5,null,new TreeNode(5)));

        TreeNode root1 = new TreeNode(1,new TreeNode(3,new TreeNode(5),null),new TreeNode(2,null,null));
        TreeNode root2 = new TreeNode(2,new TreeNode(1,null,new TreeNode(4)),new TreeNode(3,null,new TreeNode(7)));


        TreeNode node = dfs(root1,root2);

        System.out.println();


    }

    static TreeNode dfs(TreeNode node1,TreeNode node2){

        if(node1 == null && node2 == null){
            return  null;
        }
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }

        TreeNode left = dfs(node1.left,node2.left);
        TreeNode right = dfs(node1.right,node2.right);

        TreeNode node = new TreeNode(node1.val+node2.val,left,right);
        return node;
    }
}
