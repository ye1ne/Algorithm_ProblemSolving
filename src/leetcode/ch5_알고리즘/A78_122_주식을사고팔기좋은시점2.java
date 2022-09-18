package leetcode.ch5_알고리즘;

import java.util.Arrays;

public class A78_122_주식을사고팔기좋은시점2 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        maxProfit(prices);
    }
    static public int maxProfit(int[] prices) {

        int sum = 0;
        int privPrice = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i]>privPrice)
                sum+= (prices[i] - privPrice);
            privPrice = prices[i];
        }

        System.out.println(sum);
        return sum;
    }
}
