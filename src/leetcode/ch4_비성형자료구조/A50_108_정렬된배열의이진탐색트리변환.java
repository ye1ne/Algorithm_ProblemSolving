package leetcode.ch4_비성형자료구조;

public class A50_108_정렬된배열의이진탐색트리변환 {

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
        int[] nums = {-10,1};

        TreeNode root = sortByBST(nums);

        System.out.println();


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
