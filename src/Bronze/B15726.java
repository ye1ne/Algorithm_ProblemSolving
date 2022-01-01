package Bronze;

import java.util.Scanner;

public class B15726 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();

        int case1 = (int)((a*b)/c);
        int case2 = (int)((a/b)*c);

        if(case1 > case2){
            System.out.printf("%d",(int)case1);
        }else{
            System.out.printf("%d",(int)case2);
        }
    }
}
