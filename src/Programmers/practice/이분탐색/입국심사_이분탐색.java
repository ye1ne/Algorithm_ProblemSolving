package Programmers.practice.이분탐색;

import java.util.Arrays;

public class 입국심사_이분탐색 {

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        System.out.println(solution(n,times));
    }
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length-1]; //최대 소요시간


        while(left <= right){
            long mid = (left+ right)/2;
            long sum = 0; //총심사 인원

            for( int i=0; i< times.length; i++){
                sum += (mid/times[i]);
            }

            if( sum < n ){
                left = mid + 1;
            }else{
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    /**
     * Left 부분에 ==을 넣어주면,  정답의 경우도 +1로 범위를 위로 추가적으로 더 탐색하기 때문에 최댓값을 찾게되고
     *
     * Right부분에 ==을 넣어주면, 정답의 경우도 -1로 범위를 아래로 줄이기 때문에 최솟값을 찾게된다.
     */

    static int BinarySearch(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while(start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] >= target) {
                start = mid + 1;
            }
            else  if (arr[mid] > target){
            end = mid - 1;
            }
        }
        return mid;
    }
}
