package Programmers.Backend2021;


import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class Brush {

    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        list.add(new Node("center"));

        for(int i=0; i<enroll.length;i++){
            list.add(new Node(enroll[i]));
            if(referral[i].equals("-")) list.get(i+1).parentNode = list.get(0);

            else list.get(i+1).parentNode = list.get(list.indexOf(findNodeByName(referral[i])));

        }
        for(int i=0; i<seller.length; i++){
            Node node = list.get(list.indexOf(findNodeByName(seller[i])));
            giveMoney(node, amount[i]*100);
        }
        int[] result = new int[referral.length];
        int count =0;
        for(Node node: list ){
            if(node == findNodeByName("center")) continue;
            result[count++] = node.number;
        }
    }

    static void giveMoney(Node node, int amonut) {
        if(node.parentNode == null){
            node.number += amonut;
            return;
        }

        if(amonut*0.1<1){
            node.number += amonut;
            return;
        }

        int mine= amonut -  (int) (amonut * 0.1);
        node.number += mine;
        giveMoney(node.parentNode,amonut-mine);
    }

    static Node findNodeByName(String name){
        for(Node node: list){
            if(node.name.equals(name)) return  node;
        }
        return null;
    }

    static class Node{
        String name;
        int number;
        Node parentNode;

        public Node(String name) {
            this.name = name;
        }
    }
}
