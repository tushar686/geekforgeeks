package search;

/**
 * Created by ts250370 on 7/30/17.
 */
public class NQuenProblem {
    int[] positions = new int[4];

    public static void main(String[] args) {
        NQuenProblem nQuenProblem = new NQuenProblem();
        nQuenProblem.backTrack(3, 0, 0);
    }

    public boolean backTrack(int n, int row, int col) {
        if(col>n) {
            return false;
        }
        if (row > n) {
            processSolution();
            return true;
        }

        boolean canQueenBePlacedAtPosition = false;
        for(; col<=n; col++) {
             canQueenBePlacedAtPosition = canQueenBePlacedAt(n, col, row);
            if(canQueenBePlacedAtPosition)
                break;
        }
        if (canQueenBePlacedAtPosition) {
            positions[row] = col;
            row += 1;
        } else {
            return false;
        }

        if(backTrack(n, row, 0)) {
            return true;
        } else {
            backTrack(n, row-1, positions[row-1]+1);
        }
        return false;
    }

    public void processSolution() {
        for(int pos: positions) {
            System.out.println(pos);
        }
    }

    public boolean canQueenBePlacedAt(int n, int col, int row) {
        if(row == 0) {
            return true;
        } else {

            boolean queensInSameColumn = true;
            boolean queensInDiagonalPositions = true;
            for(int i=1; i<=row; i++) {
                queensInSameColumn = col == positions[i - 1];
                queensInDiagonalPositions = (i - 1 - positions[i - 1]) == (row - col)
                        || (i - 1 + positions[i - 1]) == (row + col);

                if(queensInSameColumn || queensInDiagonalPositions) {
                    return false;
                }

            }

            return true;
        }

    }
}
