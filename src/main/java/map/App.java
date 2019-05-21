package map;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {

    public static void main(String[] args){
        SimpleMap exp = new SimpleHashMap();
        Map<Integer,String> test = new TreeMap<Integer,String>();
        test.put(1,"one");
        test.put(1,"two");
        System.out.println(test.get(1));
//        for(Object a:val){
//            System.out.println(a);
//        }
//
//        System.out.println(exp.ontainsKey("Гог"));
//
    }
}
