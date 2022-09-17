package leetcode.ch4_비선형자료구조;

import java.util.LinkedList;
import java.util.Queue;

public class A42_104_이진트리의최대깊이 {
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
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));

        Queue<TreeNode> queue=  new LinkedList<>();

        int depth = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            depth++;
            int curLength = queue.size();
            while(curLength-->0){
                TreeNode tmp = queue.poll();
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
        }

        System.out.println(depth);
    }
}
