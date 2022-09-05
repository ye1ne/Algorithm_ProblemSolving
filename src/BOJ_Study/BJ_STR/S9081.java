package BOJ_Study.BJ_STR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S9081 {

    static int length;
    static String resultStr, str;
    static char[] strArr;
    static boolean[] isSelected;
    static boolean flag, getResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(TC -->0){
            flag =false;
            getResult = false;
            str = br.readLine();
            strArr = str.toCharArray();
            Arrays.sort(strArr);

            isSelected = new boolean[str.length()];
            length = str.length();
            StringBuilder tmpSb = new StringBuilder();
            charSet(0, tmpSb);
            resultStr = tmpSb.toString();
            sb.append(resultStr+"\n");
        }
        System.out.println(sb);
    }

    static void charSet( int count, StringBuilder tmpSb){
        if(getResult) return;
        if(count == length){

            if(flag) {
                resultStr = tmpSb.toString();
                flag = false;
                getResult =true;
                return;
            }
            if(tmpSb.toString().equals(str))
                flag = true;

            return;

        }
        for(int i = 0; i<strArr.length; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            tmpSb.append( strArr[i]);
            charSet(count+1,tmpSb);
            if(getResult) return;
            isSelected[i] = false;
            tmpSb.deleteCharAt(tmpSb.length()-1);
        }
    }
}
