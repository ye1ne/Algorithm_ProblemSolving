package leetcode;

public class A26_641_원형테크디자인 {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(2);
        myCircularDeque.insertFront(7);  // return True
        myCircularDeque.deleteLast();// return True
        int a = myCircularDeque.getFront();
        myCircularDeque.insertLast(5);
        myCircularDeque.insertFront(0);
        myCircularDeque.getFront();
        myCircularDeque.getRear();
        myCircularDeque.getFront();
        myCircularDeque.getFront();
        myCircularDeque.getRear();
        // return 4
    }

    static class MyCircularDeque {
        int size, front, rear;
        int[] arr;
        public MyCircularDeque(int k) {
            this.arr = new int[k];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        public boolean insertFront(int value) {
            if(isFull()) return false;
            if(!isEmpty()) front = (front+arr.length-1)%arr.length;
            arr[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()) return false;
            if(!isEmpty()) rear = (rear+1)%arr.length;
            arr[rear] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) return false;
            front= (front+1)%arr.length;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) return false;
            rear= (rear+arr.length-1)%arr.length;
            size--;
            return true;
        }

        public int getFront() {
            if(isEmpty()) return -1;
            return arr[front];
        }

        public int getRear() {
            if(isEmpty()) return -1;
            return arr[rear];
        }

        public boolean isEmpty() {
            if(size == 0) return true;
            return false;
        }

        public boolean isFull() {
            if(size == arr.length) return true;
            return false;
        }
    }

}
