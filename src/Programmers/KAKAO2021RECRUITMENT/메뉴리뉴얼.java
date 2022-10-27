package Programmers.KAKAO2021RECRUITMENT;

import java.util.*;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course = {2,3,4};

//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2,3,5};
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        solution(orders,course);
    }

    static public String[] solution(String[] orders, int[] course) {



        //카운트할 map
        map = new Map[course.length];
        for(int i=0 ;i<course.length; i++) map[i] = new HashMap<>();
        pq = new PriorityQueue[course.length];
        for(int i=0 ;i<course.length; i++) {
            pq[i] = new PriorityQueue<>(new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
                }
            });
        }
        //결과를 담을 배열
        List<String> result = new ArrayList<>();
        //여기서 가능한 모든 조합을 만들고
        for(String order : orders){
            //일단 정렬
            char[] arr = order.toCharArray();
            Arrays.sort(arr);

            //조합을 만든다 원하는 코스 길이 만큼
            for(int i=0; i<course.length; i++){
                combination(course[i],0,arr, new StringBuilder(),i);
            }
        }

        for(int i=0; i<course.length; i++){
            if(pq[i].isEmpty()) continue;

            String[] tmp = pq[i].poll();
            String str = tmp[0];
            int count = Integer.parseInt(tmp[1]);
            if(count <2) continue;
            result.add(str);
            while(!pq[i].isEmpty() && Integer.parseInt(pq[i].peek()[1]) == count){
                tmp = pq[i].poll();
                str = tmp[0];
                result.add(str);
            }

        }
        String[] answer = result.toArray(new String[result.size()]);

        Arrays.sort(answer);
        return answer;
    }

    static Set<String> combinationList;
    static Map<String,Integer>[] map;
    static  PriorityQueue<String[]>[] pq;
//
    static void combination(int count, int start, char[] arr, StringBuilder sb,int row){
        if(count == 0){
            String str = sb.toString();
            if(map[row].containsKey(str)) map[row].put(str,map[row].get(str)+1);
            else map[row].put(str,1);
            pq[row].add(new String[]{str,(map[row].get(str)+"")});
            return;
        }
        for(int i= start; i<arr.length; i++){
            sb.append(arr[i]+"");
            combination(count-1,i+1,arr,sb,row);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
