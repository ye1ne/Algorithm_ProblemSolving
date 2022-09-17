package leetcode.ch4_비성형자료구조;

import java.util.Arrays;

public class A54_105_전위중위순회결과로이진트리구축 {

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
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        preArr = preorder;
        TreeNode root = buildTrees(inorder);
        System.out.println();
    }


    static int[] preArr;

    static TreeNode buildTrees(int[] inArr){

        if(inArr.length == 0) return null;
        if(preArr.length == 0)
            System.out.println();
        int index = 0;
        for(int i=0 ;i<inArr.length; i++){
            if(inArr[i] == preArr[0]){
                index = i;
                break;
            }
        }

        preArr = Arrays.copyOfRange(preArr,1,preArr.length);


        TreeNode node = new TreeNode(inArr[index]);
        node.left = buildTrees(Arrays.copyOfRange(inArr,0,index));
        node.right = buildTrees(Arrays.copyOfRange(inArr,index+1,inArr.length));

        return node;
    }


}
