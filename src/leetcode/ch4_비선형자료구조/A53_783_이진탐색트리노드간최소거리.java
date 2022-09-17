package leetcode.ch4_비선형자료구조;

public class A53_783_이진탐색트리노드간최소거리 {

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
        int[] nums = {1,2,3,4,6};
        TreeNode root = sortByBST(nums);


        min = Integer.MAX_VALUE;
        priv = Integer.MIN_VALUE;


        inOrder(root);

        System.out.println(min);
    }


    static int priv, min;
    static void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        if(priv != Integer.MIN_VALUE) min = Math.min(node.val-priv,min);
        priv = node.val;
        inOrder(node.right);
    }

    static TreeNode sortByBST(int[] arr){
        if(arr.length == 0)
            return null;

        int[] arr2 = {-10};
        if(arr[0] == arr2[0] && arr.length== arr2.length)
            System.out.println();
        int mid = arr.length/2;

        int[] left = new int[mid];
        int[] right = new int[arr.length-mid-1];

        for(int i=0; i<mid; i++) left[i] = arr[i];
        for(int i=mid+1; i<arr.length; i++) right[i-(mid+1)] = arr[i];
        TreeNode leftNode = sortByBST(left);
        TreeNode rightNode=  sortByBST(right);

        return new TreeNode(arr[mid],leftNode,rightNode);
    }
}
