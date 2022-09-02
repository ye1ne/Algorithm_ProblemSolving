package baaarkingDogWorkBook.x13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];
        List<Integer>[] pressNumList = new List[M];
        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<N; j++){
                arr[i][j] =Integer.parseInt(st.nextToken());
                set.add(arr[i][j]);
            }
            pressNumList[i] = new ArrayList<>(set);
            Collections.sort(pressNumList[i]);
        }

        for(int i=0; i<M; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] =  Collections.binarySearch(pressNumList[i],arr[i][j]);

        int count =0;
        for(int i=0; i<M; i++)
            for (int j = i+1; j < M; j++)
                if(Arrays.equals(arr[i],arr[j])) count++;


        System.out.println(count);

    }
}
