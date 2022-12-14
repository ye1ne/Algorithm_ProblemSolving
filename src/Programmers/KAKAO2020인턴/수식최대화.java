package Programmers.KAKAO2020인턴;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {
    public static void main(String[] args) {
        String expression = "200*200-900";
        System.out.println(solution(expression));
    }

    static long maxNumber;
    public static long solution(String expression) {

        maxNumber =0;
        //식을 숫자와 문자에 대해 쪼개어 int 배열에 저장
        List<Integer> expressionList = makeExpressionArray(expression);
        //조합에 대한 우선순위 6가지 저장
        backTracking(0,new int[3], new boolean[3] ,expressionList);

        //각 우선순위에 따라 거듭계산
        return maxNumber;
    }

    private static List<Integer> makeExpressionArray(String expression) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                list.add(Integer.parseInt(sb.toString()));
                list.add(operandToInteger(expression.charAt(i)));
                sb = new StringBuilder();
            } else {
                sb.append(expression.charAt(i));
            }
        }
        list.add(Integer.parseInt(sb.toString()));
        return list;
    }

    private static int operandToInteger(char c){
        if(c == '+') return 0;
        else if( c == '-') return 1;
        return 2;
    }


    private static void backTracking(int count, int[] priorityArray, boolean[] isSelected, List<Integer> expressionList) {
        if(count == 3){
            calculationExpression(priorityArray,expressionList);
            return;
        }

        for(int i =0; i<3; i++){
            if(!isSelected[i]){
                priorityArray[count] = i;
                isSelected[i] = true;
                backTracking(count+1, priorityArray, isSelected, expressionList);
                priorityArray[count] = 0;
                isSelected[i] = false;
            }
        }
    }

    private static void calculationExpression(int[] priorityArray, List<Integer> expressionList) {

        System.out.println("시작===>");
        for(int i=0; i<3; i++){
            List<Integer> list = new ArrayList<>();
            System.out.println(priorityArray[i]+" 연산시작/ 0:더하기 / 1: 빼기 / 2:곱하기");
            for(int j=0; j<expressionList.size(); j++){
                if(j%2 ==0){
                    list.add(expressionList.get(j));
                    System.out.println(expressionList.get(j));
                }else {
                    if (expressionList.get(j) == priorityArray[i]) {
                        int first = list.get(list.size()-1);
                        int last = expressionList.get(j+1);
                        int number = calculationExpressionWithNumber(first,last,priorityArray[i]);
                        System.out.println(first + " "+ priorityArray[i]+" "+last);
                        list.remove(list.size()-1);
                        list.add(number);
                        j++;

                    }else{
                        list.add(expressionList.get(j));
                        System.out.println(expressionList.get(j));
                    }
                }
            }
            System.out.println(list);
            expressionList = list;
        }
        System.out.println(maxNumber +" "+ Math.abs(expressionList.get(0)));
        if(maxNumber < Math.abs(expressionList.get(0))) maxNumber = Math.abs(expressionList.get(0));
        System.out.println(maxNumber);
    }

    private static int calculationExpressionWithNumber(int first, int last, int expression) {
        if(expression == 0) return first + last;
        else if(expression == 1) return first - last;
        else return first * last;
    }
}
