package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 킹 {
    static final int L = 0, R = 1, B = 2, T = 3, LB = 4, LT = 5, RB = 6, RT = 7;
    //왼, 오, 아래, 위,왼쪽아래, 왼쪽 위, 오른쪽 아래, 오른쪽 위
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    static int[] king = new int[2];
    static int[] stone = new int[2];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = findLocation(st.nextToken());
        stone = findLocation(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            int dir = convertDirection(br.readLine());
            moveKingsLocation(dr[dir], dc[dir]);
        }

        printResult();

    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        char row1 = (char)('A' + king[0]);
        char col1 = (char)('1' + king[1]);

        char row2 = (char)('A' + stone[0]);
        char col2 = (char)('1' + stone[1]);

        sb.append(row1);
        sb.append(col1);
        sb.append("\n");
        sb.append(row2);
        sb.append(col2);

        System.out.println(sb);
    }

    private static void moveKingsLocation(int row, int col) {
        int nextRow = king[0] + row;
        int nextCol = king[1] + col;

        if(!inRange(nextRow) || !inRange(nextCol)){
            return;
        }
        //돌이 있는 방향으로 움직인다면,
        int stoneRow = stone[0];
        int stoneCol = stone[1];
        if(stoneRow == nextRow && stoneCol == nextCol){
            //돌은 방향하나 더 이동
            int nextStoneRow = stoneRow + row;
            int nextStoneCol = stoneCol + col;

            //만약 범위를 넘어서면, 애초에 무효
            if(!inRange(nextStoneRow) || !inRange(nextStoneCol)){
                return;
            }
            //아니라면 돌 이동
            stone[0] = nextStoneRow;
            stone[1] = nextStoneCol;
        }
        //킹도 이동
        king[0] = nextRow;
        king[1] = nextCol;
    }
    private static boolean inRange(int number) {
        return number < 8 && number >= 0;
    }

    private static int convertDirection(String str) throws IOException {
        if (str.equals("L")) return 0;
        if (str.equals("R")) return 1;
        if (str.equals("B")) return 2;
        if (str.equals("T")) return 3;
        if (str.equals("LB")) return 4;
        if (str.equals("LT")) return 5;
        if (str.equals("RB")) return 6;
        if (str.equals("RT")) return 7;
        else throw new IOException();
    }

    private static int[] findLocation(String str) {
        //알파벳은 열, 숫자는 행
        //열 : A - H
        //행 : 1 - 8
        int row = str.charAt(0) - 'A';
        int col = str.charAt(1) - '1';
        return new int[]{row, col};
    }
}
