package Programmers.KAKAO2020RECRUITMENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 기둥과보설치2 {
    public static void main(String[] args) {
        int n = 100;
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};

        //x, y ,기둥(0) 보(1) , 삽입(1) 삭제(0)
//        int[][] build_frame = {{2, 0, 0, 1}, {100, 0, 0, 1}, {100, 1, 1, 1}, {99, 1, 1, 1}, {99, 1, 0, 1}, {99, 0, 0, 1}};
//        int[][] build_frame = {{0,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{2,1,0,1},{3,0,0,1},{2,1,1,1},{1,1,1,1}};
        solution(n,build_frame);
    }


    static public int[][] solution(int n, int[][] build_frame) {

        int[][][] map = new int[n+1][n+1][2];
        for(int i=0; i< build_frame.length; i++){
            int c = build_frame[i][0];
            int r = build_frame[i][1];
            int type =  build_frame[i][2]; //기둥0, 보1
            int action = build_frame[i][3]; //삭제0, 설치1

            //생성한다고 할때
            if(action == 1){
                //기둥 생성
                if(type == 0){
                    //맨아랫줄이면 무조건 가능
                    if(r == 0){
                        map[r][c][type] = 1;
                    }else{
                        //아래에 기둥있으면 가능
                        if(r-1>=0 && map[r-1][c][0]==1){
                            map[r][c][type] = 1;
                        }
                        //아래에 보가 있어도 가능
                        else if(map[r][c][1] ==1){
                            map[r][c][type] = 1;
                        }
                        //또는 왼쪽에서오는 보가 있어도 가능
                        else if(c-1>=0 && map[r][c-1][1] ==1){
                            map[r][c][type] = 1;
                        }

                    }
                }

                //보 생성
                else if(type == 1){
                    //아래에 기둥이있거나
                    if(r-1>=0 &&  map[r-1][c][0]==1){
                        map[r][c][type] = 1;
                    }
                    //오른쪽아래에 기둥이있거나
                    else if(r-1>=0  & c+1<=n && map[r-1][c+1][0]==1){
                        map[r][c][type] = 1;
                    }
                    //또는 양쪽으로 보가 동시에 연결되던가
                    else if(c+1<=n && c-1>=0 && map[r][c-1][1] ==1 && map[r][c+1][1] ==1){
                        map[r][c][type] = 1;
                    }
                }

            } else {//삭제한다고 할때
                //기둥 삭제
                if(type == 0) {
                    //위에 왼쪽에서 오는 보가있다면
                    if(c-1>=0 && r+1<=n &&map[r+1][c-1][1] ==1){
                        boolean isOK = false;
                        //보는 연결되어있거나
                        if( c-2>=0 && map[r+1][c-2][1] ==1 && map[r+1][c][1] ==1){
                            isOK =true;
                        }
                        //왼쪽에 기둥이있거나
                        else if(c-2>=0 && map[r][c-2][0]==1){
                            isOK =true;
                        }
                        //오른쪽에 기둥있어야함 근데 오른쪽 기둥은 삭제할거니까 신경 ㄴ
                        //만약 둘중하나안되면 continue
                        if(!isOK) continue;

                    }
                    //위에 오른쪽에서 오는 보가 있다면
                    if(r+1<=n &&map[r+1][c][1] ==1){
                        boolean isOK = false;
                        //보는 연결되어있거나
                        if(c+1 <= n && c-1>=0 && map[r+1][c-1][1] ==1 && map[r+1][c+1][1] ==1){
                            isOK = true;
                        }
                        //왼쪽에 기둥이있거나( 근데여기서는 이거 삭제할거라 신경 ㄴㄴ)
                        //오른쪽에 기둥있어야함
                        else if(c+1<=n && map[r+1][c+1][0]==1){
                            isOK =true;
                        }
                        //만약 둘중하나안되면 continue
                        if(!isOK) continue;

                    }
                    //위에 기둥이 있다면
                    if(r+1<=n && map[r+1][c][0] ==1){
                        boolean isOK = false;
                        //왼쪽 아래에 보가 있거나
                        if(c-1>=0 && map[r+1][c-1][0] ==1){
                            isOK = true;
                        }
                        //오른쪽 아래에 보가 있어야함
                        else if( map[r+1][c][0] ==1){
                            isOK = true;
                        }
                        //기둥은 어짜피 삭제할거임
                        //만약 둘중하나안되면 continue
                        if(!isOK) continue;
                    }
                    //암것도 없을때
                    //바로삭제
                    map[r][c][type] = 0;
                }

                //보 삭제
                if(type == 1){
                    //왼쪽& 오른쪽 보 둘다 있을때
                    if(c-1>=0 && c+1 <=n && map[r][c-1][1] ==1 && map[r][c+1][1] == 1 ){
                        boolean isOk1 = false, isOk2 = false;
                        //만약 왼쪽보가 한쪽이라도 기둥이있으면
                        if( r-1<=n && map[r-1][c-1][0] ==1 || map[r-1][c][0] ==1){
                            isOk1 =true;
                        }
                        //만약 오른쪽보가 한쪽이라도 기둥이 있으면
                        if(c+2<=n && map[r-1][c+1][0] ==1 || map[r-1][c+2][0] ==1){
                            isOk2 =true;
                        }

                        if(!isOk1  || !isOk2) continue;
                    }
                    //왼쪽보가 있을때
                    else if(c-1>=0 && map[r][c-1][1] ==1){
                        boolean isOk1 = false;
                        //만약 왼쪽보가 한쪽이라도 기둥이있으면
                        if( r-1>=0&& map[r-1][c-1][0] ==1 || map[r-1][c][0] ==1){
                            isOk1 =true;
                        }

                        if(!isOk1 ) continue;
                    }
                    //오른쪽 보가 있을때
                    else if(c+1 <=n && map[r][c+1][1] == 1 ){
                        boolean isOk2 = false;

                        //만약 오른쪽보가 한쪽이라도 기둥이 있으면
                        if(c+2<=n && map[r-1][c+1][0] ==1 || map[r-1][c+2][0] ==1){
                            isOk2 =true;
                        }

                        if(!isOk2) continue;
                    }
                    //이거아님 삭제
                    map[r][c][type] = 0;
                }
            }
        }
        List<int[]> result = new ArrayList<>();
        for(int r=0; r<=n; r++){
            for(int c=0; c<=n; c++){
                //기둥
                if(map[r][c][0] == 1) result.add(new int[]{c,r,0});

                //보
                if(map[r][c][1] == 1) result.add(new int[]{c,r,1});
            }
        }
        int[][] answer = new int[result.size()][3];
        int count =0;
        for(int[] arr : result){
            answer[count] = arr;
            count++;
        }
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    if(o1[1]==o2[1]) return o1[1]-o2[1];
                    else  return o1[2]-o2[2];
                }
                return o1[0]-o2[0];
            }
        });
        return answer;
    }

}
