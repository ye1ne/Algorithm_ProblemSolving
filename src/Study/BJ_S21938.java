package Study;

import java.io.*;
import java.util.*;

public class BJ_S21938 {
    static int N;
    static int M;
    static boolean[][] isVisit;
    static int T;
    static class Node{
        int i,j,RGB;
        double value;
        private Node(int i, int j, double value){
            this.i = i;
            this.j = j;
            this.value = value;
        }

        void setRGB(int RGB){
            this.RGB = RGB;
        }
    }
    static Node[][] list;
    static Stack<Node> s = new Stack<>();
    static int count;
    static public int solve(){
        int count =0;
        OuterLoop:
        while(!s.isEmpty()){
            count++;
            Node tmp = s.pop();
            int i = tmp.i; int j = tmp.j;
            if(isVisit[i][j]) {
                if(count == 1) return 1;
                continue OuterLoop;
            }
            isVisit[i][j] = true;
            if(i-1>=0 && list[i-1][j].RGB == 255 &&!isVisit[i-1][j]){
                s.push(list[i-1][j]);
            }
            if(i+1<N && list[i+1][j].RGB == 255 &&!isVisit[i+1][j]){
                s.push(list[i+1][j]);
            }
            if(j-1>=0 && list[i][j-1].RGB == 255 &&!isVisit[i][j-1]){
                s.push(list[i][j-1]);
            }
            if(j+1<M && list[i][j+1].RGB == 255&& !isVisit[i][j+1]){
                s.push(list[i][j+1]);
            }
        }
        return 0;

    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new Node[N][M];
        isVisit = new boolean[N][M];
        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
           for(int j = 0; j<M; j++){
                int tmp = 0;
                for(int k=0; k<3; k++)tmp += Integer.parseInt(st.nextToken());
                list[i][j] = new Node(i,j,tmp/3);
            }
        }
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<N;i++){
            for(int j=0;j<M;j++) {
                if (list[i][j].value < T) {
                    list[i][j].setRGB(0);
                }
                else {
                    list[i][j].setRGB(255);
                }
            }
        }
        count =0;
        for(int i=0; i<N;i++){
            for(int j=0;j<M;j++) {
                if(list[i][j].RGB == 255){
                    s.push(list[i][j]);
                    int k =solve();
                    if(k == 0) count++;
                }
            }
        }
        System.out.println(count);
    }
}
