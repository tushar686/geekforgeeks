package jdk;

/**
 * Created by ts250370 on 5/7/18.
 */
public class Generics {

    class Box <T> {
        private T t;

        void add(T t) {
            this.t = t;
        }

        T get(){
            return this.t;
        }
    }

    class Colors <T, U> {
        T t;
        U u;
        Colors(T t, U u) {
            this.t = t;
            this.u = u;
        }

        T getFirstColor(){
            return t;
        }

        U getColorSec() {
            return u;
        }
    }


    //method generic
    static <T> void printMe(T t) {
        System.out.println("Printing " + t);
    }

    public static void main(String[] args) {
        Generics generics = new Generics();
        Box<Integer> intBox = generics.new Box<>();
        intBox.add(10);
        System.out.println(intBox.get());
        Box<String> strBox = generics.new Box<>();
        strBox.add("Hello");
        System.out.println(strBox.get());

        Generics generics1 = new Generics();
        Colors<String, Integer> colors = generics1.new Colors<>("RED", 12);
        System.out.println(colors.getFirstColor());
        System.out.println(colors.getColorSec());

        printMe("Tushar");
        printMe(10);
    }

}
