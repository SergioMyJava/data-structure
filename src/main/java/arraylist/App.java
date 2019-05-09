package arraylist;

import simplelist.SimpleList;

import java.util.ArrayList;
import java.util.Iterator;

public class App {

    public static void main(String[] args) {
        SimpleList<Integer> exp = new SimpleArrayList<>();

        exp.add(0);
        exp.add(1);
        exp.add(2);
        exp.add(3);
        exp.add(4);
        exp.add(5);
        exp.add(6);
        exp.add(7);
        exp.add(8);
        exp.add(9);
        exp.add(10);

        System.out.println("Первичный размер " + ((SimpleArrayList<Integer>) exp).arrayLanth());

        exp.delete(0);
        exp.delete(1);
        System.out.println("Размер после удаления " + exp.size());
        System.out.println("--------------");

        for (Object a : exp) {
            System.out.println(a);
        }
    }
}
