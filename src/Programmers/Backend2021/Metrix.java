package Programmers.Backend2021;

import java.util.ArrayList;
import java.util.List;

public class Metrix {

    static int[][] matrix;
    public static void main(String[] args) {
        int rows = 6;
        int cols = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        matrix = new int[rows + 1][cols + 1];
        int count = 0;
        for (int i = 1; i <= rows; i++)
            for (int j = 1; j <= cols; j++)
                matrix[i][j] = ++count;

        int[] result = new int[queries.length];
        for(int i=0; i<queries.length; i++){

            result[i] = rotate(queries[i]);
        }


    }
    static int rotate(int[] arr){
        int MIN = Integer.MAX_VALUE;
        int startR = arr[0];
        int startC = arr[1];
        int endR = arr[2];
        int endC = arr[3];
        int nextNum =0;
        int newNum = matrix[startR][startC];
        //맨 윗줄 오른쪽 모서리 미포함
        for(int i=startC; i<endC; i++){
            nextNum = matrix[startR][i+1];
            matrix[startR][i+1] = newNum;
            MIN = Math.min(newNum,MIN);
            newNum = nextNum;
        }
        //오른쪽 아래로 한칸 채우고, 다른거
        for(int i=startR; i<endR; i++){
            nextNum = matrix[i+1][endC];
            matrix[i+1][endC] = newNum;
            MIN = Math.min(newNum,MIN);
            newNum = nextNum;
        }
        //왼쪽으로
        for(int i=endC; i>startC; i--){
            nextNum = matrix[endR][i-1];
            matrix[endR][i-1] = newNum;
            MIN = Math.min(newNum,MIN);
            newNum = nextNum;
        }
        //위쪽으로
        for(int i=endR; i>startR; i--){
            nextNum = matrix[i-1][startC];
            matrix[i-1][startC] = newNum;
            MIN = Math.min(newNum,MIN);
            newNum = nextNum;
        }
        return MIN;
    }
}
