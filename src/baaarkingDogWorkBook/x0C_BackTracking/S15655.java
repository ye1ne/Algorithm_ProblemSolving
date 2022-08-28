package baaarkingDogWorkBook.x0C_BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S15655 {
    static int N, M;
    static int[] arr;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backTracking(0,0);
        System.out.print(sb.toString());
    }
    static void backTracking(int start, int count){
        if(count == M){
            printSet();
            return;
        }

        for(int i =start; i<N; i++){
            isSelected[i] = true;
            backTracking(i+1, count+1);
            isSelected[i] = false;
        }
    }

    private static void printSet() {
        int select = 0;
        for(int i =0; i<N;i++) {
            if(isSelected[i]) {
                sb.append(arr[i]);
                select++;
                if(select == M){
                    sb.append("\n");
                }else{
                    sb.append(" ");
                }
            }
        }
    }
}
