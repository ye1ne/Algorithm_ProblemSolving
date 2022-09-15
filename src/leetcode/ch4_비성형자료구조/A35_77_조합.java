package leetcode.ch4_비성형자료구조;

import java.util.ArrayList;
import java.util.List;

public class A35_77_조합 {
    static List<List<Integer>> result ;
    static int num;
    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        num = n;
        result = new ArrayList<>();

        List<Integer> tmpList = new ArrayList<>();
        dfs(k,1,tmpList);

        System.out.println();
    }

    static void dfs(int count,int start, List<Integer> tmpList){
        if(count == 0){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i=start; i<=num; i++){
            tmpList.add(i);
            dfs(count-1,i+1,tmpList);
            tmpList.remove(tmpList.size()-1);
        }
    }
}
