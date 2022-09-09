package leetcode.선형자료구조;

public class A8_42_빗물트래킹 {
    public static void main(String[] args) {
        int[] height ={0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2};

        int trap =0;
        int top = height[0], index =0;
        //제일 높은 top값을 찾자
        for(int i=0; i<height.length;i++){
            if(top <=height[i]){
                index = i;
                top = height[i];
            }
        }
        //왼쪽은 0부터 시작해서,이때 left는 최대높이
        int left = height[0];
        //top값 까지 가는데
        for(int i=0; i<index; i++){
            if(height[i]>left) left = height[i]; //만약 최대 높이가 갱신되면 갱신
            else if(height[i] <left) trap += (left-height[i]); //최대 높이보다 계속 작으면 더해줌
        }
        int right = height[height.length -1];
        for(int i= height.length-1;i>index; i--){
            if(height[i]>right) right =height[i];
            else if(height[i]<right) trap += (right -height[i]);
        }
        System.out.println(trap);
    }
}
