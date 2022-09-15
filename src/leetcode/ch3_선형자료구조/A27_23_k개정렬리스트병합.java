package leetcode.ch3_선형자료구조;

import java.util.PriorityQueue;

public class A27_23_k개정렬리스트병합 {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

        ListNode[] lists = new ListNode[1];
/*        lists[0] = new ListNode(1,new ListNode(4,new ListNode(5)));
        lists[1] = new ListNode(1,new ListNode(3,new ListNode(4)));
        lists[2] = new ListNode(2,new ListNode(6));*/
        lists[0] = new ListNode();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<lists.length; i++){
            ListNode tmp = lists[i];
            while(tmp != null){
                queue.add(tmp.val);
                tmp = tmp.next;
            }
        }
        if(queue.isEmpty()) System.out.println("no");
        ListNode result = new ListNode(queue.poll());
        ListNode head = result;
        while(!queue.isEmpty()){
            result.next = new ListNode(queue.poll());
            result = result.next;
        }

        System.out.println();
    }
}
