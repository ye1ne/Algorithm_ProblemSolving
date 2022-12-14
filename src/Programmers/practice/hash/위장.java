package Programmers.practice.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 위장 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"} , {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {

        //각 유형별 옷의 갯수를 저장할 해시맵
        HashMap<String,Integer> map = new HashMap<>();
        List<String> kindOfClothesList = new ArrayList<>();
        //전체 옷들에 대해 유형별로 저장
        for(String[] cloth : clothes){
            String kindOfCloth = cloth[1];
            if(map.containsKey(kindOfCloth)){
                map.put(kindOfCloth,map.get(kindOfCloth) +1);
            }else {
                map.put(kindOfCloth,1);
                kindOfClothesList.add(kindOfCloth);
            }
        }
        int answer = 1;
        //조합의 수를 구함
        for(String kindOfCloth : kindOfClothesList) {
            answer *= (map.get(kindOfCloth) +1 );
        }
        return answer -1;
    }
}
