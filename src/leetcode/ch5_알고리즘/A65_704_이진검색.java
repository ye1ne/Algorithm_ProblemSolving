package leetcode.ch5_알고리즘;

import java.util.Arrays;

public class A65_704_이진검색 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 13;

        System.out.println(search(nums,target));
    }
    static public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length,target);
    }

    static int flag;
    static int binarySearch(int[] arr, int left, int right, int num){
        if(left > arr.length-1) return -1;
        if(left == right-1 || left == arr.length-1){
            if(arr[left] == num) return left;
            else return -1;
        }

        int mid = (left+right)/2;
        if(mid == 5)
            System.out.println();
        if(arr[mid] == num ) return mid;
        if(arr[mid]<num) return binarySearch(arr,mid+1,right,num);
        else  return binarySearch(arr,left,mid,num);
    }
}
