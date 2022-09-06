package leetcode;

public class A11_238_자신을제외한배열의곱 {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] result = new int[nums.length];
        int total = 1;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0) count++;
            else total *= nums[i];

        }
        if(count>=2) for(int i=0; i<nums.length; i++) result[i] = 0;
        else if(count==1) for(int i=0; i<nums.length; i++) result[i] = (nums[i] == 0) ?  total: 0;
        else for(int i=0; i<nums.length; i++) result[i] = total/nums[i];
    }
}
