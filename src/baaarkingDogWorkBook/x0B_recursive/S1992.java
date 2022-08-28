package baaarkingDogWorkBook.x0B_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1992 {

    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N;i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        recursive(0,0,N);
        System.out.println(sb);
    }
    static void recursive(int startX, int startY, int size){
        if(isSameOne(startX,startY,size)){
            sb.append(1);
            return;
        }
        if(isSameZero(startX,startY,size)){
            sb.append(0);
            return;
        }
        sb.append("(");
        recursive(startX, startY, size/2);
        recursive(startX, startY+size/2, size/2);
        recursive(startX+size/2, startY, size/2);
        recursive(startX+size/2, startY+size/2, size/2);
        sb.append(")");
    }
    static boolean isSameZero(int startX, int startY, int size){
        for(int i=startX; i<startX+size; i++){
            for(int j=startY; j<startY+size; j++){
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }
    static boolean isSameOne(int startX, int startY, int size){
        for(int i=startX; i<startX+size; i++){
            for(int j=startY; j<startY+size; j++){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
}
