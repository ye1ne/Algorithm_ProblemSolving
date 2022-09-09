package leetcode.선형자료구조;

public class A16_2_두수의덧셈 {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1,new ListNode(9,new ListNode(9,
                new ListNode(9,new ListNode(9,new ListNode(9,
                        new ListNode(9,new ListNode(9,
                                new ListNode(9,new ListNode(9))))))))));

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();


        while(l1 != null){
            sb1.append(l1.val+"");
            l1 = l1.next;
        }
        while(l2 != null){
            sb2.append(l2.val+"");
            l2 = l2.next;
        }
        String a1 = sb1.reverse().toString();
        String a2 = sb2.reverse().toString();

        String a3 = Long.toString(Long.parseLong(a1)+Long.parseLong(a2));

        ListNode result = new ListNode();
        ListNode result2 = result;
        for(int i=a3.length()-1; i>=0; i--){
            ListNode tmp = new ListNode(a3.charAt(i)-'0');
            result.next = tmp;
            result = result.next;
        }


        System.out.println();
    }


}
