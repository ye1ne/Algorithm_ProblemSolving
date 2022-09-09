package leetcode.선형자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A23_225_큐를이용한스택구현 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        boolean empty = myStack.empty(); // return False

        System.out.println();
    }

    static class MyStack {

        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();
        public MyStack() {
        }

        public void push(int x) {
            if(queue1.isEmpty()) queue2.offer(x);
            else if(queue2.isEmpty()) queue1.offer(x);
        }

        public int pop() {
            if(queue1.isEmpty()){
                while(queue2.size() > 1) queue1.offer(queue2.poll());
                return  queue2.poll();
            }
            else {
                while(queue1.size() > 1) queue2.offer(queue1.poll());
                return  queue1.poll();
            }
        }

        public int top() {
            if(queue1.isEmpty()){
                while(queue2.size() > 1) queue1.offer(queue2.poll());
                int tmp = queue2.poll();
                queue1.offer(tmp);
                return  tmp;
            }
            else {
                while(queue1.size() > 1) queue2.offer(queue1.poll());
                int tmp = queue1.poll();
                queue2.offer(tmp);
                return  tmp;
            }
        }

        public boolean empty() {
            if(queue1.size() ==0 && queue2.size() == 0) return true;
            return false;
        }
    }
}
