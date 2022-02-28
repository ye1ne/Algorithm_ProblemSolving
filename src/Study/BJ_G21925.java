package Study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G21925 {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        Stack<Integer> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }


        boolean isPalindrome = true;
        int count =0;
        s.push(A[0]);
        OuterLoop:
        for(int i=1; i<N; i++){
            if(!s.isEmpty() && s.peek() ==A[i]){
                for(int j=0; j<s.size();j++){
                    if(! (A[i+j]==s.pop())){
                        isPalindrome = false;
                        break OuterLoop;
                    }
                }
                count++;
            }
            else{
                s.push(A[i]);
            }
        }
        if(isPalindrome) System.out.println(count);
        else System.out.println(-1);
    }
}
