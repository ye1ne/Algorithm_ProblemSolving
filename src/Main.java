import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String param0 = "happy";
        int tmp  = param0.charAt(2) - 'a';
        int row = tmp/6;
        int col = tmp%6;
        System.out.println(row+" "+col);
        List<Integer>[] list = new List[10];
        list[0] = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.toString();
        set.size();
        list[0].size();

    }




    static class Car2 extends Car{

//        @Override
        void printCar() {
            System.out.println("Car2");
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
        void printCar(int a){
            System.out.println("color: " + color + ", gearType: " + gearType + ", door: " + door);
        }
    }

}