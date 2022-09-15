package leetcode.ch3_선형자료구조;

import java.util.Stack;

public class A22_739_일일온도 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for(int i=0; i< temperatures.length; i++){
            int current = temperatures[i];
            while(!stack.isEmpty() && current >temperatures[stack.peek()]){
                int last = stack.pop();
                answer[last] = i-last;
            }
            stack.push(i);
        }

        System.out.println();
    }
}
