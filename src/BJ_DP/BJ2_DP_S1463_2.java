package BJ_DP;

import java.io.*;

public class BJ2_DP_S1463_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] find = new int[num+1];
        find[0] = find[1] =  0; // find[2] = find[3] = 1;
        //의미 없는 int a, b, c 지우고
        for(int i =2; i<num+1;i++){
            find[i] = find[i-1]+1;
            if(i%2 ==0) find[i] = Math.min(find[i/2]+1,find[i]);
            if(i%3 ==0) find[i] = Math.min(find[i/3]+1,find[i]);
        }
        System.out.println(find[num]);

    }

}
