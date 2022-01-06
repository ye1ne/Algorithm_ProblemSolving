package Silver;

import java.util.Scanner;

public class S9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numString = scanner.nextLine();
        int num = Integer.parseInt(numString);
        String[] input = new String[num];
        for (int i = 0; i < num; i++) {
            input[i] = scanner.nextLine();
        }
        String inputTmp;

        for (int i = 0; i < num; i++) {
            inputTmp = "";
            while (true) {
                if (input[i].equals("")) {
                    System.out.println("YES");
                    break;
                }
                inputTmp = input[i].replace("()", "");
                if (inputTmp.equals(input[i])) {
                    System.out.println("NO");
                    break;
                }
                input[i] = inputTmp;
            }
        }


    }
}
