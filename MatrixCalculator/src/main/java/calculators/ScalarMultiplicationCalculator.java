package calculators;

import matrixcalculator.logic.Matrix;

/**
 * This class handles the multiplication of a scalar and a matrix, both given in
 * the constructor.
 */
public class ScalarMultiplicationCalculator {

    private Matrix matrix;
    private double scalar;
    private Matrix result;

    /**
     * The constructor with the needed components for the multiplication as
     * parameters.
     *
     * @param matrix the matrix
     * @param scalar the scalar
     */
    public ScalarMultiplicationCalculator(Matrix matrix, double scalar) {
        this.matrix = matrix;
        this.scalar = scalar;
        this.result = new Matrix(matrix.getNumberOfRows(), matrix.getNumberOfColumns());
    }

    /**
     * The function calculates the scalar multiplication.
     *
     * @return the resulting matrix
     */
    public Matrix calculate() {
        for (int i = 1; i <= matrix.getNumberOfRows(); i++) {
            double[] row = matrix.getRow(i);
            double[] resultRow = new double[row.length];

            for (int j = 0; j < row.length; j++) {
                //"+ 0" to avoid -0
                resultRow[j] = scalar * row[j] + 0;
            }

            result.setRow(i, resultRow);
        }

        return result;
    }

    @Override
    public String toString() {
        return "" + scalar + "\n" + matrix + "\n" + result + "\n";
    }
}
