package leetcode.ch4_비성형자료구조;

public class A51_1038_이진탐색트리를더큰수합계트리로 {

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

    static int total;

    public static void main(String[] args) {
        int[] nums = {3,5,7,10,15,18};
        TreeNode root = sortByBST(nums);

        total = 0;
        TreeNode node = inOrder(root);
        System.out.println();


    }

    static TreeNode inOrder(TreeNode node){
        if(node == null) return null;



        TreeNode right = inOrder(node.right);
        total+= node.val;
        System.out.println(node.val +" "+ total);
        node.val = total;
        TreeNode left= inOrder(node.left);

        return new TreeNode(node.val,left,right);
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
