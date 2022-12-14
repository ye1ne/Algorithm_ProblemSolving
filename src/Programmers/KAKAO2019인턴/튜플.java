package Programmers.KAKAO2019인턴;

import java.util.*;

public class 튜플 {

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        solution(s);
    }

    public static int[] solution(String s) {

        String str = s.substring(1,s.length()-1);
        System.out.println(str);
        List<String> strList = findAllSubSet(str);
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        List<String> result = findAllNumber(strList);
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = Integer.parseInt(result.get(i));
        }
        return answer;
    }

    private static List<String> findAllNumber(List<String> strList) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<strList.size(); i++){
            StringTokenizer st = new StringTokenizer(strList.get(i), ",");
            while(st.hasMoreTokens()){
                String str = st.nextToken();
                if(!result.contains(str)) {
                    result.add(str);
                    break;
                }
            }
        }
        return result;
    }

    private static List<String> findAllSubSet(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '{'){
                sb = new StringBuilder();
            }else if(str.charAt(i) == '}'){
                result.add(sb.toString());
            }else{
                sb.append(str.charAt(i));
            }
        }
        return result;
    }
}
