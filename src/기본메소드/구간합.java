package 기본메소드;

public class 구간합 {

    //구간합이라는건, 첫 합만 구하고 그 이후는 하나빼고 더하는식으로도 구할 수 있다는걸 기억하자
    //이건카카오 공채 기출 참고하자
    //또는 아래처럼 하자

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int[] sum = new int[10];
        for(int i=0; i<10; i++){
            if(i ==0) sum[i] = arr[i];
            else sum[i] = sum[i-1]+arr[i];
        }
    }
}
