package matrixcalculator.logic;

import calculators.*;
import ui.TextUI;

/**
 * The Main class.
 */
public class Main {

    /**
     * the main-function conducts the available matrix-calculations one by one
     * at the moment.
     *
     * @param args
     */
    public static void main(String[] args) {
        TextUI ui = new TextUI();

        System.out.println("ADDITION");
        AdditionCalculator ac = ui.initiateAddition(false);
        ac.calculate();
        System.out.println(ac);

        System.out.println("SUBTRACTION");
        AdditionCalculator sc = ui.initiateAddition(true);
        sc.calculate();
        System.out.println(sc);

        System.out.println("SCALAR MULTIPLICATION");
        ScalarMultiplicationCalculator smc = ui.initiateScalarMultiplication();
        smc.calculate();
        System.out.println(smc);
        
        System.out.println("TRACE");
        TraceCalculator tc = ui.initiateTraceCalculator();
        tc.calculate();
        System.out.println(tc);
        
        System.out.println("QUARTERS");
        Matrix matrixA = ui.initiateQuarters();
        System.out.println("UPPER LEFT\n" + matrixA.getUpperLeftQuarter());
        System.out.println("UPPER RIGHT\n" + matrixA.getUpperRightQuarter());
        System.out.println("LOWER LEFT\n" + matrixA.getLowerLeftQuarter());
        System.out.println("LOWER RIGHT\n" + matrixA.getLowerRightQuarter());
        
        System.out.println("FILLING");
        Matrix matrixB = ui.initiateFilling();
        int filledSize = (int) Math.pow(2, Math.ceil(Math.log(Math.max(matrixB.getNumberOfRows(), matrixB.getNumberOfColumns()))/Math.log(2)));
        System.out.println(matrixB.getFilledMatrix(filledSize));
        
        System.out.println("MATRIX MULTIPLICATION");
        ProductCalculator pc = ui.initiateMatrixMultiplication();
        pc.calculate();
        System.out.println(pc);
        
    }

}
