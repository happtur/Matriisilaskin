package ui;

import calculators.*;
import java.util.Scanner;
import matrixcalculator.logic.Matrix;

/**
 * The temporary (?) user interface
 * 
 */
public class TextUI {

    private Scanner scanner;

    /**
     * The constructor...
     */
    public TextUI() {
        this.scanner = new Scanner(System.in);
    }

    
    /**
     * Asks for the components needed for matrix addition or subtraction from the user,
     *  returns an AdditionCalculator with these components.
     * 
     * @param subtraction if true the calculator performs subtraction, otherwise addition
     * @return the set up calculator
     */
    public AdditionCalculator initiateAddition(boolean subtraction) {
        //in the future have getRowMatrix, getInteger with message as parameter etc and the 
        //'initialization' elsewhere.. also make using the same matrix in several 
        //different calculations possible?
        int m = this.askSize(0);
        int n = this.askSize(1);
        
        System.out.println("First matrix:");
        Matrix matrixA = this.readMatrix(m, n);
        System.out.println("Second matrix:");
        Matrix matrixB = this.readMatrix(m, n);
        
        return new AdditionCalculator(matrixA, matrixB, subtraction);
    }
    
    /**
     * Asks for the components needed for scalar multiplication from the user,
     *  returns a ScalarMultiplicationCalculator with these components.
     *
     * @return the set up calculator
     */
    public ScalarMultiplicationCalculator initiateScalarMultiplication() {
        int m = this.askSize(0);
        int n = this.askSize(1);
        
        System.out.print("Scalar: ");
        double scalar = this.scanner.nextDouble();
        
        System.out.println("Matrix:");
        Matrix matrix = this.readMatrix(m, n);
        
        return new ScalarMultiplicationCalculator(matrix, scalar);
    }
    
    /**
     * Asks for the components needed for trace calculation from the user,
     *  returns a TraceCalculator with these components. The needed components
     *  are a square matrix, the user decides the size
     *
     * @return the set up calculator
     */
    public TraceCalculator initiateTraceCalculator() {
        int n = this.askSize(0);
        Matrix matrix = this.readMatrix(n, n);
        
        return new TraceCalculator(matrix);
    }
    
    //temporary function
    public Matrix initiateQuarters() {
        int n = this.askSize(0);
        return this.readMatrix(n, n);
    }
    
    //temporary function
    public Matrix initiateFilling() {
        int m = this.askSize(0);
        int n = this.askSize(1);
        
        return this.readMatrix(m, n);
    }
    
    /**
     * Asks for the components needed for calculating the product of two matrices
     * from the user, returns a TraceCalculator with these components.
     * The needed components are a m x n-matrix and a n x p-matrix, the user
     * decides the sizes
     *
     * @return the set up calculator
     */
    public ProductCalculator initiateMatrixMultiplication() {
        System.out.println("First matrix:\n");
        int m = this.askSize(0);
        int n = this.askSize(1);
        Matrix matrixA = this.readMatrix(m, n);
        
        System.out.println("Second matrix:\n");
        int p = this.askSize(1);
        Matrix matrixB = this.readMatrix(n, p);
        
        return new ProductCalculator(matrixA, matrixB);
    }
    
    private int askSize(int rowsOrColumns) {
        String ofThis = "columns";
        if (rowsOrColumns == 0) {
            ofThis = "rows";
        }
        
        System.out.println("How many " + ofThis + "?");
        while(!scanner.hasNextInt()) {
            scanner.next();
        }
        int size = this.scanner.nextInt();
        
        while(size <= 0) {
            System.out.println("The amount of " + ofThis + " has to be greater than zero, try again.");
            while(!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Input has to be an integer");
            }
            size = this.scanner.nextInt();
        }
        return size;
    }

    private double[] readRow(int n, int i) {
        double[] row = new double[n];
        int k = 0;

        System.out.print("Matrix row " + i + ": ");

        while (k < n) {
            while(!scanner.hasNextDouble()) {
                scanner.next();
            }
            row[k] = this.scanner.nextDouble();
            k++;
        }

        scanner.skip(".*");
        return row;
    }
    
    private Matrix readMatrix(int m, int n) {        
        Matrix matrix = new Matrix(m, n);
        
        for(int i = 1; i <= m; i++) {
            matrix.setRow(i, this.readRow(n, i));
        }
        
        System.out.println("");
        return matrix;
    }

}
