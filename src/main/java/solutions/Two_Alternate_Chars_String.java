package solutions;

import java.util.*;

public class Two_Alternate_Chars_String {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();

        Two_Alternate_Chars_String solution = new Two_Alternate_Chars_String();
        int length = solution.findAlternateString(s);
        System.out.println(length);
    }

    private int findAlternateString(String s) {
        s = stripOutDuplicateChars(s);

        LinkedHashMap<Character, Integer> charCounts = getSortedMapOfCharCounts(s);
        char[] chars = new char[charCounts.size()];
        int[] counts = new int[charCounts.size()];
        int index = 0;
        for (Map.Entry entry: charCounts.entrySet()) {
            chars[index] = (char) entry.getKey();
            counts[index] = (int) entry.getValue();
//            System.out.println(chars[index] + " : " + counts[index] );
            index++;
        }

        int maxLengthOfAlternateString = 0;
        for (int i=chars.length-1; i-1>=0; i--) {
            int firstChar = chars[i];
            int secondChar = chars[i-1];

            String alternateCharSting = new String(s);
            for (int k=0; k<s.length(); k++) {
                if (s.charAt(k) != firstChar && s.charAt(k) != secondChar) {
                    alternateCharSting = stripOutChar(alternateCharSting, s.charAt(k));
                }
            }
//            System.out.println(alternateCharSting);
            if (alternateCharSting.length() > 0 && isDuplicateChar(alternateCharSting) == '\u0000') {
//                System.out.println(alternateCharSting);
                return alternateCharSting.length();
            }

        }

        return maxLengthOfAlternateString;
    }

    private LinkedHashMap<Character, Integer> getSortedMapOfCharCounts(String s) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for(char ch : s.toCharArray()) {
            if (charCounts.get(ch) == null) {
                charCounts.put(ch, 1);
            } else {
                int prevCount = charCounts.get(ch);
                charCounts.put(ch, prevCount+1);
            }
        }
        LinkedHashMap<Character, Integer> sortedCharCounts = sortHashMapByValues(charCounts);
        return sortedCharCounts;
    }



    public LinkedHashMap<Character, Integer> sortHashMapByValues(HashMap<Character, Integer> passedMap) {
        List<Character> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<Character, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<Character> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Character key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    String stripOutDuplicateChars(String s) {
        char duplicateChar = isDuplicateChar(s);
        if (s.length() == 0 || duplicateChar == '\u0000') {
            return s;
        }

        String removedDuplicateChar = stripOutChar(s, duplicateChar);

        return stripOutDuplicateChars(removedDuplicateChar);
    }

    private String stripOutChar(String s, char duplicateChar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != duplicateChar) {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }

    private char isDuplicateChar(String s) {
        char prevCh = '\u0000';
        for (char ch : s.toCharArray()) {
            if (ch == prevCh) {
                return ch;
            }
            prevCh = ch;
        }
        return '\u0000';
    }
    
}