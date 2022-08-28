package BOJ_Study.BJ_GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_GRD_P2873 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];

        int minHappy =1001;
        int minR =0;
        int minC =0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if( (i%2 == 0 && j%2 !=0)||(i%2 != 0 && j%2 ==0)){
                    if(map[i][j]<minHappy){
                        minHappy = map[i][j];
                        minR = i;
                        minC = j;
                    }
                }
            }
        }
        String result = "";

        if(R%2 != 0){
            String tmpOdd = "";
            String tmpEven = "";
            for(int j=0; j<C-1; j++){
                tmpOdd += "L";
                tmpEven += "R";
            }
            for(int i =0; i<R-1;i++){
                if(i%2==0) result += (tmpEven+"D");
                else result += (tmpOdd+"D");
            }
            result += tmpEven;
        }else if(C%2 != 0){
            String tmpOdd = "";
            String tmpEven = "";
            for(int j=0; j<R-1; j++){
                tmpOdd += "U";
                tmpEven += "D";
            }
            for(int i =0; i<C-1;i++){
                if(i%2==0) result += (tmpEven+"R");
                else result += (tmpOdd+"R");
            }
            result += tmpEven;
        }else {
            String tmpOdd = "";
            String tmpEven = "";
            String tmp = "";
            for (int j = 0; j < C - 1; j++) {
                tmpOdd += "L";
                tmpEven += "R";
            }
            tmp = tmpEven + "D" + tmpOdd + "D";
            for (int i = 0; i < minR - 1; i = i + 2) {
                result += tmp;
            }
            for (int i = 0; i < minC; i++) {
                if (i % 2 == 0) {
                    result += "DR";
                } else {
                    result += "UR";
                }
            }
            //핑크

            if(minC != C-1) {
                result += "R";
            }

            for (int i = minC + 1; i < C-1; i++) {
                if (i % 2 == 0) {
                    result += "UR";
                } else {
                    result += "DR";
                }
            }
            if(minC != C-1) {
                result +="D";
            }
            //핑크
            //파랑
            if(minR%2==0) {
                for (int i = minR + 1; i < R - 1; i++) {
                    result += "D";
                    if (i % 2 == 0) result += (tmpEven);
                    else result += tmpOdd;
                }
            }else{
                for (int i = minR + 1; i < R; i++) {
                    result += "D";
                    if (i % 2 == 0) result += (tmpOdd);
                    else result += tmpEven;
                }
            //파랑
            }
        }

        System.out.println(result);
    }
}
