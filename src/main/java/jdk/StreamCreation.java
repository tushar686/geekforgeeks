package jdk;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ts250370 on 1/21/18.
 */
public class StreamCreation {

    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(
                ()-> "element"
        ).limit(2);
        stream.forEach(System.out::println);

        Stream iterator = Stream.iterate(10, n -> n+2).limit(2);
        iterator.forEach(System.out::println);

        Stream<String> streamBuilder = Stream.<String>builder()
                .add("1")
                .add("2").build();
        streamBuilder.forEach(System.out::println);

        Stream<Integer> streamArray = Arrays.stream(new Integer[] {1, 2});
        streamArray.forEach(System.out::println);


        List<String> list = Stream.of("a", "b", "c", "bb")
                .filter(s->s.startsWith("d"))
                .collect(Collectors.toList());

        Optional<String> op = list.stream().findFirst();
        System.out.println(op);

        Map<Boolean, List<String>> collectStream = Stream.of("a", "ab", "bc", "bd")
                .collect(Collectors.partitioningBy(
                        ele->ele.startsWith("a")
                    )
                );

        System.out.println(collectStream);
    }
}
