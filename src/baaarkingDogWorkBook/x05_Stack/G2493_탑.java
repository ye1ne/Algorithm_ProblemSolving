package baaarkingDogWorkBook.x05_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G2493_탑 {

    /**
     * N개의 탑을 왼쪽부터 오른쪽 방향으로 세우고ㅡ, 꼭대기에 레이저 설치
     * 하나의 탑에서 발사된 레이저, 하나의 탑에서만 수신가능
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Top> stack = new Stack<>();

        OuterLoop:
        for(int i=0; i<N; i++){
            int height = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek().height > height){
                  sb.append(stack.peek().number);
                  sb.append(" ");
                  stack.push(new Top(i+1,height));
                  continue OuterLoop;
                }
                stack.pop();
            }
            sb.append("0 ");
            stack.push(new Top(i+1,height));

        }

        System.out.println(sb.substring(0,sb.length()-1));
    }
    static class Top{
        int number;
        int height;

        public Top(int number, int height) {
            this.number = number;
            this.height = height;
        }
    }
}
