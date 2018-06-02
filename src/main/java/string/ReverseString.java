package string;

public class ReverseString {
    public static void main(String[] args) {
        reverse("abcd".toCharArray(), -1);
    }

    static void reverse(char [] input, int start) {
        if(start+1 < input.length) {
            reverse(input, ++start);
            System.out.print(input[start]);
        } 
    }
}