package leetcode.ch5_알고리즘;

import java.util.Arrays;
import java.util.Comparator;

public class A64_973_원점에k번째로가까운점 {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;

        kClosest(points,k);
    }

    static public int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(calculateDistance(o1) > calculateDistance(o2)) return 1;
                return -1;
            }
        });
        int[][] result = new int[k][2];
        for(int i=0; i<k; i++) result[i] = points[i];
        return new int[2][2];
    }

    static double calculateDistance(int[] arr){
        int a = arr[0];
        int b = arr[1];
        return Math.sqrt(Math.pow(a,2) +Math.pow(b,2));
    }
}
