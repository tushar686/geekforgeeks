package hackerrank;

import java.util.Scanner;
import java.util.Stack;

class LongestValidParenthesis {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        String[] input = new String[T];
        sc.nextLine();
		for (int i=0; i<T; i++) {
            input[i] = sc.nextLine();
		}

		for (int i=0; i<T; i++) {
            findMaxValidParenthesis(input[i].toCharArray());
            findMaxValidParenthesis_DP(input[i].toCharArray());
            findMaxValidParenthesis_OneMoreStack(input[i].toCharArray());
            longestValidParentheses(input[i].toCharArray());
		}
	}
	
	static void findMaxValidParenthesis(char[] input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;
        for (int i=0; i<input.length; i++) {
            if (input[i] == '(') {
                stack.push(i);
            } else {
                    stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    maxLength = Math.max(len, maxLength);
                }
            }
        }
        System.out.println(maxLength);
    }

    static void findMaxValidParenthesis_OneMoreStack(char[] input) { //O(n) space is O(1)
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (int i=0; i<input.length; i++) {
            if (input[i] == '(') {
                left++;
            }
            if (input[i] == ')') {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, left*2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        for (int i=input.length-1; i >= 0; i--) {
            if (input[i] == '(') {
                left++;
            }
            if (input[i] == ')') {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, right*2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        System.out.println(maxLength);
    }

    static void findMaxValidParenthesis_DP(char[] input) {
        int[] dp = new int[input.length];

        for (int i=1; i<input.length; i++) {
            if (input[i] == ')') {
                if (input[i-1] == '(') { //()
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 0 + 2;
                    }
                } else if (i - dp[i - 1] > 0 && input[i - dp[i - 1] - 1] == '(') { // ()(( ))
                    if (i-1 >= 0) {
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;      // ()=<dp of this guy(-2)+ (( ))
                        } else {
                            dp[i] = dp[i - 1] + 0 + 2;
                        }
                    }
                }
            }
        }

        int maxLength = 0;
        for (int i=0; i<input.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(maxLength);
    }

    static void longestValidParentheses(char[] input) {
        Stack<int[]> stack = new Stack<int[]>();
        int result = 0;

        for(int i=0; i<=input.length-1; i++){
            char c = input[i];
            if(c=='('){
                int[] a = {i,0};
                stack.push(a);
            }else{
                if(stack.empty()||stack.peek()[1]==1){
                    int[] a = {i,1};
                    stack.push(a);
                }else{
                    stack.pop();
                    int currentLen=0;
                    if(stack.empty()){
                        currentLen = i+1;
                    }else{
                        currentLen = i-stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }

        System.out.println(result);;
    }

}