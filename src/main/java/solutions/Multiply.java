package solutions;

import java.util.*;

public class Multiply {
        public static void main (String[] args) {
            String result = multiply("123", "14");
            System.out.println(result);
        }

        static String multiply(String big, String small) {
            big = new StringBuilder(big).reverse().toString();
            small = new StringBuilder(small).reverse().toString();

            int[][] d = new int[big.length()][];

            for (int i=0; i<small.length(); i++) {
                d[i] = new int[big.length() + i];
                for (int k=0; k<i; k++) {
                    d[i][k] = 0;
                }
                for (int j=0; j<big.length(); j++) {
                    int ch1 = big.charAt(j);
                    int ch2 = small.charAt(i);
                    ch1 = ch1 - '0';
                    ch2 = ch2 - '0';
                    d[i][i+j] = ch1 * ch2;
                }
            }

            // for (int i=0; i<d.length; i++) {
            //     int mod = d[i] % 10;
            //     int carry = d[i] / 10;
            //     if (i+1 < d.length) {
            //         d[i+1] += carry; 
            //     }
            //     d[i] = mod;
            // }

            // for (int i=0; i<d.length; i++) {
            //     System.out.println(d[i]);
            // }

            return "0";
        }

}