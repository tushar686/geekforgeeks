package sort;

import list.LinkedList;

/**
 * Created by ts250370 on 8/21/17.
 */
public class RadixSort {
    int maxDigit = 3;
    int [] input = new int[] {123, 214, 61, 324, 948, 647};
    LinkedList [] range = new LinkedList[10];

    public static void main(String[] args) {
        RadixSort radix = new RadixSort();
         radix.sort();
         radix.printInput();
    }

    private void printInput() {
        for (int n=0; n < input.length; n++)  {
            System.out.println(input[n]);
        }
    }

    private void sort() {
        findDigitAtMy(1023, 4);
        for (int k = 0; k < maxDigit; k++) {
            range = new LinkedList[] {null, null, null, null, null, null, null, null, null, null};
            int n = 0;
            for (; n < input.length; n++)  {
                int pos = findDigitAt(input[n], k+1);
                if(range[pos] == null) {
                    range[pos] = new LinkedList();
                }
                range[pos].insertAtEndOfList(input[n]);
            }

            n = 0;
            for (int i = 0; i < 10; i++)  {
                if(range[i] != null) {
                    LinkedList list = range[i];
                    for(int j=0; j<list.size(); j++) {
                        input[n++] = (int) list.getAt(j);
                    }
                }
            }
        }
    }
    

     private int findDigitAt(int number, int pos) {
         if ( (number / (int) Math.pow(10, pos-1) ) > 0 ) {
             return (number % (int) Math.pow(10, pos)) / (int) Math.pow(10, pos - 1);
         } else {
             return 0;
         }
     }

   private int findDigitAtMy(int number, int maxDigits) {
       int prevQutient = 0;
       for(int pos=maxDigits; pos>-1; pos--) {
           int pow = (int) Math.pow(10, pos);  // 1000 = 10, 3
                                               //100 = 10, 2
                                              //10 = 10, 1
                                              //1 = 10, 0

           int quotient = number / pow;   // 4 = 4253 / 1000
                                         // 42 = 4253 / 100
                                        // 425 = 4253 / 10
                                       // 4253 = 4253 / 1

           int prevQutientTimes10 = prevQutient * 10;  // 0 = 4 * 0
                                       // 40 = 4 * 10
                                       // 420 = 42 * 10
                                       // 4250 = 425 * 10

           int digit = quotient - prevQutientTimes10;   // 4 = 4 - 0
                                                       // 2 = 42 - 40
                                                       // 5 = 425 - 420
                                                       // 3 = 4253 - 4250

           prevQutient = quotient; // 4, 42, 425, 4253
           System.out.println(digit);
       }
       return 0;
   }

}
