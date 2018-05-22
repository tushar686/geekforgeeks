package solutions;


import java.util.Stack;

public class MaxAreas {

    public static void main(String[] args) {
        MaxAreas solution = new MaxAreas();
        int maxArea  = solution.getMaxAres(new int[]{6, 2, 5, 4, 5, 1, 6});
        System.out.println(maxArea);
    }

    private int getMaxAres(int[] heights) {
        Stack<Integer> stk =  new Stack<>();
        int maxArea = 0;
        int area = 0;
        int i=0;
        while (i < heights.length) {
            if (stk.empty() || (heights[i] >= heights[stk.peek()]) ) {
                stk.push(i++);
            } else {
                int removedBar = heights[stk.pop()];
                area = removedBar * ( stk.empty() ? i : (i - stk.peek() - 1) );

                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }

        while (!stk.empty()) {
            int removedBar = heights[stk.pop()];
            area = removedBar * ( stk.empty() ? i : (i - stk.peek() - 1) );

            if (maxArea < area) {
                maxArea = area;
            }
        }

        return maxArea;
    }

}