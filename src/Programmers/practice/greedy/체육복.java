package Programmers.practice.greedy;

import java.util.Arrays;

public class 체육복 {

    public static void main(String[] args) {

        int n = 4;

        int[] lost = {2,3};

        int[] reserve = {3,4};

        System.out.println(solution(n,lost,reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {

        int result = n;
        int[] gymSuit =  new int[n+1];
        Arrays.fill(gymSuit,1);
        for(int number :reserve){
            gymSuit[number]++;
        }
        for(int number : lost) {
            gymSuit[number]--;
        }
        for(int number=0; number <= n; number++){
            if(gymSuit[number] == 0) {
                if(number -1>0 && gymSuit[number-1] ==2){
                    gymSuit[number - 1]--;
                    gymSuit[number]++;
                    continue;
                }
                if (number + 1 <= n && gymSuit[number + 1] == 2 ) {
                    gymSuit[number + 1]--;
                    gymSuit[number]++;
                    continue;
                }
                result--;
            }
        }
        return result;
    }
}

