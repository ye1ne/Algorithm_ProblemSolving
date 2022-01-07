package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class S11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] Array = new int[num];

        for(int i=0; i<num; i++){
            Array[i] = scanner.nextInt();
        }
        int tmp;
        for(int i=0; i< num-1; i++){
            for(int j=0; j<num-1-i; j++){
                if(Array[j]>Array[j+1]){
                    tmp = Array[j];
                    Array[j] = Array[j+1];
                    Array[j+1] = tmp;
                }
            }
        }
        int sum =0;
        for(int i=0; i<num; i++){
            for(int j=0; j<=i;j++){
                sum += Array[j];
            }
        }
        System.out.println(sum);

    }
}
