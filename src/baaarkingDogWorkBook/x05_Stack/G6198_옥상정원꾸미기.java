package baaarkingDogWorkBook.x05_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 범위 값 문제
 */
public class G6198_옥상정원꾸미기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long count = 0;
        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(br.readLine());
            //만약 비어있으면 집어넣음 (확인 0)
            if(stack.isEmpty()){
                stack.add(number);
                continue;
            }

            //가장 위에 있는 건물보다 내가 높거나 같으면
            if(stack.peek() <= number){
                //나보다 큰 건물이 나올때까지 pop
                while(!stack.isEmpty()&& stack.peek() <= number){
                    stack.pop();
                    System.out.println("빼내기!");
                }
            }
            //이제 stack내 건물들은 나보다 큼
            count += stack.size();
            System.out.println(stack.size()+"만큼 더하자 ");
            stack.push(number);

        }
        System.out.println(count);
    }
}
