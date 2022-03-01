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
            if(s.size()==1 && s.peek() ==A[i]){
                int tmp = s.size();
                if(N-i<tmp){
                    isPalindrome = false;
                    break OuterLoop;
                }
                for(int j=0; j<tmp;j++){
                    if(!(A[i+j]==s.pop())){
                        isPalindrome = false;
                        break OuterLoop;
                    }
                }
                count++;
                i+=(tmp-1);
            }
            else{
                s.push(A[i]);
            }
        }
        if(!s.isEmpty()) System.out.println(-1);
        else if(isPalindrome) System.out.println(count);
        else System.out.println(-1);
    }
}
