package solutions;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        SubArrayWithGivenSum subArrayWithGivenSum = new SubArrayWithGivenSum();
//        Scanner sc = new Scanner(System.in);
//        int noOfTests  = Integer.parseInt(sc.nextLine());
//        String[] lenSum = new String[noOfTests];
//        String[] inputArr = new String[noOfTests];
//
//        for (int i=0; i<noOfTests; i++) {
//            lenSum[i] = sc.nextLine();
//            inputArr[i] = sc.nextLine();
//        }
//
//        for (int i=0; i<noOfTests; i++) {
//            int noOfElements = Integer.parseInt(lenSum[i].split(" ")[0]);
//            int givenSum = Integer.parseInt(lenSum[i].split(" ")[1]);
//
//            int[] arr = new int[noOfElements];
//            int count = 0;
//            for (String arrEle : inputArr[i].split(" ")) {
//                arr[count++] = Integer.parseInt(arrEle);
//            }
//            int[] result = subArrayWithGivenSum.findSubArrayWithSum(arr, givenSum, 0, 0, 0);
//            if (result[0] == -1) {
//                System.out.println(-1);
//            } else {
//                System.out.println(result[0] + " " + result[1]);
//            }
//        }

//        int[] result = subArrayWithGivenSum.findSubArrayWithSum(new int[]{1, 2, 3, 7, 5}, 12, 0, 0, 0);
//        int[] result = subArrayWithGivenSum.findSubArrayWithSum_efficient(new int[]{1, 2, 3, 7, 5}, 12);
//        int[] result = subArrayWithGivenSum.findSubArrayWithSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15, 0, 0, 0);
        int[] result = subArrayWithGivenSum.findSubArrayWithSum_efficient(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15);
        System.out.println(result[0] + " " + result[1]);
    }

    int[] findSubArrayWithSum(int[] arr, int givenSum, int sumTillNow, int startIndex, int endIndex) {
        sumTillNow += arr[endIndex++];
        
        if (sumTillNow == givenSum) { //base condition
            return (new int[]{startIndex+1, endIndex});
        } else if(startIndex == arr.length) {
            return (new int[]{-1, -1});
        } else if (sumTillNow > givenSum || (endIndex > arr.length) ) { //reset everything and will start over again from new indices
            sumTillNow = 0;
            startIndex += 1;
            endIndex = startIndex;
        }
        return findSubArrayWithSum(arr, givenSum, sumTillNow, startIndex, endIndex);
    }

    int[] findSubArrayWithSum_efficient(int[] arr, int givenSum) {
        int currentSum = 0;
        int start = 0;

        for (int i=0; i<arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > givenSum) {
                currentSum -= arr[start];
                start += 1;
            }
            if (currentSum == givenSum) {
                return new int[] {start+1, i+1};
            }
        }
        return new int[] {-1, -1};
    }
}