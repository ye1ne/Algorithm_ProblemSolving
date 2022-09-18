package leetcode.ch5_알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A59_56_구간병합 {

    static public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        List<int[]> list = new ArrayList<>();
        int[] nums = new int[]{intervals[0][0] , intervals[0][1]};
        for(int i=0; i< intervals.length; i++){
            int[] interval = intervals[i];

            if(interval[0] <= nums[1]){
                nums[1] = Math.max(nums[1], interval[1]);
            }else {
                list.add(new int[]{nums[0],nums[1]});
                nums[0] = interval[0];
                nums[1] = interval[1];
            }
        }
        list.add(new int[]{nums[0],nums[1]});
        return list.toArray(new int[list.size()][2]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

    }
}
