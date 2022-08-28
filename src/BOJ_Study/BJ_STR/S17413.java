package BOJ_Study.BJ_STR;

import java.io.*;
import java.util.Stack;

public class S17413 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String result = "";
        Stack<String> s = new Stack<>();
        boolean[] isString = new boolean[input.length()];
        boolean isTag = false;

        for(int i =0; i<isString.length;i++){
            String tmp =Character.toString(input.charAt(i));

            if(tmp.equals("<")) {
                while(!s.isEmpty())
                    result+=s.pop();
                isTag = true;
            }
            else if(tmp.equals(">")) {
                result+=">";
                isTag = false;
                continue;
            }else if(tmp.equals(" ")){
                while(!s.isEmpty())
                    result+=s.pop();
                result+=" ";
                continue;
            }

            if(isTag){
                result+=tmp;
            }else{
                s.push(tmp);
            }
        }
        while(!s.isEmpty())
            result+=s.pop();

        System.out.println(result);
    }
}
