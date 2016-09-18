
import calculators.AdditionCalculator;
import matrixcalculator.logic.Matrix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdditionCalculatorTest {

    Matrix matrixA;
    Matrix matrixB;
    Matrix simpleMatrix;

    public AdditionCalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        matrixA = new Matrix(2, 3);
        matrixA.setRow(1, new double[]{2, 8.4, 6});
        matrixA.setRow(2, new double[]{10.9, 0, -3});

        matrixB = new Matrix(2, 3);
        matrixB.setRow(1, new double[]{-5, 0, 4});
        matrixB.setRow(2, new double[]{6.2, 4, 7});

        simpleMatrix = new Matrix(1, 1);
        simpleMatrix.setValue(1, 1, 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ifConstructorParameterSubtractionIsFalseAdditionIsPerformed() {
        AdditionCalculator ac = new AdditionCalculator(simpleMatrix, simpleMatrix, false);

        assertEquals(2, ac.calculate().getValue(1, 1), 0.0);
    }

    @Test
    public void ifConstructorParameterSubtractionIsTrueSubtractionIsPerformed() {
        AdditionCalculator ac = new AdditionCalculator(simpleMatrix, simpleMatrix, true);

        assertEquals(0, ac.calculate().getValue(1, 1), 0.0);
    }

    @Test
    public void additionProducesTheRightAnswer() {
        AdditionCalculator ac = new AdditionCalculator(matrixA, matrixB, false);
        Matrix result = ac.calculate();

        assertEquals(true, result.getValue(1, 1) == -3
                && result.getValue(1, 2) == 8.4
                && result.getValue(1, 3) == 10
                && result.getValue(2, 1) == 17.1
                && result.getValue(2, 2) == 4
                && result.getValue(2, 3) == 4);
    }

    @Test
    public void subtractionProducesTheRightAnswer() {
        AdditionCalculator ac = new AdditionCalculator(matrixA, matrixB, true);
        Matrix result = ac.calculate();

        assertTrue(result.getValue(1, 1) == 7
                && result.getValue(1, 2) == 8.4
                && result.getValue(1, 3) == 2
                && result.getValue(2, 1) == 4.7
                && result.getValue(2, 2) == -4
                && result.getValue(2, 3) == -10);

    }

    @Test
    public void toStringReturnsTheDesiredString() {
        AdditionCalculator ac = new AdditionCalculator(simpleMatrix, simpleMatrix, false);
        ac.calculate();

        assertEquals("1.0, \n\n1.0, \n\n2.0, \n\n", ac.toString());
    }

}
