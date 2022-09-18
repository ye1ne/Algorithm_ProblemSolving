package leetcode.ch5_알고리즘;

import java.util.Arrays;

public class A66_33_회전정렬된배열검색 {
    public static void main(String[] args) {

        int[] nums = {1,3};
        int target = 3;
        int a = search(nums,target);
        System.out.println(a);
    }


    static public int search(int[] nums, int target) {
        int[] sortNum = Arrays.copyOf(nums,nums.length);
        Arrays.sort(sortNum);
        if(nums[0] == target) return 0;
        int pivot = nums.length - Arrays.binarySearch(sortNum,nums[0]) ;
        int targetLocation = Arrays.binarySearch(sortNum,target);
        if(targetLocation < 0 ) return -1;
        return (pivot+targetLocation)%nums.length;

    }
}
