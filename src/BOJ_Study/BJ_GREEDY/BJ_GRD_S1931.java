package BOJ_Study.BJ_GREEDY;
import java.io.*;
import java.util.*;

public class BJ_GRD_S1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2];
        for(int  i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });

        int count=0;
        int check = 0;
        for(int i=0; i<N; i++){
            if(list[i][0]>=check){
                check = list[i][1];
                count++;
            }
        }

        System.out.println();
    }
}
