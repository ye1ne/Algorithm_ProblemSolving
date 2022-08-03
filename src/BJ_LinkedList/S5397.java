package BJ_LinkedList;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class S5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        LinkedList<Character> list;
        while(count-->0){
            list = new LinkedList<>();
            int length = 0, location = 0;
            String str = br.readLine();
            for(int i =0; i<str.length(); i++){
                char c = str.charAt(i);
                switch (c){
                    case '<':
                        if(location-1>=0){
                            location--;
                        }
                        break;
                    case '>':
                        if(location+1<=length){
                            location++;
                        }
                        break;
                    case '-':
                        if(location!=0){
                            list.remove(location-1);
                            length--;
                            location--;
                        }
                        break;
                    default:
                        list.add(location,c);
                        length++;
                        location++;
                        break;

                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c : list){
                sb.append(c);
            }
            bw.write(sb+"\n");
        }

        bw.flush();
        bw.close();
    }
}
