import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        Car2 car2 = new Car2();
        car2.printCar();
        Vector<Integer> vector = new Vector<>();

    }


    public class test{

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