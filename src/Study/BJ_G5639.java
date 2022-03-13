package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_G5639 {
    static class Info{
        int num;
        Info leftNode, rightNode, rootNode;
        public Info(int num) {
            this.num = num;
        }

        public void setLeftNode(Info leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Info rightNode) {
            this.rightNode = rightNode;
        }

        public void setRootNode(Info rootNode) {
            this.rootNode = rootNode;
        }
    }
    static Info[] list;
    static List<Integer> inputList = new ArrayList<>();

    static void postorder(Info Node){
        if(Node!= null) {
            postorder(Node.leftNode);
            postorder(Node.rightNode);
            System.out.println(Node.num);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmpStr = "";
        while(!(tmpStr = br.readLine()).equals("-1")){//(tmpStr = br.readLine())!= null){
            int tmpValue = Integer.parseInt(tmpStr);
            inputList.add(tmpValue);
        }
        int size = inputList.size();
        list = new Info[size];
        list[0] = new Info(inputList.get(0));
        for(int i=1;i<size; i++){
            int tmpNum = inputList.get(i);
            if(tmpNum<inputList.get(i-1)){
                list[i] = new Info(tmpNum);
                list[i].setRootNode(list[i-1]);
                list[i].rootNode.setLeftNode(list[i]);
            }else{
                int tmpIndex = i;
                while(inputList.get(--tmpIndex)<=tmpNum){
                    if(tmpIndex == 0) {
                        tmpIndex = -1;
                        break;
                    }
                }
                tmpIndex++;
                list[i] = new Info(tmpNum);
                list[i].setRootNode(list[tmpIndex]);
                list[i].rootNode.setRightNode(list[i]);
            }

        }
        postorder(list[0]);
    }
}
