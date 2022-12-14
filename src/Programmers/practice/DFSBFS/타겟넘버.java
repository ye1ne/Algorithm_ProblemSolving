package Programmers.practice.DFSBFS;

public class 타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    static int answer;
    public static int solution(int[] numbers, int target) {

        answer = 0;
        backTracking(0, 0, numbers, target);
        return answer;
    }

    static void backTracking(int count,int total, int[] numbers, int target){
        if(count == numbers.length && total == target){
            answer++;
            return;
        }
        if(count >= numbers.length) return;


        backTracking(count +1, total + numbers[count], numbers, target);

        backTracking(count +1, total - numbers[count], numbers, target);

    }
}
