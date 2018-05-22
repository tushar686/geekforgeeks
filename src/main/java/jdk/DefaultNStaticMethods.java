package jdk;

interface XIF {
    default void test() {
        System.out.println("This is default implementation");
    }
}

/**
 * Created by ts250370 on 4/18/18.
 */
public class DefaultNStaticMethods implements XIF {

    public static void main(String[] args) {
        DefaultNStaticMethods defaultNStaticMethods = new DefaultNStaticMethods();

    }

}
