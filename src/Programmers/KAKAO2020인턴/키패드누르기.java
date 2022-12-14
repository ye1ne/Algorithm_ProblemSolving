package Programmers.KAKAO2020인턴;

public class 키패드누르기 {
    public static void main(String[] args) {

        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers,hand));
    }

    public static String solution(int[] numbers, String hand) {

        //결과를 저장하기 위한 StringBuilder를 만든다
        StringBuilder sb = new StringBuilder();
        int leftHandNumber = 10;
        int rightHandNumber = 12;
        //전체 숫자 배열에 대해서 돈다
        for(int number : numbers) {
            if(sb.toString().equals("LRL"))
                System.out.println();
            //만약 숫자가 1,4,7이라면 , 왼손을 추가하고 다음으로 넘어간다
            if(number == 1 || number == 4 || number == 7){
                sb.append("L");
                leftHandNumber = number;
            }
            //만약 숫자가 3,6,9라면 , 오른손을 추가하고 다음으로 넘어간다
            else if(number == 3 || number == 6 || number == 9){
                sb.append("R");
                rightHandNumber = number;
            }
            //그외의 경우, 현재 왼손의 위치와 오른손의 위치중 가까운 것을 판단한다
            else{
                if(isNearToLeft(number, leftHandNumber, rightHandNumber, hand)){
                    sb.append("L");
                    leftHandNumber = number;
                }else{
                    sb.append("R");
                    rightHandNumber = number;
                }
            }
        }
        return sb.toString();
    }

    private static boolean isNearToLeft(int number, int leftHandNumber, int rightHandNumber, String hand) {
        //숫자가 0이라면 11로 치환시켜준다
        if(number == 0) number = 11;
        if(leftHandNumber == 0) leftHandNumber = 11;
        if(rightHandNumber == 0) rightHandNumber = 11;

        int lengthToLeft = calcaulationLength(leftHandNumber, number);
        int lengthToRight = calcaulationLength(rightHandNumber, number);

        if(lengthToLeft == lengthToRight){
            if(hand.equals("right")) return false;
            else return true;
        }

        return lengthToLeft < lengthToRight ? true : false;

    }

    private static int calcaulationLength(int handNumber, int number) {
        int length = Math.abs(handNumber - number);
        int row = length/3;
        int col = length%3;
        return row+col;
    }
}
