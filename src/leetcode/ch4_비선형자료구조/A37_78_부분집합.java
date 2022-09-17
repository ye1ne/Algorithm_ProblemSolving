package leetcode.ch4_비선형자료구조;

import java.util.ArrayList;
import java.util.List;

public class A37_78_부분집합 {
    static List<List<Integer>> result ;

    public static void main(String[] args) {
        int[] nums =  {1,2,3};
        result = new ArrayList<>();

        for(int i=0; i<=nums.length; i++){
            dfs(i,0,nums,new ArrayList<>());
        }

        System.out.println();
    }

    static void dfs(int count,int start, int nums[], List<Integer> list){
        if(count == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            dfs(count-1,i+1,nums,list);
            list.remove(list.size()-1);
        }

    }
}
