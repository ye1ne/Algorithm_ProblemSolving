package BOJ_Study.BJ_IO;

import java.util.Scanner;

public class BJ1_IO_10950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] a = new int[count];
        int[] b = new int[count];
        for(int i = 0; i<count;i++){
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            scanner.nextLine();
        }
        for(int i =0; i<count; i++)
            System.out.println(a[i]+b[i]);
    }
}
