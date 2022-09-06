package leetcode;


public class A6_5_가장긴팰린드롬부분문자열 {
    public static void main(String[] args) {
        String  s = "cbbd";
        int max = Integer.MIN_VALUE;
        String result ="";

        //홀수개로 증가할떄
        OuterLoop1:
        for(int mid=0; mid<s.length(); mid++){
            for(int length= 0; mid+length<s.length() && mid-length>=0;length++){
                if(s.charAt(mid-length) == s.charAt(mid+length)){
                    if(length*2 +1>max){
                        max = length*2 +1;
                        result = s.substring(mid-length,mid+length+1);

                    }
                }else continue OuterLoop1;
            }
        }

        //짝수개로 증가할때
        OuterLoop2:
        for(int mid=0; mid<s.length(); mid++){
            for(int length= 0; mid+length+1<s.length() && mid-length>=0;length++){
                if(s.charAt(mid-length) == s.charAt(mid+length+1)){
                    if((length+1)*2 >max){
                        max = (length+1)*2;
                        result = s.substring(mid-length,mid+length+2);
                    }
                }else continue OuterLoop2;
            }
        }

        System.out.println(result);
    }
}
