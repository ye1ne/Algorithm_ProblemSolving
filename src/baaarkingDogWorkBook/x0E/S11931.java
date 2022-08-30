package baaarkingDogWorkBook.x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11931 {
    static int[] hasNum = new int[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            hasNum[Integer.parseInt(br.readLine())+1000000]++;
        }
        int count =0, index = 0;
        while(count<=N && index<2000001){
            while(hasNum[index]-->0){
                sb.append(index-1000000+"\n");
                count++;
            }
            index++;
        }
        System.out.print(sb);
    }
}
