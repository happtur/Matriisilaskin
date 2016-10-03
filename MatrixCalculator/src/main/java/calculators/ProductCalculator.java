package calculators;

import matrixcalculator.logic.Matrix;

/**
 *  This class handles the calculation of the product of two matrices 
 * (i.e. matrix multiplication) given in the constructor.
 */
public class ProductCalculator {

    private Matrix matrixA;
    private Matrix matrixB;
    private Matrix result;

    /**
     * The constructor with the needed components for calculating the product as
     * parameters.
     *
     * @param matrixA the first matrix
     * @param matrixB the second matrix
     */
    public ProductCalculator(Matrix matrixA, Matrix matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = new Matrix(matrixA.getNumberOfRows(), matrixB.getNumberOfColumns());
    }

    //now checks if 2^k x 2^k - matrix every time, separate 'the first' and the recursion so it only checks once.

    /**
     * The function calculates the product of the matrices given in the constructor.
     *
     * @return the resulting matrix
     */
    public Matrix calculate() {
        int aRows = matrixA.getNumberOfRows();
        int aColumns = matrixA.getNumberOfColumns();
        int bRows = matrixB.getNumberOfRows();
        int bColumns = matrixB.getNumberOfColumns();

        if (aRows != aColumns
                || aRows != bRows
                || bRows != bColumns
                || Math.log(aRows) / Math.log(2) != Math.round(Math.log(aRows) / Math.log(2))) {

            int biggestSize = Math.max(aRows,
                    Math.max(aColumns,
                            Math.max(bRows, bColumns)));

            int filledSize = (int) Math.pow(2, Math.ceil(Math.log(biggestSize) / Math.log(2)));

            //changes A and B!
            matrixA = matrixA.getFilledMatrix(filledSize);
            matrixB = matrixB.getFilledMatrix(filledSize);

        } else if (aRows == 1) {
            result.setValue(1, 1, matrixA.getValue(1, 1) * matrixB.getValue(1, 1));            
            return result;
        }
        
        Matrix m1 = this.M1();
        Matrix m2 = this.M2();
        Matrix m3 = this.M3();
        Matrix m4 = this.M4();
        Matrix m5 = this.M5();
        Matrix m6 = this.M6();
        Matrix m7 = this.M7();

        Matrix upperLeft = new AdditionCalculator(
                new AdditionCalculator(
                        new AdditionCalculator(m1, m4, false).calculate(),
                        m5, true).calculate(),
                m7, false).calculate();
        
        Matrix upperRight = new AdditionCalculator(m3, m5, false).calculate();
        
        Matrix lowerLeft = new AdditionCalculator(m2, m4, false).calculate();
        
        Matrix lowerRight = new AdditionCalculator(
                new AdditionCalculator(
                        new AdditionCalculator(m1, m2, true).calculate(), 
                        m3, false).calculate(),
                m6, false).calculate();
        
        //huom. matrixA.getNum... only if it's 'filled'
        Matrix filledResult = new Matrix(matrixA.getNumberOfRows(), matrixA.getNumberOfRows());
        filledResult.setMatrix(upperLeft, upperRight, lowerLeft, lowerRight);
        result = filledResult.getSubmatrix(1, result.getNumberOfRows(), 1, result.getNumberOfColumns());

        return result;
    }

    private Matrix M1() {
        Matrix first = new AdditionCalculator(matrixA.getUpperLeftQuarter(), matrixA.getLowerRightQuarter(), false).calculate();
        Matrix second = new AdditionCalculator(matrixB.getUpperLeftQuarter(), matrixB.getLowerRightQuarter(), false).calculate();
        return new ProductCalculator(first, second).calculate();
    }

    private Matrix M2() {
        Matrix first = new AdditionCalculator(matrixA.getLowerLeftQuarter(), matrixA.getLowerRightQuarter(), false).calculate();
        return new ProductCalculator(first, matrixB.getUpperLeftQuarter()).calculate();
    }

    private Matrix M3() {
        Matrix second = new AdditionCalculator(matrixB.getUpperRightQuarter(), matrixB.getLowerRightQuarter(), true).calculate();
        return new ProductCalculator(matrixA.getUpperLeftQuarter(), second).calculate();
    }

    private Matrix M4() {
        Matrix second = new AdditionCalculator(matrixB.getLowerLeftQuarter(), matrixB.getUpperLeftQuarter(), true).calculate();
        return new ProductCalculator(matrixA.getLowerRightQuarter(), second).calculate();
    }

    private Matrix M5() {
        Matrix first = new AdditionCalculator(matrixA.getUpperLeftQuarter(), matrixA.getUpperRightQuarter(), false).calculate();
        return new ProductCalculator(first, matrixB.getLowerRightQuarter()).calculate();
    }

    private Matrix M6() {
        Matrix first = new AdditionCalculator(matrixA.getLowerLeftQuarter(), matrixA.getUpperLeftQuarter(), true).calculate();
        Matrix second = new AdditionCalculator(matrixB.getUpperLeftQuarter(), matrixB.getUpperRightQuarter(), false).calculate();
        return new ProductCalculator(first, second).calculate();
    }

    private Matrix M7() {
        Matrix first = new AdditionCalculator(matrixA.getUpperRightQuarter(), matrixA.getLowerRightQuarter(), true).calculate();
        Matrix second = new AdditionCalculator(matrixB.getLowerLeftQuarter(), matrixB.getLowerRightQuarter(), false).calculate();
        return new ProductCalculator(first, second).calculate();
    }

    @Override
    public String toString() {
        return "" + matrixA + "\n" + matrixB + "\n" + result + "\n";
    }

}
