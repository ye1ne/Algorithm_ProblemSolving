package Programmers.KAKAO2022INTERN;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    public static void main(String[] args) {
//        String[] survey ={"AN", "CF", "MJ", "RT", "NA"};
//        int[] choices = {5,3,2,7,5};

        String[] survey ={"TR", "RT", "TR"};
        int[] choices = {7,1,3};
        System.out.println(solution(survey,choices));

    }
    static public String solution(String[] survey, int[] choices) {

        Map<Character,Integer> map = new HashMap<>();

        for(int i =0; i<survey.length; i++){
            String str = survey[i];
            char c1 = str.charAt(0);
            char c2 = str.charAt(1);
            if(choices[i]<4){
                if(map.containsKey(c1)) map.put(c1,map.get(c1)+(4-choices[i]));
                else map.put(c1,(4-choices[i]));
            }else if(choices[i]>4){

                if(map.containsKey(c2)) map.put(c2,map.get(c2)+(choices[i]-4));
                else map.put(c2,(choices[i])-4);
            }
        }
        String answer = "";

        int a1 = map.containsKey('R') ? map.get('R') : 0;
        int a2 = map.containsKey('T') ? map.get('T') : 0;
        if(a1>=a2) answer += "R";
        else answer += "T";

        int b1 = map.containsKey('C') ? map.get('C') : 0;
        int b2 = map.containsKey('F') ? map.get('F') : 0;
        if(b1>=b2) answer += "C";
        else answer += "F";

        int c1 = map.containsKey('J') ? map.get('J') : 0;
        int c2 = map.containsKey('M') ? map.get('M') : 0;
        if(c1>=c2) answer += "J";
        else answer += "M";

        int d1 = map.containsKey('A') ? map.get('A') : 0;
        int d2 = map.containsKey('N') ? map.get('N') : 0;
        if(d1>=d2) answer += "A";
        else answer += "N";

        return answer;
    }
}
