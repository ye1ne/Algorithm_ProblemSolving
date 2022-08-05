package x0B_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2630 {
    static int[][] map;
    static int countWhite, countBlue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countWhite = 0; countBlue = 0;
        recursive(0,0,N);
        System.out.println(countWhite);
        System.out.println(countBlue);

    }

    static void recursive(int startX, int startY, int length){

        if(isBluePaper(startX,startY,length)){
            countBlue++;
            return;
        }
        if(isWhitePaper(startX,startY,length)){
            countWhite++;
            return ;
        }

        recursive(startX,startY,length/2);
        recursive(startX+length/2,startY,length/2);
        recursive(startX,startY+length/2,length/2);
        recursive(startX+length/2,startY+length/2,length/2);

    }

    static boolean isBluePaper(int startX, int startY, int length){
        for(int i= startX; i<startX+length; i++){
            for(int j= startY; j<startY+length; j++){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }

    static boolean isWhitePaper(int startX, int startY, int length){
        for(int i= startX; i<startX+length; i++){
            for(int j= startY; j<startY+length; j++){
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }
}
