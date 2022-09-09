package leetcode.선형자료구조;

import javax.swing.*;

public class A19_92_역순연결리스트2 {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
//        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(3,new ListNode(5));
        int left = 2;
        int right = 4;

        if(head.next == null) return;
        ListNode root = new ListNode(-1,head);
        head = root;
        while(left-->1){
            head = head.next;
            right--;
        }
        ListNode reverseList = head.next;
        ListNode end = reverseList;
        head.next= null;
        while(right-->1){
            end = end.next;
        }
        ListNode lastList = end.next;
        end.next = null;
        ListNode result =reverse(reverseList);

        head.next = result;
        while(result.next != null) result = result.next;
        result.next = lastList;
        System.out.println();

    }
    static ListNode reverse(ListNode head) {
        if(head.next == null) return head;
        ListNode result = reverse(head.next);
        ListNode resultEnd = result;
        while(resultEnd.next != null) resultEnd = resultEnd.next;
        resultEnd.next = head;
        resultEnd.next.next = null;

        return result;
    }
}
