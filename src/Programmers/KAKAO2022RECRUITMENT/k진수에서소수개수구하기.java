package Programmers.KAKAO2022RECRUITMENT;

public class k진수에서소수개수구하기 {
    public static void main(String[] args) {
//        int n = 10002_0;
//        int k = 10;
        int n = 550501;
        int k = 10;

        String number = Integer.toString(n,k);
        System.out.println(number);
        int count = 0;

        //투포인터로 처음부터 시작
        OuterLoop:
        for(int start=0; start<number.length(); start++){
            // 하나선택
            if(number.charAt(start) == '0')
                continue OuterLoop;
            InnerLoop:
            for(int end=start; end<number.length(); end++){

                //만약 end가 0 이아니고 양쪽끝까지 갔을때
                if(end == number.length()-1 && isPrime(Integer.parseInt(number.substring(start)))){
                    count++;
                    System.out.println(number.substring(start)+"??,,");
                    start = end;
                    continue OuterLoop;
                }
                //만약 0본다면 바로 끊고 다음으로
                if(number.charAt(end) == '0') {
                    String tmp = number.substring(start,end);
                    if(start == end ) tmp =Character.toString(number.charAt(start));

                    if(!isPrime(Integer.parseInt(tmp))) continue OuterLoop;
                    //만약 tmp 왼쪽에 아무것도 없고,
                    if(start==0){
                        count++;
                        System.out.println(tmp+"?");
                        start = end;
                        continue OuterLoop;
                    }
                    //양쪽에 0이있으면
                    if(start>0 && end<=number.length()-1
                            && number.charAt(start-1) =='0'
                            && number.charAt(end) == '0') {
                        count++;
                        System.out.println(tmp+"!");
                        start = end;
                        continue OuterLoop;
                    }
                    continue OuterLoop;
                }

                if(end == number.length()-1){
                    break OuterLoop;
                }

            }
        }

        System.out.println(count);
    }
    static boolean isPrime(int n) {
        if(n <= 1) return false;
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                if(n == 1783661){
                    System.out.println();
                }
                return false;
            }
        }
        if(n == 1783661){
            System.out.println();
        }
        return true;
    }
}
