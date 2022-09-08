package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A24_232_스택을이용한큐구현 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();// return 1, queue is [2]
        boolean test = myQueue.empty(); // return false
        System.out.println();
    }

    static class MyQueue {

        static Stack<Integer> stack1 = new Stack<>();
        static Stack<Integer> stack2 = new Stack<>();
        public MyQueue() {

        }

        public void push(int x) {
            if(stack2.isEmpty()) stack2.push(x);
            else stack1.push(x);
        }

        public int pop() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()) stack2.add(stack1.pop());
                int result = stack2.pop();
                while(!stack2.isEmpty()) stack1.add(stack2.pop());
                return result;
            }else{
                while(!stack2.isEmpty()) stack1.add(stack2.pop());
                int result = stack1.pop();
                while(!stack1.isEmpty()) stack2.add(stack1.pop());
                return result;
            }
        }

        public int peek() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()) stack2.add(stack1.pop());
                int result = stack2.peek();
                while(!stack2.isEmpty()) stack1.add(stack2.pop());
                return result;
            }else{
                while(!stack2.isEmpty()) stack1.add(stack2.pop());
                int result = stack1.peek();
                while(!stack1.isEmpty()) stack2.add(stack1.pop());
                return result;
            }
        }

        public boolean empty() {
            if(stack1.isEmpty() && stack2.isEmpty()) return true;
            return false;
        }
    }

}
