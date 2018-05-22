package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ts250370 on 2/28/18.
 */
public class DecimalToRoman {

    public static void main(String[] args) {
        DecimalToRoman decimalToRoman = new DecimalToRoman();

        String roman = decimalToRoman.intToRoman(3999);
        System.out.println("\n\n" + roman);
    }

//        I	1
//        V	5
//        X	10
//        L	50
//        C	100
//        D	500
//        M	1,000

    public String intToRoman(int num) {
        Map<Integer, String> integerToRoman = new HashMap<Integer, String>() {
            {
                put(0, "");
                put(1, "I");
                put(2, "II");
                put(3, "III");
                put(4, "IV");
                put(5, "V");
                put(6, "VI");
                put(7, "VII");
                put(8, "VIII");
                put(9, "IX");
                put(10, "X");
                put(50, "L");
                put(100, "C");
                put(500, "D");
                put(1000, "M");
            }
        };
        String result = "";
        int pos = 0;

        while(num != 0) {
            int digit = num % 10;
            int digitValue = digit * (int) Math.pow(10, pos);
            num = num / 10;
            System.out.printf("\n%d %d %d", digit, digitValue, num);

            switch (pos) {
                case 0:
                    result = integerToRoman.get(digitValue);
                    break;
                case 1:
                    if (digitValue < 40) {
                        while (digit > 0) {
                            result = "X" + result;
                            digit--;
                        }
                    } else if (digitValue < 50) {
                        result = "XL" + result;
                    } else if (digitValue == 50) {
                        result = "L" + result;
                    } else if (digitValue > 89) {
                        result = "XC" + result;
                    } else if (digitValue > 50 && digitValue < 90) {
                        while (digit > 5) {
                            result = "X" + result;
                            digit--;
                        }
                        result = "L" + result;
                    }
                    break;
                case 2:
                    if (digitValue < 400) {
                        while(digit > 0) {
                            result = "C" + result;
                            digit--;
                        }
                    } else if (digitValue < 500) {
                        result = "CD" + result;
                    } else if (digitValue == 500) {
                        result = "D" + result;
                    } else if (digitValue > 899) {
                        result = "CM" + result;
                    } else if (digitValue > 500 && digitValue < 900) {
                        while (digit > 5) {
                            result = "C" + result;
                            digit--;
                        }
                        result = "D" + result;
                    }
                    break;
                case 3:
                    while (digit > 0) {
                        result = "M" + result;
                        digit--;
                    }
                    break;
            }

            pos++;

        }
        return result;
    }

}
