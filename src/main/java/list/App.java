package list;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static class Cat {}

    public static void main(String[] args) {
        SimpleList<Cat> exp = new SimpleLinkedList<>();
        exp.add(new Cat());
        exp.add(new Cat());

        System.out.println(exp.get(exp.size() - 1));
        System.out.println(exp.size());

        exp.delete(exp.size() - 1);

        System.out.println(exp.get(exp.size() - 1));
        System.out.println(exp.size());

//        exp.delete(exp.size() - 1);
//
//        System.out.println(exp.get(exp.size() - 1));
//        System.out.println(exp.size());
    }
}
