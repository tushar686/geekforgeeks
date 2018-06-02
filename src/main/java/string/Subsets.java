package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ts250370 on 9/21/17.
 */
public class Subsets {
    static String input = "ABC";
    static List<String> subset = new ArrayList<String>();

    public static void main(String[] args) {
        findAllPowerSets();
        for(String set: subset) {
            System.out.println(set);
        }
    }

    static void findAllPowerSets() {
    }

}
