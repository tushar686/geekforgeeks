package solutions;

import java.util.*;

public class GFG {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            int[] input = new int[T];


            String[] numbers = new String[21];
            numbers[1] = "1";
            numbers[2] = "11";
            numbers[3] = "21";
            for (int i=4; i<21; i++) {
                String prev = numbers[i-1];
                String sb = new String();
                for (int j=prev.length()-1; j>=0; ) {
                    if (prev.charAt(j) == '1') {
                        if ( (j-1) >= 0) {
                            if (prev.charAt(j-1) == '1') { //11
                                sb = "21" + sb;
                                j -= 2; 
                            } else { //21
                                sb = "11" + sb;
                                j -= 1; 
                            }
                        } else { //last char of prev String is '1'
                            sb = "11" + sb;
                            j -= 1; 
                        }
                    } else {
                        sb = "12" + sb;
                        j -= 1; 
                    }
                }
                numbers[i] = sb;
            }

//            for (int i=0; i<T; i+=1) {
//                input[i] = sc.nextInt();
//                String result = numbers[input[i]];
//                System.out.println(result);
//            }

            for (int i=0; i<T; i+=1) {
                input[i] = sc.nextInt();
            }
            for (int k=0; k<T; k+=1) {
                String result = numbers[input[k]];
                System.out.println(result);
            }

        }

}