package Study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G21925 {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N; i++){
            //일단 다 받음
            A[i] = Integer.parseInt(st.nextToken());
        }
        int start, end;
        int left, right;
        boolean isPa = true;
        int count =0;
        //첫번째 숫자부터 탐색함
        OuterLoop:
        for(int i=0; i<N;i++){
            //숫자 하나를 선택하고
            start = end = i;
            // 그 다음 숫자부터똑같은 숫자 나올때까지 반복함
            for(int j = i+1; j<N;j++){
                //그전에 끝까지 똑같은 숫자가 안나오면다면 팰린드롬이 아님
                //바로 루프 빠져나감
                if(j == N-1 &&A[j] != A[i]){
                    isPa = false;
                    break OuterLoop;
                }
                //만약에 제일 처음 같은 숫자를 찾았다면
                if(A[j] == A[i]){
                    //일단 두 점사이의 갯수가 짝수가 아니면 팰린드롬이 아님
                    //바로 루프 빠져나감
                    if((j-i-1)%2!=0){
                        isPa = false;
                        break OuterLoop;
                    }
                    left =j;
                    right =i;
                    //왼쪽 오른쪽에 대해 하나씩 이동하면서 같은지 확인함
                    while(left<=right){
                        //만약 1개라도 안같으면 팰린드롬아니므로 루프밖으로 빠져나감
                        if(A[left]!=A[right]){
                            isPa = false;
                            break OuterLoop;
                        }
                        left++; right--;
                    }
                    //끝까지 같았다면 count++ 해줌
                    count++;
                    i= ++j;
                }
            }
        }
        if(isPa) System.out.println(count);
        else System.out.println(-1);

    }
}
