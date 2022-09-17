package leetcode.ch4_비성형자료구조;

public class A45_226_이진트리반전 {
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

        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7,new TreeNode(6),new TreeNode(9)));

        root = dfs(root);
        System.out.println();
        
    }

    static TreeNode dfs(TreeNode node){
        if(node == null) return null;

        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);

        node.left = right;
        node.right = left;
        return node;
    }
}
