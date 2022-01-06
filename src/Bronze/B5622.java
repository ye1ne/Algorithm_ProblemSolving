package Bronze;

import java.util.Scanner;

public class B5622 {

    static int returnNum(char code){
        switch (code){
            case '1':
                return 1;
            case 'A': case 'B': case 'C':
                return 2;
            case 'D': case 'E': case 'F':
                return 3;
            case 'G': case 'H': case 'I':
                return 4;
            case 'J': case 'K': case 'L':
                return 5;
            case 'M': case 'N': case 'O':
                return 6;
            case 'P': case 'Q': case 'R': case 'S':
                return 7;
            case 'T': case 'U': case 'V':
                return 8;
            case 'W': case 'X': case 'Y': case 'Z':
                return 9;
            default:
                return 0;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputArray = input.toCharArray();
        int countTime = 0;
        for(int i =0; i<inputArray.length;i++){
            countTime += returnNum(inputArray[i]) + 1;
        }
        System.out.println(countTime);
    }
}
