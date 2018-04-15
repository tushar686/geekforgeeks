package backtracking;


import java.util.*;

public class NQueens_Solved {

    public static void main(String[] args) {
        long start = Calendar.getInstance().getTimeInMillis();
        NQueens_Solved solution = new NQueens_Solved();
        List<List<String>> sol = solution.solveNQueens_1(5);

       //ac [["Q....","..Q..","....Q",".Q...","...Q."],[".Q...","...Q.","Q....","..Q..","....Q"],["..Q..","Q....","...Q.",".Q...","....Q"],["...Q.","Q....","..Q..","....Q",".Q..."],["....Q",".Q...","...Q.","Q....","..Q.."]]
       //ex [["Q....","..Q..","....Q",".Q...","...Q."],["Q....","...Q.",".Q...","....Q","..Q.."],[".Q...","...Q.","Q....","..Q..","....Q"],[".Q...","....Q","..Q..","Q....","...Q."],["..Q..","Q....","...Q.",".Q...","....Q"],["..Q..","....Q",".Q...","...Q.","Q...."],["...Q.","Q....","..Q..","....Q",".Q..."],["...Q.",".Q...","....Q","..Q..","Q...."],["....Q",".Q...","...Q.","Q....","..Q.."],["....Q","..Q..","Q....","...Q.",".Q..."]]

        sol.stream().forEach(System.out::print);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> sol = new ArrayList<>();

        int startingCol = 0;

        while (startingCol < n) {
            List<String> currentSol = new ArrayList<>();
            if (solveNQueensUtil(currentSol, n, 0, startingCol)) {
                sol.add(currentSol);
                startingCol++;
            }
        }


        return sol;
    }

    public List<List<String>> solveNQueens_1(int n) {
        List<List<String>> sol = new ArrayList<>();

            List<String> currentSol = new ArrayList<>();
            solveNQueensUtil_1(sol, currentSol, n, 0, 0);
        return sol;
    }

    public int totalNQueens(int n) {
        Set<List<String>> sol = new HashSet<>();

        List<String> currentSol = new ArrayList<>();
        solveNQueensUtil_1_N(sol, currentSol, n, 0, 0);
        return sol.size();
    }

    public boolean solveNQueensUtil_1_N(Set<List<String>> overallSol, List<String> sol, int n, int row, int col) {
        if (row == n) {
            return true;
        }

        StringBuilder rowString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            rowString.append('.');
        }

        for (int i = col; i < n; i++) {
            if ( isSafeToPlaceHere(sol, row, i) ) {
                rowString.setCharAt(i, 'Q');
                addToSol(sol, row, rowString);
                if ( solveNQueensUtil_1_N(overallSol, sol, n, row + 1, 0)) {
                    overallSol.add(new ArrayList<>(sol));
                    rowString.setCharAt(i, '.');
                    addToSol(sol, row, rowString);
                } else {
                    rowString.setCharAt(i, '.');
                    addToSol(sol, row, rowString);
                }
            }
        }

        return false;
    }

    public boolean solveNQueensUtil_1(List<List<String>> overallSol, List<String> sol, int n, int row, int col) {
        if (row == n) {
            return true;
        }

        StringBuilder rowString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            rowString.append('.');
        }

        for (int i = col; i < n; i++) {
            if ( isSafeToPlaceHere(sol, row, i) ) {
                rowString.setCharAt(i, 'Q');
                addToSol(sol, row, rowString);
                if ( solveNQueensUtil_1(overallSol, sol, n, row + 1, 0) ) {
                    System.out.println(sol);
                    overallSol.add(new ArrayList<>(sol));
                    rowString.setCharAt(i, '.');
                    addToSol(sol, row, rowString);
                } else {
                    rowString.setCharAt(i, '.');
                    addToSol(sol, row, rowString);
                }
            }
        }

        return false;
    }

    public boolean solveNQueensUtil(List<String> sol, int n, int row, int col) {
        if (row == n) {
            return true;
        }

        StringBuilder rowString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            rowString.append('.');
        }

        for (int i = col; i < n; i++) {
            if ( isSafeToPlaceHere(sol, row, i) ) {
                rowString.setCharAt(i, 'Q');
                addToSol(sol, row, rowString);
                if ( solveNQueensUtil(sol, n, row + 1, 0) ) {
                    return true;
                } else {
                    rowString.setCharAt(i, '.');
                    addToSol(sol, row, rowString);
                }
            }
        }

        return false;
    }

    private void addToSol(List<String> sol, int row, StringBuilder rowString) {
        if (row < sol.size()) {
            sol.remove(row);
        }
        sol.add(row, rowString.toString());
    }

    public boolean isSafeToPlaceHere(List<String> sol, int row, int col) {

        int j = 1;
        for (int i = row-1; i >= 0; i--, j++ ) {
            String rowString = sol.get(i);

            //verify that Q does not exist in same col of any of the row above currnet
            if (rowString.charAt(col) == 'Q') {
                return false;
            }

            int rightDiagonalPos = col - j;
            if ( rightDiagonalPos >= 0 && rowString.charAt(rightDiagonalPos) == 'Q') {
                return false;
            }
            int leftDiagonalPos = col + j;
            if ( leftDiagonalPos < rowString.length() && rowString.charAt(leftDiagonalPos) == 'Q') {
                return false;
            }
        }

        return true;
    }
}