package map;

public class App {

    public int factorial(int n){
        System.out.println("начало работы " + n);
        int k =0;

        if(n == 1)return 1;

        System.out.println(n);

        k = factorial(n-1)*n;

        System.out.println("конец работы " + n);;
        return k;
    }



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

//            App test = new App();
//            System.out.println(test.factorial(5));
    }
}
