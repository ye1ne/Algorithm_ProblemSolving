package Silver;

import java.util.Scanner;

public class S1475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strHome = scanner.nextLine(); //숫자를 문자열로 입력받아서
        int strLength = strHome.length(); //전체 문자열 길이를 반환해서 저장하고
        int[] count = {0,0,0,0,0,0,0,0,0,0}; //count라는 배열설정, 길이는 0부터 9까지,
        // 이제부터 해당하는 숫자가 하나씩 들어오면 count배열에서 하나씩 증가가 될것,
        // 예를들어 숫자 244가 들어왔을때 count[2]값은 1증가, count[4]의 값이 1씩 두번 증가될것임.

        int tmp = 0;
        for(int i =0; i<strLength; i++){ //input 문자열 길이만큼 도는데
            tmp = strHome.charAt(i)-'0';  //각 문자열의 자리의 문자들을 숫자로 변환하고
            count[tmp] = count[tmp]+1; //아까말한 count배열에 해당하는 값에 1을 더함
        }

        int sum = 0;
        sum = count[6] + count[9]; //두 숫자의 갯수를 합쳐서 (어짜피 공유할수 있기에 같은것 취급 가능)
        if (sum % 2 == 0) {
            count[6] = sum/2;
            count[9] = sum/2;
        }else {
            count[6] = sum/2 + 1;
            count[9] = sum/2 + 1;
        }
        //count 배열내에서 가장 많은 값을 갖는 숫자를 찾자!
        int max = count[0]; //그다음 최대값 자체를 찾기위해 일단 count[0]이 최대라고 설정
        for (int i = 0; i < count.length; i++) { //전체 배열을 돌면서 더 큰 값이 있으면 max값들을 교체하는 방식으로 진행
            if (count[i] > max) max = count[i];
        }
        System.out.println(max);

    }
}
