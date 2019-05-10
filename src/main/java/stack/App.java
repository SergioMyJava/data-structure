package stack;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        SimpleStack<Integer> exp = new SimpleStackLinked<>();
        exp.put(1);
        exp.put(2);
//        exp.put(3);
//        exp.put(4);
//        exp.put(5);
//        exp.put(6);
//        System.out.println(exp.peek());
//        System.out.println(exp.peek());
//        //Iterator<Integer> iter = exp.iterator();
        for(int a : exp){
        System.out.println(a);
        }
    }
}
