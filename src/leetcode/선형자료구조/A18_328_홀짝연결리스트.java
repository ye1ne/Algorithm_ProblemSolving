package leetcode.선형자료구조;

import java.util.List;

public class A18_328_홀짝연결리스트 {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4))));

        ListNode prev = new ListNode(-1,head);
        ListNode oddRoot = new ListNode(-1);
        ListNode evenRoot  = new ListNode(-1);
        ListNode odd = oddRoot;
        ListNode even = evenRoot;
        int count = 0;
        while(head != null ){

            if(count%2 != 0) {
                odd.next = head;
                prev.next = head.next;
                odd.next.next = null;
                odd = odd.next;
            }else{
                even.next = head;
                prev.next = head.next;
                even.next.next = null;
                even = even.next;
            }

            head = prev.next;
            count++;
        }

        even.next = oddRoot.next;

        System.out.println();
    }


}
