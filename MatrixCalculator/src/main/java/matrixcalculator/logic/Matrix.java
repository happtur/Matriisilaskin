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
    //atm doesn't really use numberOfColumns, if permanent, change this
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
    
    private double[] getPartOfRow(int rowNumber, int columnStart, int columnEnd) {
        double[] wholeRow = this.rows[rowNumber - 1];
        double[] part = new double[columnEnd - columnStart + 1];
        
        for(int i = 0; i <= columnEnd - columnStart; i++) {
            part[i] = wholeRow[columnStart + i - 1];
        }
        
        return part;
    }

    /**
     * Returns the submatrix in the upper left quarter of this matrix. Only works with (2k)x(2k)-matrices
     * 
     * @return the upper left corner as a matrix
     */
        public Matrix getUpperLeftQuarter() {
        return this.getSubmatrix(1, this.getNumberOfRows()/2, 1, this.getNumberOfColumns()/2);
    }
    
    /**
     * Returns the submatrix in the upper right quarter of this matrix. Only works with (2k)x(2k)-matrices
     *
     * @return the upper right corner as a matrix
     */
    public Matrix getUpperRightQuarter() {
        return this.getSubmatrix(1, this.getNumberOfRows()/2, this.getNumberOfColumns()/2 + 1, this.getNumberOfColumns());
    }
    
    /**
     * Returns the submatrix in the lower left quarter of this matrix. Only works with (2k)x(2k)-matrices
     *
     * @return the lower left corner as a matrix
     */
    public Matrix getLowerLeftQuarter() {
        return this.getSubmatrix(this.getNumberOfRows()/2 + 1, this.getNumberOfRows(), 1, this.getNumberOfColumns()/2);
    }
    
    /**
     * Returns the submatrix in the lower right quarter of this matrix. Only works with (2k)x(2k)-matrices
     *
     * @return the lower right corner as a matrix
     */
    public Matrix getLowerRightQuarter() {
        return this.getSubmatrix(this.getNumberOfRows()/2 + 1, this.getNumberOfRows(), this.getNumberOfColumns()/2 + 1, this.getNumberOfColumns());
    }
    
    //no check for rowStart < rowEnd
    /**
     * Returns the submatrix defined by the function's parameters. The rows and columns are numbered beginning with 1
     *
     * @param rowStart the number of the first row that is to be included in the resulting matrix
     * @param rowEnd the number of the last row that is to be included in the resulting matrix 
     * @param columnStart the number of the first column that is to be included in the resulting matrix
     * @param columnEnd the number of the last column that is to be included in the resulting matrix 
     * @return the resulting matrix
     */
        public Matrix getSubmatrix(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        Matrix part = new Matrix(rowEnd - rowStart + 1, columnEnd - columnStart + 1);
        
        for(int i = 0; i <= rowEnd - rowStart; i++) {
            double[] newRow = this.getPartOfRow(rowStart + i, columnStart, columnEnd);
            part.setRow(i + 1, newRow);
        }
        
        return part;
    }
    
    //doesn't check if filledSize is smaller than "this"
    /**
     * The function returns a square matrix in the requested size, with the elements 
     * of the original matrix in its upper left corner, and sets the value of the 
     * rest of the elements to zero.
     *
     * @param filledSize the number of rows and columns in the resulting matrix
     * @return the filled matrix
     */
    public Matrix getFilledMatrix(int filledSize) {
        Matrix filledMatrix = new Matrix(filledSize, filledSize);
        for(int i = 1; i <= this.getNumberOfRows(); i++) {
            filledMatrix.setFilledRow(i, this.getRow(i));
        }
        
        return filledMatrix;
    }
    
    private void setFilledRow(int rowNumber, double[] rowValues) {
        if(rowValues.length == this.getNumberOfColumns()) {
            this.setRow(rowNumber, rowValues);
        } else {
            double[] rowToBeSet = this.rows[rowNumber - 1];
            for(int i = 0; i < rowValues.length; i++) {
                rowToBeSet[i] = rowValues[i];            }
        }
    }
    
    //assumes that all submatrices are square matrices of the same size
    /**
     * Combines four matrices into one matrix.
     *
     * @param upperLeft the upper left quarter of the resulting matrix
     * @param upperRight the upper right quarter of the resulting matrix
     * @param lowerLeft the lower left quarter of the resulting matrix
     * @param lowerRight the lower right quarter of the resulting matrix
     */
    public void setMatrix(Matrix upperLeft, Matrix upperRight, Matrix lowerLeft, Matrix lowerRight) {        
        int halfSize = upperRight.getNumberOfRows();
        
        for(int i = 1; i <= halfSize; i++) {
            double[] rowValues = new double[2 * halfSize];
            System.arraycopy(upperLeft.getRow(i), 0, rowValues, 0, halfSize);
            System.arraycopy(upperRight.getRow(i), 0, rowValues, halfSize, halfSize);
            
            this.setRow(i, rowValues);
        }
        
        for(int i = 1; i <= halfSize; i++) {
            double[] rowValues = new double[2 * halfSize];
            System.arraycopy(lowerLeft.getRow(i), 0, rowValues, 0, halfSize);
            System.arraycopy(lowerRight.getRow(i), 0, rowValues, halfSize, halfSize);
            
            this.setRow(halfSize + i, rowValues);
        }
    }
    
    /**
     * Checks if the matrix is a null matrix, ie all its elements have the value zero.
     *
     * @return boolean of "this is a null matrix"
     */
    public boolean isNullMatrix() {
        for(double[] row : this.rows) {
            for(double element : row) {
                if(element != 0) {
                    return false;
                }
            }
        }
        
        return true;
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
