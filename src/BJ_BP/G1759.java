package BJ_BP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1759 {

    static int L,C;
    static char[] arr;
    static char[] vowel={'a','e','i','o','u'};
    static int countVowel = 0, countConsonant = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());

        for(int i =0; i<C;i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        combination(0,L);
    }

    static void combination(int start,int length){
        if(length == 0){
            printCombination();
            return;
        }

        for(int i =start; i<C;i++){
            if(isVowel(arr[i])) countVowel++;
            else countConsonant++;
            visited[i] = true;

            combination(i+1,length-1);

            if(isVowel(arr[i])) countVowel--;
            else countConsonant--;
            visited[i] = false;
        }
    }
    static boolean isVowel(char c){
        for(int i =0; i<vowel.length;i++){
            if(c == vowel[i]) return true;
        }
        return false;
    }
    static void printCombination() {
        if(countVowel == 0 || countConsonant<2){
            return;
        }
        for (int i = 0; i < C; i++) {
            if (visited[i]) {
                System.out.print(arr[i]);
            }
        }
        System.out.println();
    }
}
