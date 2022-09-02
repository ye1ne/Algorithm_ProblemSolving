package baaarkingDogWorkBook.x13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class G2295 {
    static Integer[] arr;
    static List<Integer> list = new ArrayList<>();
    static int MAX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new Integer[N];

        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        for(int i=0; i<N; i++) for(int j=0; j<N; j++) list.add(arr[i]+arr[j]);
        Collections.sort(list);
        for(int i=N-1; i>0; i--)
            for(int j=0; j<i; j++)
                if(Collections.binarySearch(list,arr[i]-arr[j])>=0) {
                    System.out.println(arr[i]);
                    return;
                }

    }

}
