package Programmers.KAKAO2019RECRUITMENT;

import java.util.*;

public class 후보키 {
    public static void main(String[] args) {
//        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
//        solution(relation);

        String[][] relation ={{"a","1","aaa","c","ng"},
                            {"b","1","bbb","c","g"},
                            {"c","1","aaa","d","ng"},
                            {"d","2","bbb","d","ng"}};
        System.out.println(solution(relation));

    }

    static public int solution(String[][] relation) {
        int col = relation[0].length;
        int row = relation.length;
        int count = 0;
        usedList = new ArrayList<>();

        for(int c=0; c<col; c++){
            lists= new ArrayList<>();
            combination(0,c+1,new ArrayList<>(),col,new StringBuilder());

            for(int j=0; j< lists.size(); j++){
                Set<String> set =new HashSet<>();
                List<Integer> tmp = lists.get(j);

                for(int r =0; r<row; r++) {
                    String str = "";
                    for (int t : tmp) str += relation[r][t];

                    set.add(str);
                }
                String used = "";
                for(int t: tmp) used += t;
                if(set.size() == row) {
                    count++;
                    usedList.add(used);
                }
            }

        }
        return count;
    }
    static void combination(int start, int count,List<Integer> list,int size,StringBuilder sb) {

        for(String str : usedList) {

            boolean flag = false;
            InnerLoop:
            for (int i = 0; i < str.length(); i++) {
                if(sb.toString().contains(str.charAt(i)+"")){
                    flag = true;
                }else{
                    flag = false;
                    break InnerLoop;
                }
            }
            if(flag) return;
        }

        if(count == 0) {
            List<Integer> tmp =List.copyOf(list);
            lists.add(tmp);
            return;
        }

        for(int i=start; i<size; i++) {

            list.add(i);
            sb.append(i+"");
            combination(i + 1, count - 1, list, size,sb);
            list.remove(list.size() - 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    static List<List<Integer>> lists;
    static List<String> usedList;

}
