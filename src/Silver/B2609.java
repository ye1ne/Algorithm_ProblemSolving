package Silver;

import java.util.Scanner;

public class B2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int[] same = new int[10000];
        int count = 0;
        int[] leave = new int[2];
        int i;

        loop1: while(true){
            i = 2;
            while(i<10000) {

                if(num1/i == 0 || num2/i ==0){
                    break loop1;
                }
                if (num1 % i == 0 && num2 % i == 0) {
                    same[count] = i;
                    num1 = num1 / i;
                    num2 = num2 / i;
                    leave[0] = num1;
                    leave[1] = num2;
                    count ++;
                    break;
                }

                 i++;
            }
        }
        int lcm= 1;
        int gcd= num1 * num2;
        for(int j=0; j<count; j++) lcm *= same[j];
        if (lcm != 1) gcd = lcm * leave[0]*leave[1];

        System.out.println(lcm);
        System.out.print(gcd);
    }
}
