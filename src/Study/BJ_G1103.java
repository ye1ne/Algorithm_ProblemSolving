package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G1103 {

    static class Info{
        int row,col,num,count;
        boolean[][] tmpVisit;
        public Info(int row, int col, int num,int count,boolean[][] tmpVisit,int N,int M) {
            this.row = row;
            this.col = col;
            this.num = num;
            this.count = count;
            this.tmpVisit = new boolean[N][M];
            for(int i=0;i<N;i++){
                for(int j=0; j<M; j++){
                    this.tmpVisit[i][j] = tmpVisit[i][j];
                }
            }
        }
    }

    static Stack<Info> s = new Stack<>();

    static int N,M;
    static int[][] map;
    static boolean[][] isVisit;
    static int result;
    public static void dfs(){
        while(!s.isEmpty()){
            Info info = s.pop();
            int row = info.row;
            int col = info.col;
            int num = info.num;
            int count = info.count +1;
            boolean[][] isVisit = info.tmpVisit;
            if(isVisit[row][col]){
                result = -1;
                return;
            }
            isVisit[row][col] = true;
            if(row+num >= N || map[row+num][col] == -1){
                if(count>result)
                    result = count;
            }else s.push(new Info(row+num,col,map[row+num][col],count,isVisit,N,M));

            if(row-num <0 || map[row-num][col] == -1){
                if(count>result)
                    result = count;
            }else s.push(new Info(row-num,col,map[row-num][col],count,isVisit,N,M));

            if(col-num <0 || map[row][col-num] == -1){
                if(count>result)
                    result = count;
            }else s.push(new Info(row,col-num,map[row][col-num],count,isVisit,N,M));

            if(col+num >= M || map[row][col+num] == -1){
                if(count>result)
                    result = count;
            }else s.push(new Info(row,col+num,map[row][col+num],count,isVisit,N,M));


        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisit = new boolean[N][M];
        result = -1000;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'H'){
                    map[i][j] = -1;
                }else{
                    map[i][j] = str.charAt(j) - '0';
                }

            }
        }
        s.push(new Info(0,0,map[0][0],0,isVisit,N,M));
        dfs();
        System.out.println(result);
    }
}
