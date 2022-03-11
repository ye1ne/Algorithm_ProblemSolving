package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class BJ_G17140 {
    static int r,c,k;
    static int[][] A = new int[101][101];
    static int row, col;
    static int[] count;
    static void operationR(){
        for(int i=1; i<=row; i++){
            count = new int[101];
            for(int j=1; j<=col;j++){
                count[A[i][j]]++;
            }

        }
        System.out.println();
    }
    static void operationC(){

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i =1; i<=3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=3;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        row =3; col= 3;
        operationR();
        System.out.println();
    }
}
