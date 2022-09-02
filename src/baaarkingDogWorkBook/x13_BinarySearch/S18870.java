package baaarkingDogWorkBook.x13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr =new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i=0; i<N; i++){
            sb.append(Collections.binarySearch(list,arr[i])+" ");
        }
        System.out.println(sb);
    }
}
