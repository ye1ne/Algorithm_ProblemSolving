package BOJ_Study.Silver;

import java.util.Scanner;

public class S1094 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); //숫자를 문자열로 입력받아서

        int[] numArray = new int[num];
        for(int i =0; i<num; i++){ //input 문자열 길이만큼 도는데
            numArray[i] = scanner.nextInt();
        }
        int tmp;
        for(int i=0; i< num-1; i++){
            for(int j=0; j<num-1-i; j++){
                if(numArray[j]>numArray[j+1]){
                    tmp = numArray[j];
                    numArray[j] = numArray[j+1];
                    numArray[j+1] = tmp;
                }

            }
        }

        for(int i=0; i< num; i++){
            System.out.println(numArray[i]);
        }
    }
}
