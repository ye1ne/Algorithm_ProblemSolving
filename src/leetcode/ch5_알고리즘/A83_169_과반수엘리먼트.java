package leetcode.ch5_알고리즘;

import java.util.Arrays;
import java.util.HashMap;

public class A83_169_과반수엘리먼트 {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majorityElement(arr));
    }
    static public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                int tmp = map.get(num);
                if(tmp+1> nums.length/2) return num;
                map.put(num,tmp+1);
            }else map.put(num,1);
        }

        return nums[0];
    }
}
