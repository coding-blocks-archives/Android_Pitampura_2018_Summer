import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    static class Fruit {
        public Fruit (String taste) {this.taste = taste;}
        public String taste;
        public Integer weight;
    }
    static class Vehicle {
        public String color;
        public Integer wheels;
        public Integer getAxles () {
            return wheels / 2;
        }
    }

    static void takesClass (Class someClass) {
        System.out.println("============== takesClass============");
        System.out.println(someClass.getName());
        for (Field f : someClass.getFields()) {
            System.out.println(f.getName() + ": " + f.getType().getName());
        }
        for (Method m: someClass.getMethods()) {
            System.out.println(m.getName() + ": " + m.getReturnType().getName());

            // car.getAxles(1)
            // Vehicle.getMethod("getAxles").invoke(car, 1)
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
