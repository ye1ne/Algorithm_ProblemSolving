package leetcode.ch4_비성형자료구조;

public class A43_543_이진트리의직경 {
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
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3));

        dfs(root);

        System.out.println(longest);

    }
    static int longest;
    static int dfs(TreeNode node){
        if(node == null){
            return -1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        longest = Math.max(longest,left+right+2);
        return Math.max(left,right)+1;
    }

}
