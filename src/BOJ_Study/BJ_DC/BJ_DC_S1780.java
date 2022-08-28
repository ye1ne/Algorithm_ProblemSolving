package BOJ_Study.BJ_DC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_DC_S1780 {
    static int[][] paper;
    static int N;
    static int countMinus;
    static int countZero;
    static int countPlus;

    static void solve(int startX,int startY, int length){
        int num = paper[startX][startY];
        boolean checker = true;
        OuterLoop:
        for(int i = startX; i<(startX+length);i++){
            for(int j = startY; j<(startY+length);j++) {
                if(paper[i][j] != num){
                    checker = false;
                    break OuterLoop;
                }
            }
        }
        if(checker){
            if(num == -1) {countMinus++;}
            else if(num == 0) {countZero++;}
            else {countPlus++;}

        }else{
            for(int i=startX; i<startX+length;i=i+length/3){
                for(int j=startY; j<startY+length;j=j+length/3){
                    solve(i,j,length/3);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countMinus = countZero = countPlus =0;
        solve(0,0,N);
        System.out.print(countMinus+"\n"+countZero+"\n"+countPlus);

    }
}
