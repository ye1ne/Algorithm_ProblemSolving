package Programmers.KAKAO2021RECRUITMENT;

public class 신규아이디추천 {
    public static void main(String[] args) {
//        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String new_id = "=.=";

        String tmp = solution(new_id);
        System.out.println(tmp);
    }

    static public String solution(String new_id) {

        //1. 모든 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        //2 소문자, 숫자, -  _ . 제외 모든 문자 삭제
        String tmp  = "";
        for(int i=0; i<new_id.length(); i++){
            if(     (new_id.charAt(i)<='z' && new_id.charAt(i) >= 'a')
                    || (new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9')
                    || new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.'){
                tmp += Character.toString(new_id.charAt(i));
            }
        }
        //3. 연속으로 ..가 나오면 .로 치환
        while(tmp.contains("..")) {
            tmp = tmp.replace("..", ".");
        }

        //4. .가 처음이나 끝이면 제거
        if(tmp.length() > 0 && tmp.charAt(0) == '.'){
            tmp = tmp.substring(1,tmp.length());
        }

        if(tmp.length()-1>=0 && tmp.charAt(tmp.length()-1) == '.'){
            tmp = tmp.substring(0,tmp.length()-1);
        }
        //5. 빈문자열이면 a대입
        if(tmp.isEmpty()) tmp += "a";

        //6. 16자 이상이면 앞에서부터 15개만 살리고 만약 마지막이 . 이면 . 제거
        if(tmp.length() >=16){
            tmp = tmp.substring(0,15);
        }
        while(tmp.charAt(tmp.length()-1) =='.'){
            tmp = tmp.substring(0,tmp.length()-1);
        }
        //7. 길이가 2자이하면 마지막 문자를 3이 될때까지 늘림
        while(tmp.length()<=2){
            tmp += Character.toString(tmp.charAt(tmp.length()-1));
        }

        return tmp;
    }
}
