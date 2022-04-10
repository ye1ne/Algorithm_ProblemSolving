package Programmers;

import java.util.Stack;

public class sq1 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int size = prices.length;
        int[] answer = new int[size];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;

            }
        }
    }
}
