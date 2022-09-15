package leetcode.ch4_비성형자료구조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A36_39_조합의합 {

    static List<List<Integer>> result ;

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;


        result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        dfs(target,0,candidates,tmpList);
        System.out.println();
    }
    static void dfs(int count,int start,int[] candidates, List<Integer> tmpList){
        if(count == 0){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        if(count <0){
            return;
        }
        for(int i=start; i<candidates.length; i++){
            tmpList.add(candidates[i]);
            dfs(count-candidates[i],i,candidates,tmpList);
            tmpList.remove(tmpList.size()-1);
        }
    }


}
