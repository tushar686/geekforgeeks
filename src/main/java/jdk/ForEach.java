package jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ts250370 on 1/20/18.
 */
public class ForEach {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>()
                {
                    {
                        add(5);
                        add(20);
                        add(10);
                    }
                };

        list.forEach(System.out::println);

        System.out.println();

        list.forEach( (p)-> {
                    if (p>10) {
                        System.out.println(p);
                    }
                }

        );
    }
}
