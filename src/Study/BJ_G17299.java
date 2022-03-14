package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G17299 {
    static int N;
    static int[] input;
    static int[] countNumber = new int[1_000_001];
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    static void solve(){
        while (!s1.isEmpty()){
            int tmp = s1.pop();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
            s1.push(input[i]);
            countNumber[input[i]]++;
        }


    }
}
