package matrixcalculator.logic;

/**
 * The class sets and stores the matrix-elements.
 */
public class Matrix {

    //rows, columns - 'sections'? + boolean isRowMatrix?
    //but won't use the traditional matrix multiplication so no need for column..?
    //or operations in here more..?
    //constructor Matrix(Matrix copyThis) ? then there's both the result and the original, if needed
    //static createIdentityMatrix(int n)
    //compare
    //alkeisrivitoimitukset? with variation from element x to element y
    private double[][] rows;
    private int numberOfColumns;

    /**
     * The constructor, creates a null matrix.
     *
     * @param numberOfRows the desired number of rows in the matrix, has to be a
     * positive integer
     * @param numberOfColumns the desired number of columns in the matrix, has
     * to be a positive integer
     */
    public Matrix(int numberOfRows, int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
        this.rows = new double[numberOfRows][numberOfColumns];
    }

    /**
     * Sets the element in [row, column] to value.
     *
     * @param row the row of the element that is to be set
     * @param column the column of the element that is to be set
     * @param value the new value of the element
     */
    public void setValue(int row, int column, double value) {
        this.rows[row - 1][column - 1] = value;
    }

    /**
     * Gives the row rowNumber the values in rowValues.
     *
     * @param rowNumber the number of the row with the elements that are going
     * to be set
     * @param rowValues the values that the elements are going to get
     */
    public void setRow(int rowNumber, double[] rowValues) {
        //security check..?        
        this.rows[rowNumber - 1] = rowValues;
    }

    /**
     * Returns the number of rows in this matrix.
     *
     * @return the number of rows
     */
    public int getNumberOfRows() {
        return this.rows.length;
    }

    /**
     * Returns the number of columns in this matrix.
     *
     * @return the number of columns
     */
    public int getNumberOfColumns() {
        return this.numberOfColumns;

//        if (this.rows.length == 0) {
//            return 0;
//        } else {
//            return this.rows[0].length;
//        }
    }

    /**
     * Returns the element at [row, column].
     *
     * @param row the number of the row the wanted element is in
     * @param column the number of the column the wanted element is in
     * @return the element at [row, column]
     */
    public double getValue(int row, int column) {
        return this.rows[row - 1][column - 1];
    }

    /**
     * Returns the elements of row rowNumber as an array.
     *
     * @param rowNumber the number of the row the wanted elements are in
     * @return the elements of row rowNumber
     */
    public double[] getRow(int rowNumber) {
        return this.rows[rowNumber - 1];
    }

    /**
     * Returns the elements of column columnNumber as an array (not yet
     * implemented).
     *
     * @param columnNumber the number of the column the wanted elements are in
     * @return the elements of column columnNumber
     */
    public double[] getColumn(int columnNumber) {
        return new double[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : rows) {
            for (int j = 0; j < rows[0].length; j++) {
                sb.append(row[j]);
                sb.append(", ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
