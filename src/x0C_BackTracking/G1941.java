package x0C_BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1941 {

    static char[][] map = new char[5][5];
    static boolean[][] isSelected = new boolean[5][5];
    static int result;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5;i++){
            String str = br.readLine();
            for(int j=0; j<5; j++){
                map[i][j] = str.charAt(j);
            }
        }
        result = 0;
        backTracking(0,0,0);
        System.out.println(result);
    }
    static void backTracking(int start, int countTotal, int countS){
        if(countTotal == 7){
            if(countS >= 4 && isLinking()) result++;

            return;
        }
        for(int k = start; k<25; k++){
            int i = k/5;
            int j = k %5;

            if(isSelected[i][j]) continue;

            isSelected[i][j]= true;
            if(map[i][j] == 'S') countS++;
            countTotal++;

            backTracking(k+1,countTotal,countS);

            countTotal--;
            isSelected[i][j]= false;
            if(map[i][j] == 'S') countS--;
        }

    }
    static class info{
        int x, y;
        public info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Boolean isLinking(){
        boolean[][] isVisited = new boolean[5][5];
        Queue<info> q = new LinkedList<>();
        OuterLoop:
        for(int i=0; i<5;i++){
            for(int j=0; j<5; j++){
                if(isSelected[i][j]){
                    q.add(new info(i,j));
                    break OuterLoop;
                }
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            info cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if(isVisited[x][y]) continue;
            count++;
            isVisited[x][y] = true;

            if(x-1>=0 && isSelected[x-1][y] && !isVisited[x-1][y]){
                q.add(new info(x-1,y));
            }
            if(x+1<5 && isSelected[x+1][y] && !isVisited[x+1][y]){
                q.add(new info(x+1,y));
            }
            if(y-1>=0 && isSelected[x][y-1] && !isVisited[x][y-1]){
                q.add(new info(x,y-1));
            }
            if(y+1<5 && isSelected[x][y+1] && !isVisited[x][y+1]){
                q.add(new info(x,y+1));
            }
        }

        if(count == 7) return true;
        else return false;

    }

}
