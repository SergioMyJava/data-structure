package arraylist;

import linkedlist.SimpleList;

import java.util.Iterator;

public class App {

    public static void main(String[] args){
        SimpleList<Integer> exp = new SimpleArrayList<>();

        exp.add(12);
        exp.add(34);
        exp.add(1);
        exp.add(3);
        System.out.println(exp.getSize());
        exp.delete(1);
        System.out.println(exp.get(2));
        System.out.println(exp.getSize());
        System.out.println("--------------");
        Iterator iter = exp.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        for(Object a : exp){
            System.out.println(a);
        }

    }
}
