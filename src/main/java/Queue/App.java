package Queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class App {
    public static void main(String[] args) {

       SimpleQueue<Integer> exp = new SimpleLinkedQueque<>();
        exp.add(1);
        exp.add(2);
        exp.add(3);
        exp.add(4);
        exp.add(5);
//        System.out.println(exp.getSize());
//        System.out.println(exp.peek());
//        System.out.println(exp.peek());

//        System.out.println(exp.poll());
//        System.out.println("size = " + exp.getSize());
//        System.out.println(exp.poll());
//        System.out.println("size = " + exp.getSize());
//        System.out.println(exp.poll());
//        System.out.println("size = " + exp.getSize());
//        System.out.println(exp.poll());
//        System.out.println("size = " + exp.getSize());
//        System.out.println(exp.poll());
//        System.out.println("size = " + exp.getSize());
        for(Integer a : exp){
            System.out.println(a);
        }
    }
}
