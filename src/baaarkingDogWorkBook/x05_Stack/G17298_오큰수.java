package baaarkingDogWorkBook.x05_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class G17298_오큰수 {
    /**
     * 오큰수  = 오른쪽에 있으면서 큰 수 중에서 가장 왼쪽에 있는 수
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Integer> origin = new Stack<>();
        Stack<Integer> move = new Stack<>();
        Stack<Integer> result = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-- > 0){
            origin.add(Integer.parseInt(st.nextToken()));
        }

        while(!origin.isEmpty()){
            int number = origin.pop();
            if(move.isEmpty()){
                result.push(-1);
                move.push(number);
                continue;
            }

            if(move.peek() <= number){
                while(!move.isEmpty()&& move.peek() <= number){
                    move.pop();
                }
            }
            if(move.isEmpty()) result.push(-1);
            else result.push(move.peek());
            move.push(number);
        }

        while(!result.isEmpty()){
            sb.append(result.pop());
            sb.append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
