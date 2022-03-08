package Study;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G1600 {

    static class Info{
        int x,y, state;
        Info(int x, int y, int state){
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }
    final static int barricade =1;
    static Queue<Info> q = new LinkedList<>();
    static int K,W,H;
    static int[][] map;

    static int solve(){
        int result = 0;
        int i = 0, j = 0;


        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W= Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for(int i=0;i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println();
    }
}
