import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {

    static class Fruit {
        public Fruit (String taste) {this.taste = taste;}
        public String taste;
        public Integer weight;
    }
    static class Vehicle {
        public String color;
        public Integer wheels;
    }

    static void takesClass (Class someClass) {
        System.out.println("============== takesClass============");
        System.out.println(someClass.getName());
        for (Field f : someClass.getFields()) {
            System.out.println(f.getName() + ": " + f.getType().getName());
        }
    }
    static void takesObj (Object someObj) {
        System.out.println("============== takesObj ============");
        System.out.println(someObj.getClass().getName());
        try {
            if (someObj.getClass().getField("weight") != null) {
                someObj.getClass().getField("weight").set(someObj, 10);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        for (Field f : someObj.getClass().getFields()) {
            try {
                System.out.println(f.getName() + ": " + f.get(someObj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        takesClass(Fruit.class);
        takesClass(Vehicle.class);
        takesObj(new Fruit("sweet"));
        takesObj(new Fruit("sour"));
        takesObj(new Vehicle());

    }
}
