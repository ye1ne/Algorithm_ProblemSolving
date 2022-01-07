package Bronze;

import java.util.Scanner;
public class B2839 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int quo, rem;
        int result = 0;
        if(num%5 == 0){ //끝자리 0 or 5
            result = num/5;
        }else{
            quo = num/5;
            for(int i=quo; i>0; i--){
                rem = num - i*5;
                if(rem%3 ==0){
                    result = i + rem/3;
                    System.out.println(i+" "+rem/3);
                    break;
                }else{
                    result = -1;
                }
            }

        }
        if(num%3==0 && result==-1) result= num/3;
        System.out.println(result);
    }
}
