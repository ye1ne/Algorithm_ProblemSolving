package BOJ_Study.BJ_various;

import java.io.*;
import java.util.LinkedList;

public class BJ_V_S1406_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<Character>();
        for(int i=0; i<str.length();i++){
            list.addLast(str.charAt(i));
        }
        int cursor = list.size();

        for(int i =0; i<M; i++){
            String input = br.readLine();
            char c = input.charAt(0);
            switch (c){
                case 'L':
                    if(cursor!=0) cursor = cursor-1;
                    break;
                case 'D':
                    if(cursor!=(list.size()))  cursor = cursor+1;
                    break;
                case 'B':
                    if(cursor!=0) {
                        list.remove(cursor-1);
                        cursor--;
                    }
                    break;
                case 'P':
                    char t = input.charAt(2);
                    list.add(cursor,t);
                    cursor ++;
                    break;
                default:
                    break;
            }


        }
          for(Character chr : list) {
            bw.write(chr);
        }
        bw.flush();
        bw.close();
    }
}
