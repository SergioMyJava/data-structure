package linkedList;

public class App {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> exp = new SimpleLinkedList();

        exp.add(12);
        exp.add(1);
        exp.add(2);
        exp.add(129);
        exp.add(987768764);
        exp.add(-5);
        exp.add(0);

        System.out.println(exp.get(1));
        System.out.println(exp.get(5));
        System.out.println(exp.get(6));
        System.out.println(exp.get(5));

        System.out.println(exp.delete(6));
        System.out.println(exp.delete(0));
        System.out.println(exp.delete(2));
        System.out.println(exp.delete(3));
        System.out.println(exp.getSize());

        for (Object a : exp) {
            System.out.println(a);


        }
    }
}


