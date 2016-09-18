package calculators;

import matrixcalculator.logic.Matrix;

/**
 * This class handles the addition (or subtraction) of two matrices given in the
 * constructor.
 *
 */
public class AdditionCalculator {

    private Matrix matrixA;
    private Matrix matrixB;
    private int sign;
    //no "result", muokkaus of joko A tai B (?)
    private Matrix result;

    /**
     * The constructor with the needed components for addition or subtraction as
     * parameters.
     *
     * @param matrixA the first matrix
     * @param matrixB the second matrix
     * @param subtraction true if the difference between matrixA and matrixB is
     * to be calculated, otherwise the sum is calculated
     */
    public AdditionCalculator(Matrix matrixA, Matrix matrixB, boolean subtraction) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = new Matrix(matrixA.getNumberOfRows(), matrixA.getNumberOfColumns());

        if (subtraction) {
            this.sign = -1;
        } else {
            this.sign = 1;
        }
    }

    /**
     * The function calculates the sum (or difference) of the matrices.
     *
     * @return the resulting matrix
     */
    public Matrix calculate() {
        for (int i = 1; i <= matrixA.getNumberOfRows(); i++) {
            double[] rowA = matrixA.getRow(i);
            double[] rowB = matrixB.getRow(i);
            double[] rowC = new double[rowA.length];

            for (int j = 0; j < rowA.length; j++) {
                rowC[j] = rowA[j] + sign * rowB[j];
            }

            result.setRow(i, rowC);
        }

        return result;
    }

    @Override
    public String toString() {
        return "" + matrixA + "\n" + matrixB + "\n" + result + "\n";
    }
}
