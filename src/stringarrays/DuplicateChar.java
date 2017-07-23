package stringarrays;

public class DuplicateChar {

    public static void main(String[] args) {
        String input = args[0];
        if(input != null) {
//            String unique = removeDuplicateCharUsingFlagBits(input);
            String unique = removeDuplicateCharUsingAsciiArray(input);
            System.out.format("Unique %s \n", unique);
        }
    }

    private static String removeDuplicateCharUsingFlagBits(String input) {
        String output = "";

        int flag = 0;
        for(int i=0; i<input.length(); i++) {
            int ch = input.charAt(i) - 'a';

            if( (flag & (1 << ch)) == 0) {
                output += (char) (ch + 'a');
            }
            flag |= (1 << ch);
        }

        return output;
    }

    private static String removeDuplicateCharUsingAsciiArray(String input) {
        boolean [] hits = new boolean[256];

        String output = "";
        output += input.charAt(0);
        hits[input.charAt(0)] = true;

        for(int i=1; i<input.length(); i++) {
            if(!hits[input.charAt(i)]) {
                output += input.charAt(i);
                hits[input.charAt(i)] = true;
            }
        }

        return output;
    }
}
