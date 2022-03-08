package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_G3363 {
    final static int plus = 0, minus = 1;
    static int[][] inputNum = new int[3][8];
    static char[] inputOp = new char[3];
    static int[] countNum = new int[13];
    static int[][] checker  = new int[2][13];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for( int i=0; i<3; i++){
            String str = br.readLine();
            if(str.equals("")){
                i--;
                continue;
            }else {
                StringTokenizer st = new StringTokenizer(str);
                for (int j = 0; j < 9; j++) {
                    if (j > 4) {
                        inputNum[i][j - 1] = Integer.parseInt(st.nextToken());
                        countNum[inputNum[i][j - 1]]++;
                    } else if (j < 4) {
                        inputNum[i][j] = Integer.parseInt(st.nextToken());
                        countNum[inputNum[i][j]]++;
                    } else {
                        inputOp[i] = st.nextToken().charAt(0);
                    }
                }
            }
        }
        br.close();
        int availableLine = 3;
        for( int i=0; i<3; i++){
            if(inputOp[i] == '=') {
                availableLine--;
                for (int j = 0; j < 8; j++) {
                    countNum[inputNum[i][j]] = 0;
                }
            }
        }
        for( int i=0; i<3; i++){
            if(inputOp[i] != '='){
                for(int j=0; j<8;j++) {
                    if(countNum[inputNum[i][j]]!=availableLine) inputNum[i][j] = 0;
                    else{
                        if((j<4 && inputOp[i] =='<')||(j>=4 && inputOp[i] =='>') ){
                            checker[minus][inputNum[i][j]]++;
                        }else{
                            checker[plus][inputNum[i][j]]++;
                        }
                    }
                }
            }
        }
        boolean isImp = true;
        int count = 0;
        int resultNum = 0;
        char resultOp = 0;

        for( int i=0; i<2; i++){
            for(int j=0; j<13;j++) {
                if(checker[i][j] == availableLine){
                    if(i==plus){
                        resultNum = j;
                        resultOp = '+';
                        isImp = false;
                        count++;
                    }else{
                        resultNum = j;
                        resultOp = '-';
                        count++;
                        isImp = false;
                    }
                }
            }
        }
        if(isImp) {
            System.out.println("impossible");
        }else if(count >=2) {
            System.out.println("indefinite");
        }else{
            System.out.println(Integer.toString(resultNum)+resultOp);
        }

    }
}
