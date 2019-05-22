package map;

public class App {

    public static void main(String[] args){
//    SimpleMap<Integer,String> exp = new SimpleTreeMap();
//        exp.put(1,"one");
//        exp.put(2,"two");
//        exp.put(3,"three");
//        exp.put(4,"for");
//        System.out.println(exp.getSize());
//        System.out.println(exp.get(1));
//       System.out.println(exp.get(3));
//        System.out.println(exp.get(2));
        SimpleTreeMap exp = new SimpleTreeMap();
        exp.put(1,"one");
        exp.put(2,"two");
        exp.put(3,"three");
        exp.put(4,"for");
        System.out.println(exp.getByTheKey(3,exp.root));


    }
}
