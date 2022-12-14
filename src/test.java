import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static int studentCode = 1000;	// 인스턴스들이 공유하는 변수
    private String name;
    private int score;

    public static int getStudentCode(){	// static method
        int a = 0;
        return studentCode;
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[3];
        list[0] = 1;
        list[1] = 2;

        Integer[] newList = Arrays.copyOf(list, 10);
        newList[5] = 6;
        System.out.println();

    }
}
