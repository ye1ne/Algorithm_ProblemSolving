package leetcode.ch4_비성형자료구조;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A34_46_순열 {
    static List<List<Integer>> result = new ArrayList<>();
    static boolean[] isVisited;
    public static void main(String[] args) {

        int[] nums = {1,2,3};
        isVisited = new boolean[nums.length];
        List<Integer> tmpList = new ArrayList<>();
        dfs(nums.length,nums,tmpList);

        System.out.println();
    }

    static void dfs(int count,int[] nums, List<Integer> tmpList){
        if(count == 0){
            System.out.println(tmpList.get(0)+" "+tmpList.get(1)+" "+tmpList.get(2)+" ");
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                tmpList.add(nums[i]);
                dfs(count-1,nums,tmpList);
                tmpList.remove(tmpList.size()-1);
                isVisited[i] = false;
            }
        }
    }
}
