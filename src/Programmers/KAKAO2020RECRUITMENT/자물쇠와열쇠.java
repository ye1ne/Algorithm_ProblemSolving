package Programmers.KAKAO2020RECRUITMENT;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
//        int[][] key = {{0,1},{1,0},{0,1}};
//        int[][] lock = {{0,1,1},{1,0,1},{1,1,1}};
        int[][] key = {{0,1},{1,1},{0,1}};
        int[][] lock = {{0,1,1},{1,0,1},{1,1,1}};

        for(int rotate = 0; rotate<4; rotate++) {
            for (int i = 0; i < lock.length; i++) {
                for (int j = 0; j < lock.length; j++) {
                    if (isKey(key, lock, i, j)) {
                        System.out.println(true);
                    }
                }
            }
            key = rotation(key);
        }
        System.out.println(false);

    }

    static boolean isKey(int[][] key, int[][] lock, int startR, int startC) {


        //열쇠의 모든 행과 열을 기준으로 시작해서
        for(int keyi = 0; keyi< key.length; keyi++) {
            KeyLoop:
            for (int keyj = 0; keyj < key[0].length; keyj++) {

                LockLoop:
                //자물쇠의 모든 행과 열에 대해서 맨 위를 기준으로 하나씩 대봄
                for (int i = 0; i < lock.length; i++) {
                    InnerLoop:
                    for (int j = 0; j < lock.length; j++) {

                        //만약에 두개다 존재하는 상황이 아니면
                        if (i-startR+keyi < 0|| j-startC+keyj < 0 || i-startR+keyi>=key.length || j-startC+keyj >= key[0].length) {
                            if (lock[i][j] != 1) continue KeyLoop;
                        } else {
                            if (i - startR >= key.length || j - startC >= key[0].length) {
                                if (lock[i][j] != 1) continue KeyLoop;
                                continue InnerLoop;
                            }
                            if (lock[i][j] + key[i-startR+keyi][j-startC+keyj] != 1) continue KeyLoop;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    static int[][] rotation(int[][] key){
        int[][] tmpKey = new int[key[0].length][key.length];

        for(int i=0; i<tmpKey.length; i++){
            for(int j=0; j< tmpKey[0].length; j++){
                tmpKey[i][j] = key[key.length-1-j][i];
            }
        }
        return tmpKey;
    }
}
