package Programmers.KAKAO2022RECRUITMENT;

public class k진수에서소수개수구하기2 {
    public static void main(String[] args) {
        int n = 1000000;
        int k = 3;
//        int n = 2;
//        int k = 8;
//        int n = 550501;
//        int k = 10;

        String number = Integer.toString(n,k);
        System.out.println(number);
        int count = 0;

        //투포인터로 처음부터 시작
        OuterLoop:
        for(int start=0; start<number.length(); start++){

            if(number.charAt(start) == '0') continue OuterLoop;
            InnerLoop:
            for(int end =start+1; end<=number.length(); end++){
                String tmp = number.substring(start,end);
                //만약 블록이 끝까지 도달했을때
                if(end==number.length()){
                    if(isPrime(Long.parseLong(tmp))){
                        System.out.println(tmp+"?");
                        count++;
                    }
                    break OuterLoop;
                }
                //만약 0을 만나면
                if(number.charAt(end) == '0'){
                    //숫자가 소수라면
                    if(isPrime(Long.parseLong(tmp))){
                        count++;
                        start = end;
                        System.out.println(tmp+"!");
                        continue OuterLoop;
                    }else{
                        start = end;
                        continue OuterLoop;
                    }
                }
            }
        }

        System.out.println(count);
    }
    static boolean isPrime(long n) {
        if(n <= 1) return false;
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
