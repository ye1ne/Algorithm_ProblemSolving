package leetcode;

import Study.BJ_G22856;

import java.util.Stack;

public class A15_206_역순연결리스트 {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode node= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));

        ListNode result = reverse(node.next, new ListNode(node.val));
        System.out.println();
    }

    static ListNode reverse(ListNode node, ListNode prev){
        if( node == null) return prev;
        ListNode next = node.next;
        node.next = prev;
        return reverse(next,node);
    }
}
