package BOJ_Study.Bronze;


import java.util.Scanner;

public class B1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subjectNum = scanner.nextInt();

        int[] scoreArray = new int[subjectNum];

        for(int i =0; i<subjectNum; i++){
            scoreArray[i] = scanner.nextInt();
        }
        //System.out.println(Arrays.toString(scoreArray));
        int max = scoreArray[0];
        for(int i=0; i<subjectNum; i++){
            if(scoreArray[i]>max) max=scoreArray[i];
        }

        double tmp;
        double sum = 0;
        for(int i=0; i<subjectNum; i++){
            tmp = (scoreArray[i]/(double)max)*100;
            sum = sum + tmp;
        }
        System.out.printf("%.14f",sum/subjectNum);

    }
}
