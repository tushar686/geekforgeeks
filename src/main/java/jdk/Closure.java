package jdk;

/**
 * Created by ts250370 on 1/19/18.
 */
public class Closure {

    @FunctionalInterface
    interface MultiplyIF {
        void multiply(int i);
    }

    public static void main(String[] args) {
        MultiplyIF multiplyBy10 = (x) -> { System.out.println( x * 10 ); };
        multiplyBy10.multiply(20);
    }
}

