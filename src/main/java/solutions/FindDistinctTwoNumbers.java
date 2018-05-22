package solutions;

import java.util.*;
import java.util.Map.Entry;
import java.lang.*;

class FindDistinctTwoNumbers {
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
		
		
	}
	
	static void findDistinctTwoNumbers(int[] input) {
        int distinctOne = -1;
		int distinctTwo = -1;
		Map<Integer, Integer> numbers = new HashMap<>();
	    for (int i=0; i<input.length; i++) {
			Integer count = numbers.get(input[i]);
			if (count == null) {
				numbers.put(input[i], 1);
			} else {
				numbers.put(input[i], ++count);
			}
		}
		for (Entry<Integer, Integer> entry : numbers.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				if (distinctOne == -1) {
					distinctOne = entry.getKey();
				} else {
					distinctTwo = entry.getKey();
				}
			}
		}

		if (distinctOne < distinctTwo) {
			System.out.println(distinctOne + " " + distinctTwo);
		} else {
			System.out.println(distinctTwo + " " + distinctOne);
		}
	}
}