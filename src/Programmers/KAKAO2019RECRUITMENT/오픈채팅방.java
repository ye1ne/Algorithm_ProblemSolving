package Programmers.KAKAO2019RECRUITMENT;

import java.util.*;

public class 오픈채팅방 {
    //15분
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }
    static public String[] solution(String[] record) {

        String out = "님이 나갔습니다.";
        String in = "님이 들어왔습니다.";
        //아이디랑 이름 매치
        HashMap<String,String> nameMap = new HashMap<>();
        List<String[]> list = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String flag = st.nextToken();
            String id = st.nextToken();
            String name = "";
            if(!flag.equals("Leave")) name = st.nextToken();

            if(flag.equals("Enter")){
                list.add(new String[]{id,in});
                nameMap.put(id,name);
            }else if(flag.equals("Leave")){
                list.add(new String[]{id,out});
            }else{
                nameMap.put(id,name);
            }
        }
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            String tmp = nameMap.get(list.get(i)[0]) + list.get(i)[1];
            answer[i] = tmp;
        }
        return answer;
    }
}
