package leetcode.ch4_비선형자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A47_297_이진트리직렬화와역렬화X {

    static class TreeNode{
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

         TreeNode root = new TreeNode(1,new TreeNode(2,null,null),new TreeNode(3,new TreeNode(4),new TreeNode(5)));
//       TreeNode root = new TreeNode(1,null,new TreeNode(2));
        String str = serialize(root);
        TreeNode ans = deserialize(serialize(root));
        System.out.println();
    }
    static String serialize(TreeNode root) {

        if(root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append("[");
        int count = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null) {
                sb.append("null,");
                count++;
                continue;
            }
            else sb.append(node.val+",");
            queue.add(node.left);
            queue.add(node.right);
            count = 0;

        }

        sb.delete(sb.length()-1-5*count,sb.length());
        sb.append("]");
        return sb.toString();
    }
    static TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String str = data.substring(1,data.length()-1);
        StringTokenizer st = new StringTokenizer(str,",");

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(st.nextToken()));
        queue.add(root);
        while(!queue.isEmpty()){

            TreeNode node = queue.poll();

            if(!st.hasMoreTokens()) break;
            String left = st.nextToken();
            node.left = left.equals("null") ? null : new TreeNode(Integer.parseInt(left));
            queue.add(node.left);

            if(!st.hasMoreTokens()) break;
            String right = st.nextToken();
            node.right = right.equals("null") ? null : new TreeNode(Integer.parseInt(right));
            queue.add(node.right);


        }
        return root;
    }

}
