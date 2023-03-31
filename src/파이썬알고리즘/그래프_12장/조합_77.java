package 파이썬알고리즘.그래프_12장;

import java.util.*;
public class 조합_77 {
    public static void main(String[] args) {

    }
}

class Solution3 {

    static List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        combinations(1,k,n,new ArrayList<>());
        return result;
    }

    public void combinations(int start, int size ,int end, List<Integer> list){
        if(start == size){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i<=end; i++){
            list.add(i);
            combinations(i, size +1,end, list);
            list.remove(list.size()-1);
        }
    }
}
