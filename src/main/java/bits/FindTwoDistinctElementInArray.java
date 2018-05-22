package bits;

/**
 * Created by ts250370 on 3/1/18.
 */
public class FindTwoDistinctElementInArray {
    public static void main(String[] args) {
        int[] wrong = {29328859,1466838361,-66079248,926571150,1456000429,926571150,1536309894,-182157937,-391092726,
                1518731260,-66079248,-1116874613,-1703212692,-1116874613,-1321264512,-816411092,-483719306,110721554,29328859,
                -357092863,-391092726,-357092863,1466838361,-1703212692,-1321264512,1518731260,1536309894,640411520,-182157937,
                -816411092,1456000429,-483719306};

        FindTwoDistinctElementInArray solution = new FindTwoDistinctElementInArray();
//        int[] result = solution.singleNumber(new int[]{2, 4, 7, 9, 2, 4});
//        int[] result = solution.singleNumber(new int[]{-1321264512, -2, -1321264512, 3, 1321264512, -2, 2});
        int[] result = solution.singleNumber(wrong);
        System.out.println(result[0] + " " + result[1]);

        int a = -1;
//        for (int i=0; i<34; i++)
//            System.out.println( (a >> i) );

    }

    public int[] singleNumber(int[] nums) {
        int xorOfAllElements = 0;

        for (int ele: nums) {
            xorOfAllElements = xorOfAllElements ^ ele;
        }

        int rightMostSetBitAndAfterItFlipped = xorOfAllElements - 1;
        int onlyRightMostBitSet = ~rightMostSetBitAndAfterItFlipped;
        int setBitNo = xorOfAllElements & onlyRightMostBitSet;

        int first = 0;
        int second = 0;

        for (int ele: nums) {
            if ( (ele & setBitNo) == 0) {
                first = first ^ ele;
            } else {
                second = second ^ ele;
            }
        }

        return new int[]{first, second};
    }
}
