package jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ts250370 on 1/20/18.
 */
public class StreamExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>() {
            {
                add(5);
                add(15);
                add(12);
                add(20);
                add(8);
            }
        };

        Stream<Integer> stream = list.stream()
                .filter(p -> p > 10);

        System.out.println(stream.count());

        int sum = list.stream()
                .limit(2)
                .reduce(0, Integer::sum);


        System.out.println(sum);


    }
}
