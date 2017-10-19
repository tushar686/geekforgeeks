package stringarraysmatrix;

import java.math.BigDecimal;

/**
 * Created by ts250370 on 9/5/17.
 */
public class MatrixRotation {
    int [][] m = new int[][]{
        {0, 1, 2, 3},
        {4, 5, 6, 7},
        {8, 9, 10, 11},
        {12, 13, 14, 15}
    };

    public static void main(String[] args) {
        MatrixRotation matrixRotation = new MatrixRotation();
        matrixRotation.printMatrix();
        matrixRotation.rotate();
    }

    public void rotate() {
        int layer = m.length-1;
        int startPos = 0;

        while (layer > 1) {

            int r0 = startPos;
            int c0 = startPos;
            int c1 = layer;
            int r1 = startPos;
            int r2 = layer;
            int c2 = layer;
            int c3 = startPos;
            int r3 = layer;

            while (c0 < layer) {
                int temp_1 = m[r1][c1];
                m[r1][c1] = m[r0][c0];

                int temp_2 = m[r2][c2];
                m[r2][c2] = temp_1;

                temp_1 = m[r3][c3];
                m[r3][c3] = temp_2;

                m[r0][c0] = temp_1;

                c0 += 1;
                r1 += 1;
                c2 -= 1;
                r3 -= 1;
                printMatrix();
            }

            startPos += 1;
            layer -= 1;
        }
    }


    public void printMatrix() {
        System.out.println();
        for(int row = 0; row < m.length; row++) {
            System.out.println();
            for(int col = 0; col < m.length; col++) {
                System.out.print(m[row][col] + " ");
            }
        }

    }

}
