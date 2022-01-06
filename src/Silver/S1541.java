package Silver;

import java.util.Scanner;

public class S1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        input = input.replace("+",",+,");
        input = input.replace("-",",-,");
        int j;
        String[] array = input.split(",");
        for(int i=1; i < array.length; i +=2){
            if(array[i].equals("-")){
                j = i+2;
                while(j<array.length && array[j].equals("+")){
                    array[j] = "-";
                    j = j+2;
                }
                i = j-2;
            }
        }
        int sum = Integer.parseInt(array[0]);
        for(int i=1; i < array.length; i +=2){
            if(array[i].equals("+")){
                sum += Integer.parseInt(array[i+1]);
            }else{
                sum -= Integer.parseInt(array[i+1]);
            }
        }
        System.out.println(sum);
    }
}
