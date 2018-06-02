package string;

import java.util.Calendar;

/**
 * Created by ts250370 on 2/27/18.
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
//        double median = findMedianSortedArrays_Merge(new int[]{1, 3, 5, 11, 17}, new int[]{9, 10, 11, 13, 14});
//        double median = findMedianSortedArrays_Merge(new int[]{1, 3}, new int[]{2});
//        double median = findMedianSortedArrays_Merge(new int[]{1, 2}, new int[]{3, 4});

//        double median = findMedianSortedArrays_SameSize(new int[]{1, 3, 5, 11, 17}, new int[]{9, 10, 11, 13, 14});
        double median = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
//        double median = findMedianSortedArrays(new int[]{2}, new int[]{1, 3});
//        double median = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
//        double median = findMedianSortedArrays(new int[]{1, 3, 8, 9, 15}, new int[]{7, 11, 18, 19, 21, 25});
//        double median = findMedianSortedArrays(new int[]{23, 26, 31, 35}, new int[]{3, 5, 7, 9, 11, 16});

        System.out.println(median);
        System.out.println(Calendar.getInstance().getTimeInMillis() - start);
    }
//    1 3 5 9 10 11 11 13 14 17

    public static double findMedianSortedArrays(int[] x, int[] y) {
        if (x.length < y.length) {
            return findMedianUtil_BS(x, y, 0, x.length);
        } else {
            return findMedianUtil_BS(y, x, 0, y.length);
        }
    }

    private static double findMedianUtil_BS(int[] x, int[] y, int start, int end) {
        //partitionX + partitionY = (x + y + 1) / 2

        int partitionX = ( start + end ) / 2;
        int partitionY = ( ( x.length + y.length + 1 ) / 2 ) - partitionX;

        int maxLX = partitionX == 0 ? Integer.MIN_VALUE : x[partitionX-1];
        int minRX = partitionX == x.length ? Integer.MAX_VALUE : x[partitionX];
        int maxLY = partitionY == 0 ? Integer.MIN_VALUE : y[partitionY-1];
        int minRY = partitionY == y.length ? Integer.MAX_VALUE : y[partitionY];

        if (maxLX <= minRY && maxLY <= minRX) {
            if ( (x.length + y.length) % 2 == 0) {
                return ( Math.max(maxLX, maxLY) + Math.min(minRX, minRY) ) / 2.0;
            } else {
                return Math.max(maxLX, maxLY) * 1.0;
            }
        }

        if (maxLX > minRY) {
            end = partitionX - 1;
        } else {
            start = partitionX + 1;
        }

        return findMedianUtil_BS(x, y, start, end);
    }

    public static double findMedianSortedArrays_SameSize(int[] nums1, int[] nums2) {
        return findMedianUtil(nums1, nums2, 0, nums1.length, 0, nums2.length);
    }

    public static double findMedianUtil(int[] a, int[] b, int startA, int endA, int startB, int endB) {

        //base case if n==2
        if (endA - startA == 2 && endB - startB == 2) {
            return (
                    ( Math.max(a[startA], b[startB]) + Math.min(a[endA-1], b[endB-1]) )
                    / 2.0
            );
        }

        int medianA = a[startA + (endA - startA) / 2 ];
        int medianB = b[startB +  (endB - startB) / 2 ];

        //base case if m1==m2
        if (medianA == medianB) {
            return medianA * 1.0;
        }

        if (medianA < medianB) {
            startA = startA + (endA - startA) / 2;
            endB = endB - (endB - startB) / 2;
        }
        if (medianA > medianB) {
            endA = endA - (endA - startA) / 2;
            startB = startB + (endB - startB) / 2;
        }


        return findMedianUtil(a, b, startA, endA, startB, endB);
    }

    public static double findMedianSortedArrays_Merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];

        int first = 0;
        int second = 0;
        int index = 0;

        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] < nums2[second]) {
                result[index++] = nums1[first++];
            } else {
                result[index++] = nums2[second++];
            }
        }

        while (first < nums1.length) {
            result[index++] = nums1[first++];
        }
        while (second < nums2.length) {
            result[index++] =  nums2[second++];
        }

        if (result.length % 2 == 0) {
            return ( result[(result.length / 2) - 1] + result[result.length / 2]) / 2.0;
        } else {
            return result[result.length / 2];
        }
    }

}
