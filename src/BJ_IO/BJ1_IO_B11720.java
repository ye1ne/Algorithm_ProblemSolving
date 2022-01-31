package BJ_IO;

import java.io.*;
public class BJ1_IO_B11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] str_array = (br.readLine()).split("");
        int sum =0;
        for(int i=0; i<num; i++)
            sum += Integer.parseInt(str_array[i]);
        System.out.println(sum);

    }
}
