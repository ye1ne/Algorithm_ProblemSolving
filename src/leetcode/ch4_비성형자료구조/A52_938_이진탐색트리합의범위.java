package leetcode.ch4_비성형자료구조;

public class A52_938_이진탐색트리합의범위 {

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

    static int total,L,H;

    public static void main(String[] args) {
        int[] nums = {3,5,7,10,15,18};
        TreeNode root = sortByBST(nums);
        int low = 7;
        int high = 15;

        L =low;
        H = high;
        total = 0;
        inOrder(root);
        System.out.println(total);


    }

    static void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);
        if(node.val>=L && node.val<=H) total+=node.val;
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
