package BOJ_Study.Bronze;

import java.util.Scanner;

public class B1712 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long fix = scanner.nextLong();
        long made = scanner.nextLong();
        long price = scanner.nextLong();
        long result;
        if((price - made)==0) result = -1;
        else result = fix/(price - made);
        if(result+1 > 0) System.out.println(result+1);
        else System.out.println(-1);

    }
}

