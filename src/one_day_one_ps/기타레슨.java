package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨 {
    
    static long[] array;
    static int N, M;
    public static void main(String[] args) throws IOException {
        /*
         * 블루레이를 녹화, 강의 순서가 바뀌면 안됨
         * 순서가 뒤바뀌면, 강의의 흐름이 끊겨서 i번강의 - j번강의를 같이 녹화하려면 사의 강의 모두 같은거에 녹음해야함
         *  M개의 블루레이에 모두녹화, 같은 크기
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new long[N];
        long max = Integer.MIN_VALUE ;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, array[i]);
        }
        long min = max;
        max *= N;
        
        while( min < max ){
            long mid = (min + max) / 2;
            if(canRecord(mid)){
                max = mid;
            }else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }

    //이거는 중간값이, 원하는 값보다 크거나 같은 경우를 의미함
    private static boolean canRecord(long length) {
        //하나씩 담는데
        int use = 1;
        long leave = length;
        for (int i = 0; i < N; i++) {
            //만약 담을 수 있으면 컨티뉴
            if(leave >= array[i]){
                leave -= array[i];
                continue;
            }
            //못담으면 다음으로
            //만약 use가 갯수에 도달하면
            if(use == M) {
                return false;
            } else {
                use++;
                leave = length;
                leave -= array[i];
            }
        }
        return true;
    }
}
