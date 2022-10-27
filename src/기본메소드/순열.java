package 기본메소드;

import java.util.Arrays;

public class 순열 {
    public static void main(String[] args) {
        int[] arr = {5,1,4,2,8};
        permutation(arr,0,4,3);
    }

    // 순서 없이 n 개중에서 r 개를 뽑는 경우
    // 사용 예시: permutation(arr, 0, n, 4);
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,r)));
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
