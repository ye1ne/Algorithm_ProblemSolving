package 기본메소드;

import java.util.Arrays;

public class 조합 {
    public static void main(String[] args) {
        int[] arr = {5,1,4,2,8};
        combination(arr,new boolean[arr.length],0,5,3,new int[3]);

    }

    // n개 중에서 r개를 중복없이 뽑는 방법
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combination(int[] arr, boolean[] visited, int start, int n, int r, int[] result) {
        if(r == 0) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            result[n-r-2] = arr[i];
            combination(arr, visited, i + 1, n, r - 1, result);
            visited[i] = false;
        }
    }
}
