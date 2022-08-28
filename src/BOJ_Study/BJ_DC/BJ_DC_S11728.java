package BOJ_Study.BJ_DC;

import java.io.*;
import java.util.*;
public class BJ_DC_S11728 {
    public static void quickSort(int[] input, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = start;
        int i = start +1;
        int j = end;
        int tmp;
        while(i<=j){
            while(i<=end&& input[i] <input[pivot]){
                i++;
            }
            while(j>start&& input[j] >input[pivot]){
                j--;
            }
            if( i>j){
                tmp = input[j];
                input[j] = input[pivot];
                input[pivot] = tmp;
            }else{
                tmp = input[i];
                input[i] = input[j];
                input[j] = tmp;
            }
        }
        quickSort(input,start,j-1);
        quickSort(input,i++,end);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] result = new int[N+M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N;i++){
            result[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=N;i<N+M;i++){
            result[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(result,0,N+M-1);
        System.out.print(result[0]);
        for(int i=1;i<N+M;i++){
            System.out.print(" ");
            System.out.print(result[i]);
        }
    }
}
