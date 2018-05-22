package stringarraysmatrix;

import java.util.Arrays;

/**
 * Created by ts250370 on 3/10/18.
 */
public class SegmentTree {
    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree();
        int[] origArr = new int[]{-1, 0, 3, 6};

        int n = segmentTree.getLengthOfSegmentTree(origArr.length);
        int[] segArr = new int[(2*n)-1];
        segmentTree.buildSegmentTree(origArr, segArr, 0, 0, origArr.length-1);
        System.out.println(Arrays.toString(origArr));
        System.out.println(Arrays.toString(segArr));

        int qLow = 2; int qHigh = 3;
        int min = segmentTree.minInRange(segArr, 0, 0, origArr.length - 1, qLow, qHigh);
        System.out.printf("min bet %d and %d is %d", qLow, qHigh, min);
    }

    public void buildSegmentTree(int[] origArr, int[] segArr, int pos, int low, int high) {
        if (low == high) {
            segArr[pos] = origArr[low];
            return;
        }

        int mid = Math.floorDiv(low+high, 2);
        buildSegmentTree(origArr, segArr, 2*pos+1, low, mid);
        buildSegmentTree(origArr, segArr, 2*pos+2, mid+1, high);

        segArr[pos] = Math.min(segArr[2*pos+1], segArr[2*pos+2]);
    }

    public int minInRange(int[] segArr, int pos, int low, int high, int qLow, int qHigh) {
        //total overlap
        if ( qLow <= low && qHigh >= high) {
            return segArr[pos];
        }
        //no overlap
        else if (qLow > high || qHigh < low) {
            return Integer.MAX_VALUE;
        } else {
            //partial overlap - look at both sides of tree.. this is default case
//        if ( (low >= qLow && high < qHigh) || (low < qLow && high > qHigh) )
            int mid = Math.floorDiv(low + high, 2);
            return Math.min(
                    minInRange(segArr, 2 * pos + 1, low, mid, qLow, qHigh),
                    minInRange(segArr, 2 * pos + 2, mid + 1, high, qLow, qHigh)
            );
        }


    }



    private int getLengthOfSegmentTree(int n) {
        if ( (n & (n-1)) != 0) {
            int count = 0; //left most set bit
            while ( n >> 1 > 0) {
                n = n >> 1;
                count++;
            }
            n = 1 << (count + 1);
        }
        return n;
    }
}
