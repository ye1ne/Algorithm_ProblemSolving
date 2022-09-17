package leetcode.ch4_비선형자료구조;

public class A44_687_가장긴동일값의경로 {
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

        TreeNode root = new TreeNode(1,new TreeNode(1,new TreeNode(1),new TreeNode(1)),new TreeNode(1,null,new TreeNode(1)));
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

        if(node.right!= null && node.right.val == node.val) right++;
        else right = 0;

        if(node.left != null && node.left.val == node.val ) left++;
        else left = 0;

        longest = Math.max(right+left,longest);
        return Math.max(left,right);

    }
}
