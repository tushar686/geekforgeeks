package solutions;

import java.util.Scanner;

class FindingDistincTwoNumbersWithBits {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] input = new int[T][];

		for (int i=0; i<T; i++) {
		    int N = sc.nextInt();
		    input[i] = new int[2*N+2];

		    for (int j=0; j<2*N+2; j++) {
		        input[i][j] = sc.nextInt();
		    }
		}

		for (int i=0; i<T; i++) {
            findDistinctTwoNumbers(input[i]);
		}
//		findDistinctTwoNumbers(new int[] {2, 1, 3, 2});
		
	}
	
	static void findDistinctTwoNumbers(int[] input) {
        int distinctOne = -1;
		int distinctTwo = -1;

        int mask = ~(1 << 2);
        int masked = 255 & mask;

        int result = 0;
	    for (int i=0; i<input.length; i++) {
            int number = input[i];
            result = toggleBitAtPos(result, number);
		}

        for (int i=0; i<input.length; i++) {
            int number = input[i];
            int bitAtPos = getBitAtPos(result, number);
            if (bitAtPos == 1) {
                if (distinctOne == -1) {
                    distinctOne = number;
                } else {
                    distinctTwo = number;
                }

            }
        }

        if (distinctOne < distinctTwo) {
            System.out.println(distinctOne + " " + distinctTwo);
        } else {
            System.out.println(distinctTwo + " " + distinctOne);
        }
    }

    static int toggleBitAtPos(int result, int pos) {
        int setBitAtPosOfNumber = 1 << pos;
        int existingBitAtPosOfNumber = (result & setBitAtPosOfNumber) >> pos;
        if (pos == 9385 || pos == 9385) {
            setBitAtPosOfNumber = 1 << pos;
            existingBitAtPosOfNumber = (result & setBitAtPosOfNumber) >> pos;
        }
        if (existingBitAtPosOfNumber == 0) {
            return result | setBitAtPosOfNumber;
        } else {
            return result & (~setBitAtPosOfNumber);
        }
    }

    static int getBitAtPos(int result, int pos) {
        int setBitAtPosOfNumber = 1 << pos;
        int existingBitAtPosOfNumber = (result & setBitAtPosOfNumber) >> pos;
        if (pos == 9) {
            setBitAtPosOfNumber = 1 << pos;
            existingBitAtPosOfNumber = (result & setBitAtPosOfNumber) >> pos;
        }
        return existingBitAtPosOfNumber;
    }
}