package jdk;

/**
 * Created by ts250370 on 1/19/18.
 */
public class Closure {

    interface ProcessIF {
        void process(int i);
    }



    public static void main(String[] args) {
        Closure closure = new Closure();
        closure.instanceTest();
    }


    private void instanceTest() {
        int a = 10;
        int b = 20;

        doProcess(a, new ProcessIF() {
            @Override
            public void process(int i) {
                System.out.println(i + b);
            }
        });

        doProcess(a, (x)->System.out.println(x + b) );
    }

    static void doProcess(int i, ProcessIF process) {
        process.process(i);
    }
}

