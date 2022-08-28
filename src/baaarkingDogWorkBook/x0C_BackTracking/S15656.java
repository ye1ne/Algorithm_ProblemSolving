package baaarkingDogWorkBook.x0C_BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S15656 {
    static int N, M;
    static int[] arr;
    static LinkedList<Integer> list = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backTracking();
        System.out.println(sb);
    }

    static void backTracking(){
        if(list.size() == M){
            printSet();
            return;
        }

        for(int i=0; i<N; i++){
            list.add(arr[i]);
            backTracking();
            list.removeLast();
        }
    }

    private static void printSet() {
        int count = 0;
        for(int i =0; i<M;i++) {
            sb.append(list.get(i));
            count++;
            if(count == M){
                sb.append("\n");
            }else{
                sb.append(" ");
            }
        }
    }
}
