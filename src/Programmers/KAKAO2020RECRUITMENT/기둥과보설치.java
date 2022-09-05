package Programmers.KAKAO2020RECRUITMENT;

import javax.xml.stream.Location;
import java.time.LocalDateTime;
import java.util.SortedMap;

public class 기둥과보설치 {
    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        location[][] map = new location[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                map[i][j] = (i == 0) ? new location(true) : new location(false);


         for(int[] build : build_frame){
             int x = build[0];
             int y = build[1];
             int structType = build[2];
             int actionType = build[3];

             //설치할때
             if(actionType == 1) {
                 //만약 기둥이면
                 if (structType == 0) {
                     if (map[y][x].isConnected) {
                         map[y][x].up = map[y + 1][x];
                         map[y][x].up.isConnected = true;
                         map[y][x].up.down = map[y][x];
                         System.out.println(x+"행"+y+"렬"+"바닥으로부터 기둥 설치 가능");
                     }
                 }
                 //만약 보면
                 if (structType == 1) {
                     //한쪽끝에 기둥이있거나
                     if (map[y][x].down != null || map[y][x+1].down!=null) {
                         map[y][x].right = map[y][x+1];
                         map[y][x].right.left = map[y][x];
                         map[y][x].right.isConnected = true;
                         System.out.println(x+"행"+y+"렬"+"오른쪽으로 보설치");
                     }
                     //양쪽끝부분이 동시에 다른보와 연결되거나
                     else if(map[y][x].left !=null && map[y][x].right.right !=null){
                         map[y][x].right = map[y][x+1];
                         map[y][x].right.left = map[y][x];
                         map[y][x].right.isConnected = true;
                         System.out.println(x+"행"+y+"렬"+"오른쪽으로 보설치");
                     }
                 }
             }
             //삭제할때
             if(actionType == 0) {

                 boolean canDelect = false;
                 //만약 기둥이면
                 if (structType == 0) {
                     location tmp = map[y][x].up;
                     location left = tmp.left;
                     location right = tmp.right;
                     //만약왼쪽 오른쪽에 둘다 보가 있으면
                     if(left!=null && right != null){
                         //둘다 이어져 있거나
                         if(left.left!=null && right.right!=null) canDelect = true;
                         //또는 왼쪽아래에 기둥이있고 오른쪽은 이어져 있던가
                         if(left.down!=null && right.right!=null) canDelect = true;
                         //오른쪽 아래에 기둥이 있고 왼쪽은 이어져 있던가
                         if(left.left!=null && right.down!=null) canDelect = true;
                         //둘다 아래에 기둥있거나
                         if(left.down!=null && right.down!=null) canDelect = true;
                     }

                     //한쪽에만 보가 있으면
                     if(left == null & right !=null){
                         if(right.down != null) canDelect = true;
                     }

                     if(left != null & right ==null){
                         if(left.down != null) canDelect = true;
                     }
                     if(left==null & right == null){
                         canDelect =true;
                     }


                 }
                 //만약 보면
                 if (structType == 1) {
                     location tmp = map[y][x];
                     //보의 왼쪽보
                     location left = tmp.left;
                     //보의 오른쪽보
                     location right = tmp.right.right;
                     //둘다 있는경우
                     if(left!=null && right != null){
                         //둘의 반대쪽에 다리없음 못삭제
//                         if((left.down !=null && right.left.down!=null) || tmp. down){
//                             tmp.left.right = null;
//                             tmp.right.left.left = null;
//                             tmp.left = null;
//                             tmp.right = null;
//                             if(tmp.down == null) tmp.isConnected = false;
//                         }
                     }

                     //한쪽에만 보가 있으면
                     if(left == null & right !=null){
                         if(right.left.down != null) canDelect = true;
                     }

                     if(left != null & right ==null){
                         if(left.down != null) canDelect = true;
                     }


                 }
             }
         }
        System.out.println();
    }

    static class location{
        location up,down,left,right;
        boolean isConnected;

        public location(boolean isConnected) {
            this.isConnected = isConnected;
        }
    }
}
