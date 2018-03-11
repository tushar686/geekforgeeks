package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ts250370 on 2/28/18.
 */
public class RomanToDecimal {

    public static void main(String[] args) {
        RomanToDecimal decimalToRoman = new RomanToDecimal();

        int roman = decimalToRoman.romanToInt("MCMXCIX");
        System.out.println("\n\n" + roman);
    }

//        I	1
//        V	5
//        X	10
//        L	50
//        C	100
//        D	500
//        M	1,000

    public int romanToInt(String s) {
        Map<String, Integer> romanToInteger = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
            }
        };

        int result = 0;
        List<String> blocks = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentValue = romanToInteger.get(currentChar + "");

            if (i + 1 < s.length()) {
                char nextChar = s.charAt(i+1);
                int nextValue = romanToInteger.get(nextChar + "");

                if (currentValue < nextValue) {
                    result += nextValue - currentValue;
                    i++;
                } else if (currentValue == nextValue) {
                    if (i + 2 < s.length()) {
                        char nextNextChar = s.charAt(i+2);
                        int nextNextValue = romanToInteger.get(nextNextChar + "");
                        if (currentValue == nextNextValue) {
                            result += currentValue + nextValue + nextNextValue;
                            i = i + 2;
                        } else {
                            result += currentValue + nextValue;
                            i = i + 1;
                        }
                    } else {
                        result += currentValue + nextValue;
                        i = i + 1;
                    }
                } else {
                    result += currentValue;
                }
            } else {
                result += currentValue;
            }
        }

        return result;
    }

}
