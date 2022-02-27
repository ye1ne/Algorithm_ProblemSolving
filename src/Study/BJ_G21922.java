package Study;

import java.io.*;
import java.util.*;

public class BJ_G21922{
    //방향 식별을 쉽게 하기 위해 선언
    final static int fromUp= -1;
    final static int toDown= -1;

    final static int fromDown = 1;
    final static int toUp = 1;

    final static int fromLeft = -2;
    final static int toRight = -2;

    final static int fromRight= 2;
    final static int toLeft = 2;

    //좌석의 정보를 담을 Info class
    static class Info{
        int row, col, dirt;
        public Info(int row, int col,int dirt){
            this.row = row;
            this.col = col;
            this.dirt = dirt;
        }
    }

    //기타
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] hasAir;
    static int count;

    static Queue<Info> q = new LinkedList<>();

    //solver 함수
    static void solver(){
        //q 사용
        while(!q.isEmpty()){
            Info info = q.poll();
            int n = info.row;
            int m = info.col;
            int dirt = info.dirt;

            if(n<0 || m<0 || n>=N || m>=M){
                continue;
            }
            if(!hasAir[n][m]) count++;
            hasAir[n][m] = true;
            switch(map[n][m]){
                case 0:
                    if(dirt == fromUp)      q.add(new Info(n+1,m,toDown));
                    if(dirt == fromDown)    q.add(new Info(n-1,m,toUp));
                    if(dirt == fromRight)   q.add(new Info(n,m-1,toLeft));
                    if(dirt == fromLeft)    q.add(new Info(n,m+1,toRight));
                    break;
                case 1:
                    if(dirt == fromUp)      q.add(new Info(n+1,m,toDown));
                    if(dirt == fromDown)    q.add(new Info(n-1,m,toUp));
                    break;
                case 2:
                    if(dirt == fromRight)   q.add(new Info(n,m-1,toLeft));
                    if(dirt == fromLeft)    q.add(new Info(n,m+1,toRight));
                    break;
                case 3:
                    if(dirt == fromUp)      q.add(new Info(n,m-1,toLeft));
                    if(dirt == fromDown)    q.add(new Info(n,m+1,toRight));
                    if(dirt == fromRight)   q.add(new Info(n+1,m,toDown));
                    if(dirt == fromLeft)    q.add(new Info(n-1,m,toUp));
                    break;
                case 4:
                    if(dirt == fromUp)      q.add(new Info(n,m+1,toRight));
                    if(dirt == fromDown)    q.add(new Info(n,m-1,toLeft));
                    if(dirt == fromRight)   q.add(new Info(n-1,m,toUp));
                    if(dirt == fromLeft)    q.add(new Info(n+1,m,toDown));
                    break;
                default:
                    break;
            }
        }
    }

    //메인함수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        hasAir = new boolean[N][M];
        count = 0;
        //map 저장
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] ==9){ //에어컨이 존재하는 자리라면
                    //상하좌우 q에 넣음
                    q.add(new Info(i,j-1,toLeft));
                    q.add(new Info(i,j+1,toRight));
                    q.add(new Info(i-1,j,toUp));
                    q.add(new Info(i+1,j,toDown));
                    hasAir[i][j] = true;
                    count++;
                }
            }
        }
        solver();
        System.out.println(count);
    }
}
