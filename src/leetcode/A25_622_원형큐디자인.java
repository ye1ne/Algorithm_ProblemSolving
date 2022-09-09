package leetcode;

import java.util.Queue;

public class A25_622_원형큐디자인 {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        boolean isOK = myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4
    }

    static class MyCircularQueue {

        static int front, rear,size;
        static int[] arr;
        public MyCircularQueue(int k) {
            this.front =0;
            this.rear = k-1;
            this.size = 0;
            this.arr = new int[k];
        }
        public boolean enQueue(int value) {
            if(isFull()) return false;
            rear = (rear+1)%arr.length;
            arr[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;
            front = (front+1)%arr.length;
            size--;
            return true;
        }

        public int Front() {
            if(isEmpty()) return -1;
            return arr[front];
        }

        public int Rear() {
            if(isEmpty()) return -1;
            return  arr[rear];
        }

        public boolean isEmpty() {
            if(size == 0) return true;
            else return false;
        }

        public boolean isFull() {
            if(size == arr.length) return true;
            else return false;
        }

    }
}
