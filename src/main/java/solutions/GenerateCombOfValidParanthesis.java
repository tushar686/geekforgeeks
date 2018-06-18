package solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ts250370 on 6/8/18.
 */
public class GenerateCombOfValidParanthesis {

    public static void main(String[] args) {
        GenerateCombOfValidParanthesis generateCombOfValidParanthesis = new GenerateCombOfValidParanthesis();
        System.out.println(generateCombOfValidParanthesis.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int b) {
        List<String> result = new LinkedList<>();
        int n = (b * 2) - 1;

        for (int i = 0; i < Math.pow(2, n); i++) {
            if (0 == (i & (1 << n)) && 1 == (i & 1)) { //if first is '(' and last is ')' then
                String comb = "";
                int open = 0;
                int close = 0;
                for (int j = n; j >= 0; j--) {
                    if (0 == (i & (1 << j))) {
                        comb += "(";
                        open++;
                    } else {
                        close++;
                        comb += ")";
                    }

                    if (close > open || open > b )  {
                        break;
                    }

                }

                if (open == close) {
                    result.add(comb);
                }
            }
        }
        return result;
    }
}
