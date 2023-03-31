package one_day_one_ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 한줄로서기 {
    /**
     * N명의 사람들은 매일 한줄로스는데, 오민식이 줄 서는 위치를 기록해 놓음
     * 기록 해놓은 위치와, 사람들이 줄이 선 위치가 맞는지 확인함
     * 자기보다 큰 사람이 왼쪽에 몇명 있었는지만 기억함
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            stack.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for(int i = N; i>0; i--){
            int count = stack.pop();

            list.add(count, i);
        }

        for(int i=0 ;i<N; i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
