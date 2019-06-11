package map;

import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String[] args){

        SimpleTreeMap<Integer,String> exp1 = new SimpleTreeMap();
        Iterator iterator =  exp1.iterator();
        exp1.put(1,"one");
        exp1.put(2,"two");
        exp1.put(3,"three");
        exp1.put(4,"for");
        System.out.println(exp1.get(1));
        System.out.println(exp1.get(2));
        System.out.println(exp1.get(3));
        System.out.println(exp1.get(4));
        System.out.println(" ");
        List t = exp1.keys();

        for(int i = 0; i<t.size();i++){
            System.out.println(t.get(i));
        }

        System.out.println(exp1.getRott());

        System.out.println("test iterator ");//тут я пытаюсь итератор проверить
        if (iterator.hasNext() == true){
            System.out.println(iterator.next());
        }
    }
}
