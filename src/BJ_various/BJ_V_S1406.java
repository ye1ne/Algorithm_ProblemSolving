package BJ_various;

import java.io.*;

class Linkedlist{
    class Node{
        char data;
        Node next;
        public Node(char c) {
            data = c;
            next = null;
        }
    }
    private Node head;
    private Node tail;
    public int currentSize;
    public Linkedlist(String str){
        char[] A = str.toCharArray();
        Node node = new Node(A[0]);
        head = tail = node;
        currentSize = 1;
        for(int i=1;i<A.length;i++){
            node = new Node(A[i]);
            tail.next = node;
            tail = node;
            currentSize++;
        }
    }
    public void addChar(int index,char input){
        Node current = head;
        Node tmp = null;
        Node node = new Node(input);
        if(head == null){
            head = tail = node;
            currentSize++;
            return;
        }
        if(index == currentSize){
            tail.next = node;
            tail = node;
            currentSize++;
            return;
        }if(index == 0){
            node.next = head;
            head = node;
            currentSize++;
            return;
        }
        for(int i =1; i< index; i++){
            current = current.next;
        }
        tmp = current.next;
        current.next = node;
        node.next = tmp;
        currentSize++;
    }
    public void removeLeft(int index){
        Node current = head;
        Node previous = null;
        if(index == 0) return;
        for(int i =1; i<index; i++){
            previous = current;
            current = current.next;
        }
        if(current == tail && current == head){
            head = tail = null;
        }else if(current == tail){
            previous.next = null;
            tail = previous;
        }else if(current == head){
            head = current.next;
            current.next = null;
        }else{
            previous.next = current.next;
        }
        currentSize--;
    }
    public void printLinkedList() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node current = head;
        for(int i =0; i<currentSize;i++){
            bw.write(current.data);
            current = current.next;
        }
        bw.flush();
        bw.close();
    }

}
public class BJ_V_S1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Linkedlist list = new Linkedlist(str);
        int M = Integer.parseInt(br.readLine());
        int cursor = list.currentSize;
        String input;
        for(int i =0; i<M; i++){
            input = br.readLine();
            if(input.equals("L")&&cursor!=0){
                cursor--; continue;
            }else if(input.equals("D")&&cursor!=(list.currentSize)){
                cursor++; continue;
            }else if(input.equals("B")&&cursor!=0){
                list.removeLeft(cursor);
                cursor--; continue;
            }else if(input.charAt(0)=='P'){
                list.addChar(cursor,input.charAt(2));
                cursor ++;
            }

        }
        list.printLinkedList();
    }
}
