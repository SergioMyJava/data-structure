package map;

import java.util.List;

public class App {

    public static void main(String[] args){
        SimpleMap exp = new SimpleHashMap();

        System.out.println("Size : "+exp.getSize());
        exp.put("Л.Н. Толстой","Детство");
        exp.put("Л.Н. Ленин","Мир");
        exp.put("А.Н. Чехов","По Сибири");
        exp.put("Гоголь","Мертвые души");
        exp.put("Пушкин","Онегин");
        exp.put("Лермонтов","Бородино");
        System.out.println("Size : "+exp.getSize());

        List key = exp.keys();
        for(Object a:key){
            System.out.println(a);
        }

        List val = exp.values();
        for(Object a:val){
            System.out.println(a);
        }

    }
}
