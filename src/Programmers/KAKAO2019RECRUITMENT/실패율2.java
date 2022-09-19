package Programmers.KAKAO2019RECRUITMENT;

import java.util.Arrays;
import java.util.Comparator;

public class 실패율2 {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//        int N = 3;
//        int[] stages = {1,1};
        solution(N,stages);
    }

    /**
     * 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
     */
    static public int[] solution(int N, int[] stages) {
        //[][0] = 스테이지에 도달했으나 클리어 ㄴㄴ
        //[][1] = 스테이지에 도달한 플레이어 수
        int[][] arr = new int[N+2][2];

        for(int i=0; i<stages.length; i++){
            int stage = stages[i];
            arr[stage][0]++;
            for(int j=1; j<=stage; j++) arr[j][1]++;

        }
        double[] rateArr = new double[N];
        int[] answer = new int[N];

        for(int i=1; i<=N; i++){
            answer[i-1] = i;
            if(arr[i][0] == 0) rateArr[i-1] = 0.0;
            else rateArr[i-1] = (double) arr[i][0]/ (double) arr[i][1];
        }
        for(int i = 1; i <  N; i++) {
            // 각 라운드별 비교횟수는 배열 크기의 현재 라운드를 뺀 만큼 비교함
            for(int j = 0; j <N - i; j++) {
                if(rateArr[j] < rateArr[j + 1]) {
                    rateArr = swapDouble(rateArr, j, j + 1);
                    answer = swapInt(answer,j,j+1);
                }
            }
        }
        System.out.println();


        return null;

    }
    static double[] swapDouble(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        return a;
    }

    static int[] swapInt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        return a;
    }
}
