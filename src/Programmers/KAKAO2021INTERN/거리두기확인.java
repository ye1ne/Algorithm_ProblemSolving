package Programmers.KAKAO2021INTERN;

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }


    static public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int count = 0;
        OuterLoop:
        for(String[] place: places){
            if(count == 2)
                System.out.println();
            Queue<int[]> queue = new LinkedList<>();
            String[][] map = new String[place.length][place[0].length()];
            isVisited = new boolean[place.length][place[0].length()];
            for(int r =0; r<map.length; r++){
                for(int c=0; c<map[r].length; c++){
                    map[r][c] = Character.toString(place[r].charAt(c));
                    if(map[r][c].equals("P")) queue.add(new int[]{r,c});
                }
            }


            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curRow = cur[0];
                int curCol = cur[1];
                InnerLoop:
                for(int i=0; i<4; i++) {
                    isVisited[curRow][curCol] =true;
                    boolean result = isOK( curRow +drOne[i], curCol+ dcOne[i], map);
                    if (result == false) {
                        answer[count] = 0;
                        count++;
                        continue OuterLoop;
                    }
                    if(isX(curRow +drOne[i], curCol+ dcOne[i], map)) continue InnerLoop;
                    for(int j=0; j<4; j++) {
                        int row = curRow+drOne[i] +drOne[j];
                        int col = curCol+  dcOne[i]+dcOne[j];
                        result = isOK( curRow+drOne[i] +drOne[j], curCol+  dcOne[i]+dcOne[j], map);
                        if (result == false) {
                            answer[count] = 0;
                            count++;
                            continue OuterLoop;
                        }
                    }
                }
            }
            answer[count] = 1;
            count++;
        }
        return answer;
    }
    static boolean[][] isVisited;
    static boolean isOK(int row, int col,String[][] map){
        //만약 개 상하좌우가 범위 벗어나면 ok;
        if(row<0 || row >= map.length || col<0 || col>=map[0].length) return true;

        //방문한 경험있으면 체크 완료한거니까 ㄱㅊ
        if(isVisited[row][col]) return true;
        //x여도 괜찮
        if(map[row][col].equals("X")) return true;
        //사람있으면 안됨
        if(map[row][col].equals("P")) return false;
        isVisited[row][col] = true;
        return true;
    }
    static boolean isX(int row, int col,String[][] map){

        if(row<0 || row >= map.length || col<0 || col>=map[0].length) return false;
        if(map[row][col].equals("X")) return true;
        return false;
    }

    static int[] drOne = {0,0,-1,1};
    static int[] dcOne = {-1,1,0,0};




}
