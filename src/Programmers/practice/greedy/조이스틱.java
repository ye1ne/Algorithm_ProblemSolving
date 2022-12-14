package Programmers.practice.greedy;

import java.lang.management.MemoryType;
import java.util.HashSet;
import java.util.Set;

public class 조이스틱 {
    public static void main(String[] args) {

        String name = "ZZAAAZZ";
        System.out.println(solution(name));

    }
    public static int solution(String name) {

        int answer = 0;
        int index;
        int move = name.length() -1;

        for(int i= 0; i<name.length(); i++) {

            //해당값을 바꾸는 가장 적은 횟수를 추가
            answer += Math.min(name.charAt(i)- 'A', 'Z' + 1 - name.charAt(i));

            //A아닌거 찾을때까지 움직임
            index = i + 1;
            while(index < name.length() && name.charAt(index) == 'A'){
                index++;
            }


            //이건 다음 A까지 뒤로 이동하는게 좋을지 앞으로 이동하는 게 좋은지 정하는 것
            move = Math.min(move, i * 2 + name.length() - index);

            //아니면 처음부터 뒷부분을 입력하는게 더 빠른경우 선택
            move = Math.min(move, (name.length() - index) * 2 + i);

        }
        return answer + move;
    }


}
