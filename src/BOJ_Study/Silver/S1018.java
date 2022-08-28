package BOJ_Study.Silver;

import java.util.Scanner;

public class S1018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        String tmp = "";
        char[][] base1 ={{'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'}};
        char[][] base2 ={{'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'}};
        char[][] array = new char[N][M];
        int count_b1 = 0;
        int count_b2 = 0;
        for (int i = 0; i < N; i++) {
            tmp = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = tmp.charAt(j);
            }
        }


        int result = M*N;
        for (int i = 0; i <= N - 8; i++)
        {
            for (int j = 0; j <= M - 8; j++)
            {
                for (int row = i; row < i+8; row++)
                {
                    for (int col = j; col < j+8; col++) {
                        if (array[row][col] != base1[row-i][col-j]) count_b1++;
                        if (array[row][col] != base2[row-i][col-j]) count_b2++;
                    }
                }

                if(count_b1 < result) {
                    result = count_b1;
                }
                if(count_b2 < result) {
                    result = count_b2;
                }
                count_b2 = 0;
                count_b1 = 0;
            }
        }
        System.out.println(result);
    }
}

