package Programmers.KAKAO2022RECRUITMENT;

import Study.BJ_G22856;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 양과늑대 {
    static class Node {
        int animal, num;
        Node left, right;

        public Node(int animal, int num) {
            this.animal = animal;
            this.num = num;
        }
    }
    static int MAX = Integer.MIN_VALUE;
    static boolean[] visit;

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}
                , {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        Node[] nodes = new Node[info.length];
        visit = new boolean[info.length];
        for (int i = 0; i < info.length; i++) {
            nodes[i] = new Node(info[i], i);
        }

        for (int i = 0; i < edges.length; i++) {
            int parents = edges[i][0];
            int child = edges[i][1];
            if (nodes[parents].left == null) nodes[parents].left = nodes[child];
            else nodes[parents].right = nodes[child];
        }

        backTracking(0,0,nodes[0]);
        System.out.println();


    }


    static void backTracking(int countSheep, int countWolf,Node node){
        if(countSheep <countWolf){
            MAX = Math.max(MAX, countSheep);
            return;
        }
        if(node.right == null && node.left == null){
            return;
        }
        if(node.left.animal == 0) backTracking(countSheep+1,countWolf,node);
        else backTracking(countSheep,countWolf+1,node);

        if(node.right.animal == 0) backTracking(countSheep+1,countWolf,node);
        else backTracking(countSheep,countWolf+1,node);



    }

}


