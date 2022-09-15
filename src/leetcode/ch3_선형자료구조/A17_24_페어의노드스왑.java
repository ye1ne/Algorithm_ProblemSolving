package leetcode.ch3_선형자료구조;

public class A17_24_페어의노드스왑 {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4))));

        ListNode root = new ListNode(-1,head);
        ListNode prev = new ListNode(-1,head);


        while(head != null && head.next != null){

            ListNode second = head.next;
            head.next = second.next;
            second.next = head;

            if(prev.next == root.next) root.next = second;
            prev.next =second;

            head = head.next;
            prev = prev.next.next;

        }

        System.out.println();
    }


}
