package stringarrays;


public class UniqueCharWithBits {
    public static void main(String[] args) {
        UniqueCharWithBits uniqueCharWithBits = new UniqueCharWithBits();
        System.out.println(uniqueCharWithBits.isUnique("tushar"));
    }

    private boolean isUnique(String input) {
        int bitVector = 0;
        
        for(char ch: input.toCharArray()) {
            if ((bitVector & (1 << ch-'a')) != 0) {
                return false;
            }
            bitVector = bitVector | (1 << ch-'a');
        }

        return true;
    }

    private static void printBinaryform(int number) {
        int remainder;

        if (number <= 1) {
            System.out.print(number);
            return;   // KICK OUT OF THE RECURSION
        }

        remainder = number %2; 
        printBinaryform(number >> 1);
        System.out.print(remainder);
    }
}