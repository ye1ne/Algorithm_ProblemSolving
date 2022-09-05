package leetcode;

import java.util.*;

public class A5_49_그룹애너그램 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        //문자열 하나 선택
        OuterLoop:
        for(String str : strs){

            //대표문자열 하나씩 선택 후 확인

            char[] str1 = str.toCharArray();
            Arrays.sort(str1);
            String str2 = new String(str1);
            if(set.contains(str2)){
                for(int i=0; i<list.size(); i++){
                    List<String> tmpList = list.get(i);
                    tmpList.add(str);

                }

            }
//            ListLoop:
//            for(int i=0; i<list.size(); i++){
//                //길이 같을때
//                char[] str1 = str.toCharArray();
//                char[] str2 = representStr.get(0).toCharArray();
//                Arrays.sort(str1);
//                Arrays.sort(str2);
//
//                //만약 두 배열이 다르다면!
//                if(!Arrays.toString(str1).equals(Arrays.toString(str2))) continue ListLoop;
//
//                //만약 두 배열이 같다면!
//                representStr.add(str);
//                list.set(i, representStr);
//                continue OuterLoop;
//            }
//            //결국 같은걸 못찾았으면
//            List<String> newlist = new ArrayList<>();
//            newlist.add(str);
//            list.add(newlist);
        }
        Arrays.asList(list);

    }
}
