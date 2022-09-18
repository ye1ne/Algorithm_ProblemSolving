package leetcode.ch5_알고리즘;

import java.util.*;

public class A67_349_두배열의교집합 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        intersection(nums1,nums2);

    }
    static public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums1.length; i++) if(!set.contains(nums1[i])) set.add(nums1[i]);

        Set<Integer> result = new HashSet<>();
        for(int i=0; i< nums2.length; i++)
            if(set.contains(nums2[i])) result.add(nums2[i]);

        Integer[] result2 = (Integer[]) result.toArray(new Integer[result.size()]);
        return Arrays.stream(result2).mapToInt(Integer::intValue).toArray();
    }
}
