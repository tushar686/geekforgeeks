package algobook.search;

/**
 * Created by ts250370 on 7/31/17.
 */
public class NQueenProblem_1 {

    class Positions {
        int row;
        int col;

        Positions(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Positions[] positions = new Positions[n];
        NQueenProblem_1 nQueenProblem_1 = new NQueenProblem_1();
        nQueenProblem_1.backtracking(n, 0, positions);
    }

    private boolean backtracking(int n, int row, Positions[] positions) {
        if(n == row) {
            processSolution(positions);
//            return true;
        }

        for(int col=0; col<n; col++) {
            boolean canBeInserted = true;
            for(int queen=0; queen<row; queen++) {
                if(positions[queen].col == col
                        || positions[queen].row + positions[queen].col == row + col
                        || positions[queen].row - positions[queen].col == row - col) {
                    canBeInserted = false;
                    break;
                }
            }
            if(canBeInserted) {
                positions[row] = new Positions(row, col);
                if(backtracking(n, row+1, positions)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void processSolution(Positions[] positions) {
        System.out.println();
        for(Positions position: positions) {
            System.out.print(position.col + " ");
        }
    }

}
