
package calculators;

import matrixcalculator.logic.Matrix;

/**
 * This class handles the trace calculation of the matrix given in the constructor.
 */
public class TraceCalculator {
    
    private Matrix matrix;
    private double result;
    
    /**
     * The constructor with the needed components for calculating the trace as
     * parameters.
     *
     * @param matrix the matrix
     */
    public TraceCalculator(Matrix matrix) {
        this.matrix = matrix;
        this.result = 0;
    }
    
    /**
     * The function calculates the trace of the matrix given in the constructor.
     *
     * @return the trace
     */
    public double calculate() {
        for(int i = 1; i <= matrix.getNumberOfRows(); i++) {
            this.result += matrix.getValue(i, i);
        }
        
        return this.result;
    }
    
    @Override
    public String toString() {
        return "" + matrix + "\n" + result + "\n";
    }
}
