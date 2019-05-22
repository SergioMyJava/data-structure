package map;

public class App {

    public static void main(String[] args){
    SimpleMap<String,Integer> exp = new SimpleTreeMap();
        exp.put("one",1);
        exp.put("two",2);
        exp.put("three",3);
        exp.put("for",4);
        System.out.println(exp.getSize());
        System.out.println(exp.get("one"));
        System.out.println(exp.get("three"));
        System.out.println(exp.get("for"));
    }
}
