package Programmers.Backend2021;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};
        int unKnown = 0;
        int right =0 ;
        OuterLoop:
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) unKnown++;
            else {
                for (int j = 0; j < 6; j++)
                    if (lottos[i] == win_nums[j]) {
                        right++;
                        continue OuterLoop;
                    }
            }
        }
        int[] result = new int[2];
        result[0] = 7- (right+unKnown);
        result[1] = 7 - right;
        for(int i=0; i<2; i++){
            if(result[i] == 7) result[i]=0;
        }
        System.out.println(Arrays.toString(result));
    }
}
