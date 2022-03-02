package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G22856 {
    public static class Node{
        int left, right, cur;
        int head = -1;
        private Node(int cur, int left, int right){
            this.cur = cur;
            this.left = left;
            this.right = right;
        }
        void setHead(int head){
            this.head = head;
        }
    }
    static Node[] list;
    static Stack<Node> s = new Stack<>();
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new Node[N+1];
        for(int i=1;i<=N;i++) list[i] = new Node(i,0,0);

        for(int i=0; i<N;i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int c = Integer.parseInt(st.nextToken());
           list[a].left = b; list[a].right = c;

           if(b!=-1) {list[b].setHead(a);}
           if(c!=-1) {list[c].setHead(a);}
        }
        int p=0;
        boolean[] isVisit = new boolean[N+1];
        for(int i=1; i<N+1; i++){ if(list[i].head == -1){p = i;break;}}
        isVisit[p] = true;
        s.push(list[p]);
        int count =-1;

        while(!s.isEmpty()){
            Node node = s.pop();
            isVisit[node.cur] = true;
            count++;
            if(node.right !=-1 && !isVisit[node.right]){
                if(node.left == -1 || !isVisit[node.left]) {
                    if(!s.isEmpty()){
                        s.push(list[node.cur]);
                    }
                    s.push(list[node.right]);
                }
            }
            if(node.left != -1 && !isVisit[node.left]){
                s.push(list[node.cur]);
                s.push(list[node.left]);
            }
        }


        System.out.println(count);
    }
}
