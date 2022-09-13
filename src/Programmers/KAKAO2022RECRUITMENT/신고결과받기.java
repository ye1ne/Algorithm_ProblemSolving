package Programmers.KAKAO2022RECRUITMENT;

import java.util.*;

public class 신고결과받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report ={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        boolean[] isDeclare = new boolean[id_list.length];
        Map<String, List<String>> declareListMap = new HashMap<>();
        Map<String, Integer> countDeclareMap = new HashMap<>();
        Map<String,Integer> nameIndexMap = new HashMap<>();

        for(int i=0; i<id_list.length; i++){
            declareListMap.put(id_list[i], new ArrayList<>());
            countDeclareMap.put(id_list[i],0);
            nameIndexMap.put(id_list[i],i);
        }

        OuterLoop:
        for(int i=0; i<report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String mainUser = st.nextToken();
            String targetUser = st.nextToken();

            List<String> declareUserList = declareListMap.get(targetUser);
            for(String user : declareUserList){
                if(user.equals(mainUser)) continue OuterLoop;
            }
            declareUserList.add(mainUser);
            declareListMap.put(targetUser,declareUserList);

            countDeclareMap.put(targetUser,countDeclareMap.get(targetUser)+1);
        }

        int[] result = new int[id_list.length];
        for(int i=0; i< id_list.length;i++){
            if(countDeclareMap.get(id_list[i])>=k){

                List<String> declareUserList = declareListMap.get(id_list[i]);
                for(String user : declareUserList){
                    result[nameIndexMap.get(user)]++;
                }

            }
        }

        System.out.println();


    }
}
