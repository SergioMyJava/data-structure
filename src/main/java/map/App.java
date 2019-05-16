package map;

public class App {

    public static void main(String[] args){
        SimpleMap exp = new SimpleHashMap();
        System.out.println("Size : "+exp.getSize());
        exp.put("Л.Н. Толстой","Детство");
        System.out.println("Size : "+exp.getSize());
        exp.put("Л.Н. Ленин","Мир");
        System.out.println("Size : "+exp.getSize());
        System.out.println(exp.get("Л.Н. Ленин"));
        System.out.println("Size : "+exp.getSize());
    }
}
