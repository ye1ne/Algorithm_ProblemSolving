package baaarkingDogWorkBook.x0D_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class G16985 {
    static List<int[][]> cubeList = new ArrayList<>();
    static List<int[]> combinationList =new ArrayList<>();
    static boolean[] isVisited = new boolean[5];
    static int[][][] cube = new int[5][5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int height = 0; height<5; height++){
            int[][] cube = new int[5][5];
            for(int row =0; row<5; row++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int col =0; col<5; col++){
                    cube[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            cubeList.add(cube);
        }
        addCombination(0,new int[5]);

        for(int i=0; i< combinationList.size(); i++){
            for(int j=0; j<5; j++){
                cube[j] = cubeList.get(combinationList.get(i)[j]);
            }


            System.out.println();
        }
        System.out.println();

    }

    static void rotationCube(int[][] matrix){
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    static void addCombination(int count, int[] list){

        if(count == 5){
            int[] result = Arrays.copyOf(list,list.length);
            combinationList.add(result);
            return;
        }
        for(int i=0; i<5; i++){
            if(!isVisited[i]){
                list[count] = i;
                isVisited[i] = true;
                addCombination(count+1,list);
                isVisited[i] = false;
            }
        }
    }

}
