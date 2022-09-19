package Programmers.KAKAO2019RECRUITMENT;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 길찾기게임 {


    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        solution(nodeinfo);
    }

    static public int[][] solution(int[][] nodeinfo) {
        int[][] nodeArr = new int[nodeinfo.length][3];
        for(int i=0; i<nodeinfo.length; i++){
            nodeArr[i][0] = nodeinfo[i][0];
            nodeArr[i][1] = nodeinfo[i][1];
            nodeArr[i][2] = i+1;
        }
        Arrays.sort(nodeArr,(a,b)->(a[0]-b[0]));

        Node tree = sortByBST(nodeArr);
        preorders = new ArrayList<>();
        postorders = new ArrayList<>();
        preorder(tree);
        postorder(tree);

        int[][] answer = {preorders.stream().mapToInt(i->i).toArray(),
                postorders.stream().mapToInt(i->i).toArray()};
        return answer;
    }
    static List<Integer> preorders, postorders;
    //전위순회
    static void preorder(Node node){
        if(node == null) return;
        preorders.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }
    //후위순회
    static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        postorders.add(node.val);
    }
    static Node sortByBST(int[][] arr){
        if(arr.length == 0)
            return null;

        int midIndex = -1;
        int maxHeight = -1;
        //중간노드
        for(int i = 0; i<arr.length; i++){
            int[] a = arr[i];
            if(a[1]>maxHeight){
                midIndex = i;
                maxHeight = a[1];
            }
        }

        int[][] left = Arrays.copyOfRange(arr,0,midIndex);
        int[][] right = Arrays.copyOfRange(arr,midIndex+1,arr.length);


        Node leftNode = sortByBST(left);
        Node rightNode=  sortByBST(right);

        return new Node(arr[midIndex][2],leftNode,rightNode);
    }
    static class Node {
        int val;
        Node left;
        Node right;

        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
