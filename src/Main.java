import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("# 0 0")) break;
            StringTokenizer st = new StringTokenizer(str);
            String name = st.nextToken();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.print(name + " ");

            if (N > 17 || M >= 80) {
                System.out.println("Senior");
            } else
                System.out.println("Junior");


        }
    }

    static class Car{
        String color; // 인스턴스 변수
        String gearType;
        int door;

        Car(){
            this("white", "auto", 4); // Car(String color, string gearType, int door)를 호출
        }

        Car(String color){
            this(color, "auto", 4);
        }

        Car(String color, String gearType, int door){
            this.color = color;
            this.gearType = gearType;
            this.door = door;
        }
    }

}