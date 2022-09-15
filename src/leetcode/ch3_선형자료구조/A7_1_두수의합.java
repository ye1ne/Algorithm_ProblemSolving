package leetcode.ch3_선형자료구조;

public class A7_1_두수의합 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] arr ;

        for(int i=0;i<nums.length;i++) for(int j=i+1;j<nums.length;j++)if(nums[i]+nums[j] == target)arr = new int[]{i,j};


    }
}
