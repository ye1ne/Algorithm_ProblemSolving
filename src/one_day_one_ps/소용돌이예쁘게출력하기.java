package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소용돌이예쁘게출력하기 {

    static int[] minLocation = new int[2];
    static int[] maxLocation = new int[2];
    static int[] start = new int[2];
    static int MAX_LENGTH = 0;
    static final int CENTER = 5000, MAX = 10000;

    static int[][] map;
    static int TOTAL, MAX_SIZE;

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        minLocation[0] = Integer.parseInt(st.nextToken());
        minLocation[1] = Integer.parseInt(st.nextToken());
        maxLocation[0] = Integer.parseInt(st.nextToken());
        maxLocation[1] = Integer.parseInt(st.nextToken());

        int totalRow = maxLocation[0] - minLocation[0];
        int totalCol = maxLocation[1] - minLocation[1];
        map = new int[totalRow + 1][totalCol + 1];

        TOTAL = 0;
        MAX_SIZE = (totalRow + 1) * (totalCol + 1);


        makeMap(new int[]{CENTER + minLocation[0], CENTER + minLocation[1]},
                new int[]{CENTER + maxLocation[0], CENTER + maxLocation[1]});

        printSwirl();

    }

    private static void printSwirl() {

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {

                String format = "%" + MAX_LENGTH + "d";
                String number = String.format(format, map[row][col]);

                System.out.print(number);
                if (col != map[0].length - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("\n");
                }
            }
        }

    }


    private static void makeMap(int[] start, int[] end) {
        int row = CENTER;
        int col = CENTER;

        if (isInRange(start[0], end[0], row) &&
                isInRange(start[1], end[1], col)) {
            map[row - start[0]][col - start[1]] = 1;
            MAX_LENGTH = 1;
        }
        int length = 1;
        int dir = 0;
        int count = 2;

        while (!(row == MAX && col == MAX)) {

            if(TOTAL >= MAX_SIZE){
                return;
            }

            //일단 한 방향으로 값을 전부 기입
            for (int i = 0; i < length; i++) {

                if (row == MAX && col == MAX) {
                    return;
                }
                row = row + dr[dir];
                col = col + dc[dir];
                if (isInRange(start[0], end[0], row) &&
                        isInRange(start[1], end[1], col)) {
                    map[row - start[0]][col - start[1]] = count;
                    if ((int) (Math.log10(count) + 1) > MAX_LENGTH) {
                        MAX_LENGTH = (int) (Math.log10(count) + 1);
                    }
                    TOTAL++;
                }
                count++;
            }
            //기입후 한번만 더 방향을 바꾸고 값을 전부 기입
            dir = (dir + 1) % 4;
            for (int i = 0; i < length; i++) {
                row = row + dr[dir];
                col = col + dc[dir];
                if (isInRange(start[0], end[0], row) &&
                        isInRange(start[1], end[1], col)) {
                    map[row - start[0]][col - start[1]] = count;
                    if ((int) (Math.log10(count) + 1) > MAX_LENGTH) {
                        MAX_LENGTH = (int) (Math.log10(count) + 1);
                    }
                    TOTAL++;
                }
                count++;
            }
            //이후 Length를 1 넓히고 방향 바꾸고 다음으로 이동
            length++;
            dir = (dir + 1) % 4;
        }
    }

    private static boolean isInRange(int start, int end, int number) {
        return (number >= start && number <= end);
    }
}

class Person{
    int win;

    public Person(int win, int lose) {
        this.win = win;
        this.lose = lose;
    }

    int lose;
}