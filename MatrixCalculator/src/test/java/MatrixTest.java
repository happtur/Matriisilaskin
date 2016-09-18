
import matrixcalculator.logic.Matrix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {

    Matrix matrix;

    public MatrixTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        matrix = new Matrix(3, 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void theConstructorSetsNumberOfRowsCorrectly() {
        assertEquals(3, matrix.getNumberOfRows());
    }

    @Test
    public void theConstructorSetsNumberOfColumnsCorrectly() {
        assertEquals(2, matrix.getNumberOfColumns());
    }

    @Test
    public void theConstructorSetsAllTheElementsToZero() {
        assertEquals(true, matrix.getValue(1, 1) == 0
                && matrix.getValue(1, 2) == 0
                && matrix.getValue(2, 1) == 0
                && matrix.getValue(2, 2) == 0
                && matrix.getValue(3, 1) == 0
                && matrix.getValue(3, 2) == 0);
    }

    @Test
    public void theSetValueFunctionWorks() {
        matrix.setValue(1, 2, 2);
        assertEquals(2.0, matrix.getValue(1, 2), 0.0);
    }

    @Test
    public void theSetRowFunctionWorks() {
        matrix.setRow(2, new double[]{545.89, -7});
        assertEquals(true, matrix.getValue(2, 1) == 545.89
                && matrix.getValue(2, 2) == -7.0);
    }

    //double ==
    @Test
    public void theGetRowFunctionReturnsTheRightRow() {
        matrix.setRow(2, new double[]{-2.4, 0.2});
        double[] rowGet = matrix.getRow(2);
        assertEquals(true, rowGet[0] == -2.4
                && rowGet[1] == 0.2);
    }

//     @Test
//     public void theGetColumnFunctionReturnsTheRightRow() {
//         double[] rowPut = {5, 7};
//         matrix.setRow(2, rowPut);
//         
//         double[] rowPut2 = {-3, 6};
//         matrix.setRow(3, rowPut2);
//         
//         double[] column = matrix.getColumn(1);
//         assertEquals(true, column[0] == 0
//                            && column[1] == 5
//                            && column[2] == -3);
//     }
    
    @Test
    public void toStringReturnsTheDesiredString() {
        matrix.setRow(1, new double[]{1.2, 2.3});
        matrix.setRow(2, new double[]{-4.5, 2});
        matrix.setRow(3, new double[]{8, 0});

        assertEquals("1.2, 2.3, \n-4.5, 2.0, \n8.0, 0.0, \n", matrix.toString());
    }

}
