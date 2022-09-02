package baaarkingDogWorkBook.x13_BinarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.UnresolvedPermission;
import java.util.*;

public class G3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            for (int j = i + 1; j < N; j++) {
                list.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);
        Collections.sort(list);

        System.out.println(Arrays.toString(arr));
        int sum = 0;
//        for (int i=0; i<N; i++) {
//            for (int j = i + 1; j < N; j++) {
//                int tmpNum = arr[i] + arr[j];
//                int returnIndex = Arrays.binarySearch(arr,-tmpNum);
//                int lower =returnIndex;
//
//                if(lower < 0) continue;
//
//                if(arr[lower] == arr[i]) lower+=2;
//                else if(arr[lower] == arr[j]) lower++;
//
//                if(arr[lower] != -tmpNum) continue;
//
//                for (int k = lower; k<N && arr[k] == -tmpNum; k++){
//                    upper++;
//                }
//                sum += upper - lower;
//                System.out.println(lower +"~"+ upper+" 실제 3값은:"+arr[i]+" "+ arr[j]+" "+arr[lower]);
//
//            }
//        }
        System.out.println(sum);
    }
}
