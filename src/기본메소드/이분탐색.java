package 기본메소드;

import java.util.List;

public class 이분탐색 {

    public static void main(String[] args) {

    }
    private static int lowerBound(List<Integer> data, int target) {
        int begin = 0;
        int end = data.size();

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(data.get(mid) >= target) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return end;
    }

    private static int upperBound(List<Integer> data, int target) {
        int begin = 0;
        int end = data.size();

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(data.get(mid) <= target) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
}
