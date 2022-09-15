package leetcode.ch3_선형자료구조;

public class A14_21_두정렬리스트의병합 {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        ListNode result = mergeTwoLists(list1,list2);
        System.out.println();
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 ==null || (list2 !=null && list1.val > list2.val)){
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        if(list1 != null){
            list1.next = mergeTwoLists(list1.next,list2);
        }
        return list1;
    }
}
