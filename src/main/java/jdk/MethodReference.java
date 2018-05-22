package jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by ts250370 on 1/19/18.
 */
public class MethodReference {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(10);
                add(20);
                add(5);
            }
        };

        performConditionaly(list,
                a-> a >= 10,
                System.out::println
                );
    }

    static void performConditionaly(
            List<Integer> numbers,
            Predicate<Integer> predicate,
            Consumer<Integer> consumer
    ) {
        for (int ele : numbers) {
            if (predicate.test(ele)) {
                consumer.accept(ele);
            }
        }
    }
}
