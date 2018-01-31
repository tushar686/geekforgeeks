package jdk;

import java.util.function.BiConsumer;

/**
 * Created by ts250370 on 1/19/18.
 */
public class LambdaExceptions {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        int key = 0;
        process(values, key,
                wrapperLambda( (i, k)-> System.out.println(i / k) )
        );
    }

    private static void process(int[] values, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i: values) {
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            }catch (Exception e) {
                System.out.println("Exception occurred");
            }
        };
    }
}
