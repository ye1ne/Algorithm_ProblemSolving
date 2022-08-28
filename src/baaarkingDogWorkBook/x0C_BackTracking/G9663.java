package baaarkingDogWorkBook.x0C_BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G9663 {
    static boolean[] isUsedCol, isUsedLeftUp, isUsedRightUp;
    static int countQueen, N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isUsedCol =  new boolean[40];
        isUsedLeftUp = new boolean[40];
        isUsedRightUp = new boolean[40];

        solve(0);
        System.out.println(countQueen);


    }

    static void solve(int depth){
        if(depth == N){
            countQueen++;
            return;
        }
        for(int i=0; i<N; i++){
            if(isUsedCol[i] || isUsedRightUp[i+depth] || isUsedLeftUp[depth-i+N-1]) continue;
            isUsedCol[i] = true;
            isUsedRightUp[i+depth] = true;
            isUsedLeftUp[depth-i+N-1] = true;
            solve(depth+1);
            isUsedCol[i] = false;
            isUsedRightUp[i+depth] = false;
            isUsedLeftUp[depth-i+N-1] = false;
        }
    }


}
