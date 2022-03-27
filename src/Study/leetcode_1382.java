package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class leetcode_1382 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            inOrderList.add(node.val);
            inOrder(node.right);
        }
    }
    static List<Integer> inOrderList = new ArrayList<>();
    static TreeNode drawBTree(int min, int max){
        if(min>max) return null;

        int mid = min + (max-min)/2;
        TreeNode root = new TreeNode(inOrderList.get(mid));

        root.left = drawBTree(min,mid-1);
        root.right =drawBTree(mid+1,max);

        return root;

    }

    public static void main(String[] args) throws IOException{
        TreeNode tmp3 = new TreeNode(3);
        TreeNode tmp2 = new TreeNode(1);
        TreeNode root = new TreeNode(2,tmp2,tmp3);

        inOrder(root);
        TreeNode result = drawBTree(0,inOrderList.size()-1);
        System.out.println();
    }

}