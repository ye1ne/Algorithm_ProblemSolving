package Bronze;

import java.util.Arrays;
import java.util.Scanner;

public class B1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputArray = input.toCharArray();
        for(int i=0; i<inputArray.length; i++){
            if((int)inputArray[i] >=97 && (int)inputArray[i] <=122)
                inputArray[i] = (char)((int)inputArray[i] - 32);
        }
        String test = new String(inputArray);
        int[] countArray = new int[26];
        for(int i=0; i<inputArray.length; i++){
            countArray[((int)inputArray[i]-65)] ++;
        }
        int max = countArray[0];
        int maxIndex =0;
        boolean checker = true;
        for(int i = 1; i<26; i++){
            if(countArray[i]>max) {
                max = countArray[i];
                checker = true;
                maxIndex =i;
            }else if(countArray[i] == max) {
                checker = false;
            }

        }

        if (checker == true ) {System.out.println((char)(maxIndex+65));}
        else {System.out.println('?');}

    }
}
