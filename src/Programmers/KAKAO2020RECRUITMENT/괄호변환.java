package Programmers.KAKAO2020RECRUITMENT;

import java.util.Stack;

public class 괄호변환 {
    public static void main(String[] args) {
        String p = "";
        if(isProperString(p)) System.out.println(p);
        else {
            System.out.println(solved(p));
        }



    }


    static String solved(String subStr){

        String answer ="";
        if(subStr.isEmpty()) return "";
        int left = 0;
        int right = 0;
        String u = "";
        String v ="";
        for(int i =0; i<subStr.length(); i++){
            if (subStr.charAt(i) == '(') left++;
            else right++;

            if(left == right){
                u = subStr.substring(0,left+right);
                v = subStr.substring(left+right);
                break;
            }
        }
        if(isProperString(u)){
            answer += u;
            answer += solved(v);
            return answer;
        }
        String tmp = "(";
        tmp += solved(v);
        tmp += ")";
        String tmp2 = "";

        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i) == '(') tmp2 +=")";
            else tmp2 +="(";
        }

        tmp += tmp2;
        return tmp;
    }

    static boolean isProperString(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) =='(') {
                    s.push('(');
            }
            else{
                if(s.isEmpty()) return false;
                if(s.peek() == '('){
                    s.pop();
                    continue;
                }
            }
        }

        return true;
    }
}
