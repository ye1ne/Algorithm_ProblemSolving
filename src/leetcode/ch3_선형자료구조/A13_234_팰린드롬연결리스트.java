package leetcode.ch3_선형자료구조;

import java.util.ArrayDeque;
import java.util.Deque;

public class A13_234_팰린드롬연결리스트 {
     static class ListNode {
         int val;
         ListNode next;
         public ListNode() {}
         public ListNode(int val) { this.val = val; }
         public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {


        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1))));

        Deque<Integer> deque = new ArrayDeque<>();
        while(head.next != null){
            deque.add(head.val);
            head = head.next;

            if(head.next == null) deque.add(head.val);
        }

        while(!deque.isEmpty()){
            int front = deque.pollFirst();
            if(deque.isEmpty()) continue;
            int end = deque.pollLast();
            if(front != end) System.out.println("아님");
        }

        System.out.println("마즁");
   }
}
