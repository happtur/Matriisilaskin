package matrixcalculator.logic;

import calculators.AdditionCalculator;
import calculators.ScalarMultiplicationCalculator;
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

        Matrix m = new Matrix(-1, 0);
        System.out.println(m);

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
    }

}
