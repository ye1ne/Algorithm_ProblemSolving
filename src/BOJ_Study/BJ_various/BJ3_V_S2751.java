package BOJ_Study.BJ_various;


import java.io.*;

public class BJ3_V_S2751 {
    static int[] A;
    static void swap(int from, int to){
        int tmp = A[from];
        A[from] = A[to];
        A[to] = tmp;
    }
    static void quicksort(int from, int to){
        if(from >= to) return;
        int pivot = A[to];
        int counter = from;
        for(int i = from; i<to; i++){
            if(A[i] <= pivot){
                swap(i,counter);
                counter++;
            }
        }
        swap(counter,to);
        quicksort(from,counter-1);
        quicksort(counter+1,to);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i =0; i<N;i++){
            A[i]= Integer.parseInt(br.readLine());
        }
        quicksort(0,N-1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i:A) bw.write(i+"\n");
        bw.flush();
        bw.close();
    }
}
