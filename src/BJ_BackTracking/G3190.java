package BJ_BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class G3190 {

    static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,K,L, totalTime;
    static int startX, startY, endX, endY;
    static int[][] map;
    static boolean isFinished;

    static int APPLE = 1, BODY =2, EMPTY = 0;

    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        totalTime = 0;
        K = Integer.parseInt(br.readLine());

        for(int i =0 ; i<K;i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = APPLE;
        }
        startX = startY = endX = endY = 0;
        while (isFinished){
            
        }


    }

    static void goOneStep(int direction){

        switch (direction){
            case 1:
                if(startX+1 <= N){
                    if(map[startX+1][startY]==APPLE){
                        map[++startX][startY] = BODY;
                        goOneStep(direction);

                    }else if(map[startX+1][startY]==BODY){
                        isFinished =true;
                        return;
                    }else{
                        map[++startX][startY] = BODY;
                        map[endX++][endY] = EMPTY;
                        goOneStep(direction);
                    }
                }else{
                    isFinished = true;
                }
                break;
            case 2:
                if(startX-1 > 0){
                    if(map[startX-1][startY]==APPLE){
                        map[--startX][startY] = BODY;
                        goOneStep(direction);

                    }else if(map[startX-1][startY]==BODY){
                        isFinished =true;
                        return;
                    }else{
                        map[--startX][startY] = BODY;
                        map[endX--][endY] = EMPTY;
                        goOneStep(direction);
                    }
                }else{
                    isFinished = true;
                }
                break;

            case 3:
                if(startY+1 <= N){
                    if(map[startX][startY+1]==APPLE){
                        map[startX][++startY] = BODY;
                        goOneStep(direction);

                    }else if(map[startX][startY+1]==BODY){
                        isFinished =true;
                        return;
                    }else{
                        map[startX][++startY] = BODY;
                        map[endX][endY++] = EMPTY;
                        goOneStep(direction);
                    }
                }else{
                    isFinished = true;
                }
                break;
            case 4:
                if(startY-1 > 0){
                    if(map[startX+1][startY]==APPLE){
                        map[startX][startY] = BODY;
                        goOneStep(direction);

                    }else if(map[startX+1][startY]==BODY){
                        isFinished =true;
                        return;
                    }else{
                        map[startX][--startY] = BODY;
                        map[endX][endY--] = EMPTY;
                        goOneStep(direction);
                    }
                }else{
                    isFinished = true;
                }
                break;
            default:
                break;
        }

    }
}
