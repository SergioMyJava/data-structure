package LinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[]args){
        SimpleList<Integer> test = new SimpleLinkedList();
        test.add(12);
        test.add(13);
        test.add(15);
        test.add(1);
        System.out.println(((SimpleLinkedList) test).size);
        System.out.println(test.delete(2));
        System.out.println(((SimpleLinkedList) test).size);
        System.out.println(test.get(2));

        Iterator itr = test.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("------------------");
        for(Object a : test){
            System.out.println(a);
        }

    }
}
