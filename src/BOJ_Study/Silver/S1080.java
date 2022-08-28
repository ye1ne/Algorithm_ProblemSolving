package BOJ_Study.Silver;

import java.util.Scanner;

public class S1080 {
    static int square(int num1, int num2){
        int result = 1;
        for(int i=0; i<num2;i++){
            result *= num1;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] matrixBefore = new int[row][col];
        int[][] matrixAfter = new int[row][col];

        int[] matrixTmp = new int[col];
        int intTmp;
        for(int i=0; i<row; i++){
            intTmp = scanner.nextInt();
            for(int j=0; j<col; j++){
              matrixBefore[i][j] = intTmp/square(10,col-1-j);
              intTmp = intTmp%square(10,col-1-j);
            }
        }

    }
}
