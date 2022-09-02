package baaarkingDogWorkBook.x13_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int MIN = Integer.MAX_VALUE;
        int[] minNumList = new int[2];

        OuterLoop:
        for(int i =0; i<N; i++){
            int location = Arrays.binarySearch(arr,-arr[i]);
            if(location > 0){
                minNumList[0] = arr[i];
                minNumList[1] = arr[location];
                break OuterLoop;
            }
            location = -location -1;
            //먼저 해당인덱스 다음값 찾기
            if(location != i &&location<N && location>=0){
                if(MIN > Math.abs(arr[location]+arr[i])){
                    MIN =  Math.abs(arr[location]+arr[i]);
                    minNumList[0] = arr[i];
                    minNumList[1] = arr[location];
                }
            }
            //해당하는 인덱스 전값 찾기
            if(location-1 != i && location-1>=0 && location-1<N ){
                if(MIN > Math.abs(arr[location-1]+arr[i])){
                    MIN =  Math.abs(arr[location-1]+arr[i]);
                    minNumList[0] = arr[i];
                    minNumList[1] = arr[location-1];
                }
            }
        }
        Arrays.sort(minNumList);
        System.out.println(minNumList[0] + " "+minNumList[1]);
    }
}
