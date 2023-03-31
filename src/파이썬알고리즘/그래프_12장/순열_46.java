package 파이썬알고리즘.그래프_12장;

import java.util.*;

public class 순열_46 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Solution solution = new Solution();
        solution.permute(new int[]{1,2});
    }
}
class Solution {

    static List<List<Integer>> result;
    static int totalNumber;
    static int[] numberList;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        totalNumber = nums.length;
        numberList = nums;
        permutations(0, new boolean[totalNumber],new ArrayList<>());

        return result;
    }

    public void permutations(int count, boolean[] isVisited, List<Integer>list){
        if(count == totalNumber){
            List<Integer> tmp = new ArrayList<>();
            list.stream().forEach(tmp::add);
            tmp.addAll(list);
            return;
        }

        for(int i = 0; i< totalNumber; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                list.add(numberList[i]);
                permutations(count + 1, isVisited, list);
                list.remove(list.size()-1);
                isVisited[i] = false;
            }
        }
    }
}