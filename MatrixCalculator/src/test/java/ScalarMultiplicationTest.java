
import calculators.ScalarMultiplicationCalculator;
import java.util.Arrays;
import matrixcalculator.logic.Matrix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScalarMultiplicationTest {

    Matrix matrix;
    Matrix simpleMatrix;

    public ScalarMultiplicationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        matrix = new Matrix(2, 3);
        matrix.setRow(1, new double[]{2, 8.4, 6});
        matrix.setRow(2, new double[]{10.3, 0, -3});

        simpleMatrix = new Matrix(1, 1);
        simpleMatrix.setValue(1, 1, 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ifScalarIsZeroTheResultIsAZeroMatrix() {
        ScalarMultiplicationCalculator smc = new ScalarMultiplicationCalculator(matrix, 0);
        Matrix result = smc.calculate();
        double[] zeroRow = {0, 0, 0};

        assertTrue("" + result, Arrays.equals(result.getRow(1), zeroRow)
                && Arrays.equals(result.getRow(2), zeroRow));
    }

    @Test
    public void ifScalarIsOneTheResultIsACopyOfTheOriginalMatrix() {
        ScalarMultiplicationCalculator smc = new ScalarMultiplicationCalculator(matrix, 1);
        Matrix result = smc.calculate();

        assertTrue(Arrays.equals(result.getRow(1), new double[]{2, 8.4, 6})
                && Arrays.equals(result.getRow(2), new double[]{10.3, 0, -3}));
    }

    @Test
    public void producesTheRightAnswerWithAPositiveScalar() {
        ScalarMultiplicationCalculator smc = new ScalarMultiplicationCalculator(matrix, 3.2);
        Matrix result = smc.calculate();

        assertEquals(6.4, result.getValue(1, 1), 0.0000001);
        assertEquals(26.88, result.getValue(1, 2), 0.0000001);
        assertEquals(19.2, result.getValue(1, 3), 0.0000001);
        assertEquals(32.96, result.getValue(2, 1), 0.0000001);
        assertEquals(0, result.getValue(2, 2), 0.0000001);
        assertEquals(-9.6, result.getValue(2, 3), 0.0000001);
    }

    @Test
    public void producesTheRightAnswerWithANegativeScalar() {
        ScalarMultiplicationCalculator smc = new ScalarMultiplicationCalculator(matrix, -4);
        Matrix result = smc.calculate();

        assertEquals(-8, result.getValue(1, 1), 0.0000001);
        assertEquals(-33.6, result.getValue(1, 2), 0.0000001);
        assertEquals(-24, result.getValue(1, 3), 0.0000001);
        assertEquals(-41.2, result.getValue(2, 1), 0.0000001);
        assertEquals(0, result.getValue(2, 2), 0.0000001);
        assertEquals(12, result.getValue(2, 3), 0.0000001);
    }

    @Test
    public void toStringReturnsTheDesiredString() {
        ScalarMultiplicationCalculator smc = new ScalarMultiplicationCalculator(simpleMatrix, 2);
        smc.calculate();

        assertEquals("2.0\n\n1.0, \n\n2.0, \n\n", smc.toString());
    }
}
