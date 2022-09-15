package leetcode.ch3_선형자료구조;


import java.util.*;

public class A9_15_3SUM {
    public static void main(String[] args) {
        int[] nums = {0,0,0};

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int mid= 0; mid<nums.length-2; mid++){
            if(mid>=1 && nums[mid] == nums[mid-1]) continue;
            int left= mid+1, right = nums.length-1;

            while (left <right){
                if(nums[left] + nums[right] +nums[mid] == 0){
                    list.add(new ArrayList<>(Arrays.asList(nums[left],nums[mid],nums[right])));
                    while((left<right)&&nums[left] == nums[left+1] ) left++;
                    while((left<right)&&nums[right] == nums[right-1] ) right--;
                    left++;
                    right--;
                }
                else if(nums[left] + nums[right] +nums[mid] > 0){
                    right--;
                }
                else if(nums[left] + nums[right] +nums[mid] < 0){
                    left++;
                }
            }
        }

        System.out.println();

    }
}
