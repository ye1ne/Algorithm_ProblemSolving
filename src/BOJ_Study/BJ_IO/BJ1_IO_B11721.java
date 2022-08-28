package BOJ_Study.BJ_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1_IO_B11721 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str_array = (br.readLine()).toCharArray();

        for(int i=0; i<str_array.length; i++) {
            System.out.print(str_array[i]);
            if (i % 10 == 9) System.out.println();
        }

    }
}
