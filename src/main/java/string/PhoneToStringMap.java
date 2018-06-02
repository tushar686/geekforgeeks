package string;

import java.util.*;

/**
 * Created by ts250370 on 6/2/18.
 */
public class PhoneToStringMap {

    static Map<Integer, String> mapping = new HashMap<>();

    static {
        mapping.put(2, "abc");
        mapping.put(3, "def");
        mapping.put(4, "ghi");
        mapping.put(5, "jkl");
        mapping.put(6, "mno");
        mapping.put(7, "pqrs");
        mapping.put(8, "tuv");
        mapping.put(9, "wxyz");
    }


    public static void main(String[] args) {
        PhoneToStringMap phoneToStringMap = new PhoneToStringMap();
        phoneToStringMap.letterCombinations("234");
    }

    public List<String> letterCombinations(String digits) {
        List<String> sol = new ArrayList<>();
        generateCombination(digits, 0, 0, new StringBuilder(), sol);
        System.out.println(sol);
        return sol;
    }

    private void generateCombination(String digits, int digitPos, int charPos, StringBuilder result, List<String> sol) {
        if (digitPos == digits.length()) {
            return;
        }
        int currentDigit = digits.charAt(digitPos) - 48;
        if (charPos == mapping.get(currentDigit).length()) {
            return;
        }

        result.append(mapping.get(currentDigit).charAt(charPos));

        generateCombination(digits, digitPos + 1, 0, result, sol);
        if (result.length() == digits.length()) {
            sol.add(result.toString());
        }
        result.deleteCharAt(result.length()-1);
        generateCombination(digits, digitPos, charPos + 1, result, sol);
    }

}
