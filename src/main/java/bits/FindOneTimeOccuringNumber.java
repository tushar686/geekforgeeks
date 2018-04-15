package bits;

public class FindOneTimeOccuringNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 5, 8};
        // int[] arr = new int[]{12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
        int result = 0;
        for (int i=0; i<32; i++) {
            int x = (1 << i);
            int sum = 0;
            for (int j=0; j<arr.length; j++) {
                if ( (arr[j] & x) != 0) 
                    sum += 1;
            }
            if (sum % 3 != 0) {
                result |= x;
            }
        }
        System.out.println(result);
    }
}