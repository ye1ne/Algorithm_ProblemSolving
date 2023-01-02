package baaarkingDogWorkBook.x05_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P3015_오아시스재결합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] duplicateNumber = new int[N];
        Stack<Person> stack = new Stack<>();

        long count = 0;

        for(int number = 0; number < N; number++){
            int height = Integer.parseInt(br.readLine());
            Person person = new Person(height,1);
            //높이 값이 더 큰게 나올때까지 pop한다
            while(!stack.isEmpty()&& stack.peek().height <= height) {
                Person pop = stack.pop();
                count += pop.count;
                if(pop.height == height)
                    person.count+= pop.count;
            }
            if(!stack.isEmpty()){
                count++;
            }

            stack.push(person);

        }
        System.out.println(count);
    }

    static class Person{
        int height;
        int count;

        public Person(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
}
