package BOJ_Study.Bronze;

import java.util.Scanner;

public class B10162 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        int button1 = 5*60;
        int button2 = 60;
        int button3 = 10;
        int a = 0;
        int b = 0;
        int c = 0;
        if(time >=button1){
            a = time / button1;
            time = time % button1;
        }
        if(time >=button2 ){
            b = time / button2;
            time = time % button2;
        }
        c = time /button3;
        time = time % button3;

        if(a + b + c ==0 || time != 0){
            System.out.println(-1);
        }else {
            System.out.println(a+" "+b+" "+c);
        }
    }
}
