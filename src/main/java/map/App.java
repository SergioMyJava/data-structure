package map;

import com.sun.javafx.collections.MappingChange;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App<V> {

    public int binarySearch(int number, int[] list) {
        return realSearch(list,number,0,list.length);
    }

    public int realSearch(int[] list,int number,int left,int right){
        int index = left + (right - left)/2;
        if(list[index] == number){
            return index;}
        if(list[index] > number){
            return realSearch(list,number,left,index);}
        else
            return realSearch(list,number,index+1,right);

    }


    public static void main(String[] args){

    SimpleMap<Integer,String> exp1 = new SimpleTreeMap();
        exp1.put(1,"one");
        exp1.put(2,"two");
        exp1.put(3,"three");
        exp1.put(4,"for");
        List exp2 = exp1.values();
        System.out.println(exp1.getSize());
        System.out.println(exp2.size());
        for(int i = 0;i< exp1.getSize();i++){
            System.out.println(exp2.get(i));
        }
//        System.out.println(exp.getSize());
//        System.out.println(exp.get(1));
//       System.out.println(exp.get(3));
//        System.out.println(exp.get(2));
//        SimpleTreeMap exp = new SimpleTreeMap();
//        exp.put(1, "one");
//        exp.put(2, "two");
//        exp.put(3, "three");
//        exp.put(4, "for");
//        System.out.println(exp.getByTheKey(3, exp.root));
//
////            App test = new App();
////            System.out.println(test.factorial(5));
//    }
}}
