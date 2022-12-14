package Programmers.KAKAO2019인턴;

import java.util.HashMap;

public class 호텔방배정 {
    public static void main(String[] args) {

        long k = 10;
        long[] room_number = {1,3,4,1,3,1};

    }
    public static long[] solution(long k, long[] room_number) {

        //연결되어있는 구간의 갯수를 알려주는 int 변수를 선언한다
        int totalLinkingNumber = 0;
        //연결되어있는 구간의 끝이 어딘지를 저장하는 hashmap을 선언한다
        HashMap<Integer, Integer> linkingNumberMap = new HashMap<>();
        //연결되어있는 구간의 끝을 보여주는 integer 배열을 선언한다
//        long[] linkingEndNumberList = new long[k];



        //원하는 예약의 룸넘버를 순회하는데
            //만약 0이면(즉, 아무사람도 배정되어 있지않으면) 배정한다
            //만약 0이 아니면

                //해당하는 구간의 끝의 다음값을 찾는다

                //다음값이 존재하지 않을때까지 찾는다

                //찾으면 해당값에 저장 후
                //해시맵을 업데이트 시켜준다


        long[] answer = {};
        return answer;
    }
}
