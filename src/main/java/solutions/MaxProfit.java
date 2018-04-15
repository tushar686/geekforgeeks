package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaxProfit {
    public static void main(String args []) {
        int[] prices = {10, 22, 5, 75, 65, 80}; //97 - 87
//        int[] prices = {10, 22, 5, 75, 3, 100}; //179 - 167
//        int[] prices = {100, 80, 10, 20, 10, 70, 90}; //90
//        int[] prices = {2, 30, 15, 10, 8, 25, 80}; //100
//        int[] prices = {100, 30, 15, 10, 8, 25, 80}; //72
//        int[] prices = {90, 80, 70, 60, 50}; //0

//        int maxProfit = maxProfitMultipleChoice_with_stack(prices);
//        int maxProfit = maxProfit_Multiple__BuyAndSell_without_stack(prices);
//        int maxProfit = maxProfit_Twice_BuyAndSell(prices);
        int maxProfit = maxProfit_k_BuyAndSell(prices, 3);
        System.out.println(maxProfit);
    }

    static int maxProfit_Multiple__BuyAndSell_with_stack(int[] prices) {
        class StackContent {
            int price;
            int index;

            StackContent(int price, int index) {
                this.price = price;
                this.index = index;
            }
        }

        Map<StackContent, Integer> map = new HashMap<>();
        Stack<StackContent> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            if (stack.empty()) {
                stack.push(new StackContent(prices[i], i));
            } else {
                if (prices[i] < stack.peek().price) {
                    stack.pop();
                    stack.push(new StackContent(prices[i], i));
                } else {
                    int currentProfit = prices[i] - stack.peek().price;
                    int prevProfit = map.get(stack.peek()) == null ? -1 : map.get(stack.peek());
                    if (currentProfit > prevProfit) {
                        map.put(stack.peek(), currentProfit);
                    }
                    if (i + 1 < prices.length && prices[i + 1] < prices[i]) {
                        stack.pop();
                    }
                }
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        priorityQueue.addAll(map.values());

        return priorityQueue.stream().reduce(Integer::sum).get();
    }

    static int maxProfit_Multiple__BuyAndSell_without_stack(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = -1;
        int maxProfit = 0;
        int currentProfit = 0;

        for (int i=prices.length-1; i >= 0; i--) {
            if (prices[i] > max || prices[i] > min) {
                max = prices[i];
                min = prices[i];
                maxProfit += currentProfit;
                currentProfit = 0;
            }

            if (min > prices[i]) {
                min = prices[i];
                currentProfit = max - min;
            }
        }
        maxProfit += currentProfit;

        return maxProfit;
    }

    static int maxProfit_Twice_BuyAndSell(int[] prices) {

        int [] left = new int[prices.length];
        int [] right = new int[prices.length];
        left[0] = 0;
        right[right.length-1] = 0;

        int min = Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++) {
            if (min >= prices[i]) {
                min = prices[i];
                if (i-1 >= 0) {
                    left[i] = left[i - 1];
                }
            } else {
                if (i-1 >= 0) {
                    if (left[i - 1] < prices[i] - min) {
                        left[i] = prices[i] - min;
                    } else {
                        left[i] = left[i-1];
                    }
                } else {
                    left[i] = prices[i] - min;
                }
            }
        }

        int max = -1;
        for (int i=prices.length-1; i >= 0; i--) {
            if (max <= prices[i]) {
                max = prices[i];
                if (i+1 < prices.length) {
                    right[i] = right[i + 1];
                }
            } else {
                if (i+1 < prices.length) {
                    if (right[i+1] < max - prices[i]) {
                        right[i] = max - prices[i];
                    } else {
                        right[i] = right[i + 1];
                    }
                } else {
                    right[i] = max - prices[i];
                }
            }
        }

        int maxProfit = 0;

        for (int i=0; i<left.length; i++) {
            if (left[i] + right[i] > maxProfit) {
                maxProfit = left[i] + right[i];
            }
        }

        return  maxProfit;
    }

    static int maxProfit_k_BuyAndSell(int [] prices, int k) {

        int[][] profits = new int[k+1][prices.length];

        for (int t=0; t<=k; t++) {
            for (int d = 0; d < prices.length; d++) {
                if (t ==0 || d == 0) {
                    profits[t][d] = 0;
                } else {
                    profits[t][d] = calculateMaxProfitForTheDay(prices, profits, d, t);
                }
            }
        }

        return profits[k][prices.length-1];
    }

    private static int calculateMaxProfitForTheDay(int[] prices, int[][] profits, int d, int t) {
        //If you do not transact on this d day then previous day profit is what you can max have
        int maxProfit = profits[t][d-1];

        //if you decide to transact
        for (int m=0; m<d; m++) {
            int daysProfit = prices[d] - prices[m]; //sale - buy
            daysProfit = daysProfit + profits[t-1][m]; //+ Profit already made till the day m
            if (maxProfit < daysProfit) {
                maxProfit = daysProfit;
            }
        }

        return maxProfit;
    }

}