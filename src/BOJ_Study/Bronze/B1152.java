package BOJ_Study.Bronze;

import java.util.Scanner;

public class B1152 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals(" ") || input.equals("  ")) {
            System.out.println(0);
        }else {
            String[] array = input.split(" ");
            if (array[0].equals("")) System.out.println(array.length - 1);
            else System.out.println(array.length);
        }
    }
}
