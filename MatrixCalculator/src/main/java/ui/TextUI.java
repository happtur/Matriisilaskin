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
     * Starts the ui, asks the user what they want to do until the user chooses
     * to stop.
     *
     */
    public void start() {
        boolean stop = false;

        while (!stop) {
            System.out.println("Choose:\n"
                    + "1. Addition\n"
                    + "2. Subtraction\n"
                    + "3. Trace\n"
                    + "4. Scalar multiplication\n"
                    + "5. Product of two matrices\n"
                    + "6. Exit\n");

            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            int choice = this.scanner.nextInt();

            switch (choice) {
                case 1:
                    performAddition(false);
                    break;
                case 2:
                    performAddition(true);
                    break;
                case 3:
                    performTraceCalculator();
                    break;
                case 4:
                    performScalarMultiplication();
                    break;
                case 5:
                    performMatrixMultiplication();
                    break;
                case 6:
                    stop = true;
                    break;
                default:
                    System.out.println(choice + " is not an option");
                    break;
            }
        }

        System.out.println("Have a nice day! :)");
    }

    private void performAddition(boolean subtraction) {
        if (subtraction) {
            System.out.println("SUBTRACTION");
        } else {
            System.out.println("ADDITION");
        }
        AdditionCalculator ac = this.initiateAddition(subtraction);
        ac.calculate();
        System.out.println(ac);
    }

    private void performTraceCalculator() {
        System.out.println("TRACE");
        TraceCalculator tc = this.initiateTraceCalculator();
        tc.calculate();
        System.out.println(tc);
    }

    private void performScalarMultiplication() {
        System.out.println("SCALAR MULTIPLICATION");
        ScalarMultiplicationCalculator smc = this.initiateScalarMultiplication();
        smc.calculate();
        System.out.println(smc);
    }

    private void performMatrixMultiplication() {
        System.out.println("MATRIX MULTIPLICATION");
        ProductCalculator pc = this.initiateMatrixMultiplication();
        pc.calculate();
        System.out.println(pc);
    }

    //I'll keep the comments for now even though the initiate-functions are private
    /**
     * Asks for the components needed for matrix addition or subtraction from
     * the user, returns an AdditionCalculator with these components.
     *
     * @param subtraction if true the calculator performs subtraction, otherwise
     * addition
     * @return the set up calculator
     */
    private AdditionCalculator initiateAddition(boolean subtraction) {
        //in the future have getRowMatrix (naaah), getInteger with message as parameter etc and the 
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
     * returns a ScalarMultiplicationCalculator with these components.
     *
     * @return the set up calculator
     */
    private ScalarMultiplicationCalculator initiateScalarMultiplication() {
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
     * returns a TraceCalculator with these components. The needed components
     * are a square matrix, the user decides the size
     *
     * @return the set up calculator
     */
    private TraceCalculator initiateTraceCalculator() {
        int n = this.askSize(0);
        Matrix matrix = this.readMatrix(n, n);

        return new TraceCalculator(matrix);
    }

    /**
     * Asks for the components needed for calculating the product of two
     * matrices from the user, returns a TraceCalculator with these components.
     * The needed components are a m x n-matrix and a n x p-matrix, the user
     * decides the sizes
     *
     * @return the set up calculator
     */
    private ProductCalculator initiateMatrixMultiplication() {
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
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int size = this.scanner.nextInt();

        while (size <= 0) {
            System.out.println("The amount of " + ofThis + " has to be greater than zero, try again.");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Input has to be an integer");
            }
            size = this.scanner.nextInt();
        }
        
        scanner.skip(".*");
        return size;
    }

    private double[] readRow(int n, int i) {
        double[] row = new double[n];
        int k = 0;

        System.out.print("Matrix row " + i + ": ");

        while (k < n) {
            while (!scanner.hasNextDouble()) {
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

        for (int i = 1; i <= m; i++) {
            matrix.setRow(i, this.readRow(n, i));
        }

        System.out.println("");
        return matrix;
    }

}
