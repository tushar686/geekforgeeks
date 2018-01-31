package solutions;

/**
 * Created by ts250370 on 1/29/18.
 */
public class FB {
    /*

a1 = [ 1, 2, 3, 4, 6, 11, 110 ]
a2 = [ -20, 3, 5, 11, 200 ]

output = [ 3, 11 ]

a1 = [ 1, 2, 1000 ] l = 3
a2 = [ 1, 2, 3, 4, 5, ...... 1500   ... , 10000 ] l = 100

output = [ 1, 2, 1000 ]

*/


        public static void main(String [] args) {
            int[] a1 = { 1, 2, 3, 4, 6, 11, 110 };
            int[] a2 = { -20, 3, 5, 11, 200 };

            findCommon(a1, a2);

        }

        static int[] findCommon(int[] a1, int[] a2) {
            int[] result = new int[Math.min(a1.length, a2.length)];
            int resultCount = 0;

            int countSecond = 0;
            int first=0
            int gap = 10;

            for (; first < a1.length && countSecond < a2.length; ) {
                if (a1[first] < a2[countSecond] ){
                    first++;
                } else if (a1[first] > a2[countSecond] ) {
                    countSecond++; // countSecond+= gap;
                } else {
                    result[resultCount++] = a1[first]
                    first++;
                    countSecond++;
                }
            }

            return result;
        }

        static int[] findCommon_1(int[] a1, int[] a2) {
            int[] result = Math.min(a1.length, a2.length);
            int resultCount = 0;

            int countSecond = 0;
            int first=0
            int gap = 10;

            for (; first < a1.length && countSecond < a2.length; ) {
                if (a1[first] != a2[countSecond] ){
                    if (scan(first, countSecond, gap)) {
                        result[resultCount++] = a1[first]
                        first++;
                        countSecond++;
                    }
                } else {
                    result[resultCount++] = a1[first]
                    first++;
                    countSecond++;
                }
            }

            return result;
        }

        scan(first, countSecond, gap) {
            if (a1.first < a2.gap) {
                scan(first, countSecond, g=gap/2);
            }
            if a1.first > a2.gap {
                a2.gap, prevGap;
            }
            if matches return true;


        }

}