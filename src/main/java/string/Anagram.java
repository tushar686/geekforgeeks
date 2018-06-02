package string;

public class Anagram {
    public static void main(String[] args) {
        String first = args[0];
        String second = args[1];

        boolean isAnagrams = isAnagrams(first, second);
        System.out.println(isAnagrams);
    }

    private static boolean isAnagrams(String first, String second) {
        if(first.length() != second.length()) {
            return false;
        }

        boolean [] hits = new boolean[256];
        for(int i=0; i<first.length(); i++) {
            hits[first.charAt(i)] = true;
        }

        for(int i=0; i<second.length(); i++) {
            if(!hits[second.charAt(i)]) {
                return false;
            }
        }

        return true;
    }
}
