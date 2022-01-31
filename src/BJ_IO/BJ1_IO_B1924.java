package BJ_IO;

import java.util.Scanner;

public class BJ1_IO_B1924 {
    public static void main(String[] args) {
        String[] week = {"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] monthweek = {0,3,3,6,1,4,6,2,5,0,3,5};
        Scanner scanner= new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.println(week[(monthweek[month-1]+day)%7]);

    }
}
