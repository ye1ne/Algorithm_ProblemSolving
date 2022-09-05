package Programmers.KAKAO2020RECRUITMENT;

public class 문자열압축 {
    public static void main(String[] args) {
        /**
         * ab ab cd cd ab ab cd cd
         *
         */
        String s = "a";
        String result = "";
        result= compression(6,s);
        int MIN = Integer.MAX_VALUE;
        for(int i=1; i<s.length(); i++){
            result = compression(i,s);
            MIN = Math.min(MIN,result.length());
            System.out.println(result +" "+ result.length()+" "+MIN);
        }
        if(MIN == Integer.MAX_VALUE) System.out.println(s.length());
        else System.out.println(MIN);

    }

    static String compression(int length, String s){
        String result = "";
        String priv = "";
        int count  =0;
        OuterLoop:
        for(int i=0; i<s.length(); i+=length){
            if(i+length >= s.length()){
                if(length == 4){
                    System.out.println();
                }
                //만약 마지막까지 중복이면
                if(s.substring(i).equals(priv)){
                    count++;
                    result += (count + priv);
                    return result;
                }
                //앞에랑 다를때
                if(count >1) result += (count + priv);
                else result += priv;

                result += s.substring(i);
                return result;
            }
            String now = s.substring(i,i+length);
            //이전꺼랑 똑같으면
            if(now.equals(priv)) {
                count++;
                continue OuterLoop;
            }
            //다를때, 이전에는 중복이라면
            if(count >1) result += (count + priv);
            else result += priv;

            count = 1;
            priv = now;
        }
        return result;
    }
}
