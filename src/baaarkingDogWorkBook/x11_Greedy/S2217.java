package baaarkingDogWorkBook.x11_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2217 {
    static int N;
    static Integer[] weight ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        weight = new Integer[N];

        for(int i=0; i<N; i++){
            weight[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(weight);
        int MAX = 0;
        for(int i=0; i<N; i++){
            if(weight[i]*(N-i)>=MAX) MAX = weight[i]*(N-i);
        }
        System.out.println(MAX);
    }
}
