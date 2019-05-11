package stack;

public class App {
    public static void main(String[] args) {
        SimpleStack<Integer> exp = new SimpleArrayStack<>();
        exp.put(0);
        exp.put(1);
        exp.put(2);
        exp.put(3);
        exp.put(4);
        exp.put(5);
        exp.put(0);
        exp.put(1);
        exp.put(2);
        exp.put(3);
        exp.put(4);
        exp.put(98);
        System.out.println(exp.getSize());
        System.out.println(exp.peek());
        System.out.println(exp.peek());
        System.out.println(exp.pop());
        System.out.println(exp.pop());
        System.out.println(exp.getSize());

//        Iterator<Integer> iter = exp.iterator();
//        for(int a : exp){
//        System.out.println(a);
//        }
    }
}
