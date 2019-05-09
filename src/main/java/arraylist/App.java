package arraylist;

import simplelist.SimpleList;

import java.util.ArrayList;
import java.util.Iterator;

public class App {
     static int [] b;

    public static void main(String[] args){
        SimpleList<Integer> exp = new SimpleArrayList<>();

        exp.add(0);
        exp.add(1);
        exp.add(2);
        exp.add(3);
        exp.add(4);
        exp.add(5);
        exp.add(6);
        exp.add(7);
        System.out.println(exp.size());
        exp.delete(1);
        System.out.println(exp.get(2));
        System.out.println(exp.size());
        System.out.println("--------------");
        Iterator iter = exp.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        for(Object a : exp){
            System.out.println(a);
        }


//        ArrayList<Integer> a = new ArrayList<Integer>();
//        a.add(12);
//        Iterator iter =a.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//            }
//        }
//        int c = a[0];
//        int d = a[1];
//        System.out.println(c+d);
    }
}
