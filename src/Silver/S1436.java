package Silver;


import java.util.Arrays;
import java.util.Scanner;

public class S1436 {
    static int factorial (int num){
        int result = 1;
        if(num != 0){
            for(int i =1;i<=num; i++){
                result  *= i;
            }
        }
        return result ;
    }
    static int mathIndex(int num){
        int result = 1;
        for(int i=0; i<num;i++){
            result *= 9;
        }
        return result;
    }
    static int Permutation(int num1,int num2){
        return factorial(num1)/factorial(num1-num2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int[] num = new int[4];
        int tmpNum = 0;
        for(int i = 1; i<=4; i++){
            for(int j=i; j>0;j--){
                 tmpNum += Permutation(9,j-1)*factorial(j);
            }
            num[i-1] = tmpNum;
            System.out.println(mathIndex(i)+" "+factorial(i));
            tmpNum =0;
        }
        System.out.println(Arrays.toString(num));
        System.out.println(Permutation(9,3)+" "+Permutation(9,2)+" "+Permutation(9,1));


    }
}
