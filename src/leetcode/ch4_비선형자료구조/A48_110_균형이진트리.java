package leetcode.ch4_비선형자료구조;

public class A48_110_균형이진트리 {
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

        TreeNode root1 = new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode root2 = new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4),new TreeNode(4)),new TreeNode(3)),new TreeNode(2));


        TreeNode root = new TreeNode();
        isBalanced = true;

        dfs(root2);
        System.out.println(isBalanced);


    }

    static boolean isBalanced;
    static int dfs(TreeNode node){

        if(node == null) return -1;

        int left = dfs(node.left);
        int right = dfs(node.right);

        if(Math.abs(left-right)>1) isBalanced =false;

        return Math.max(left,right)+1;
    }
}
