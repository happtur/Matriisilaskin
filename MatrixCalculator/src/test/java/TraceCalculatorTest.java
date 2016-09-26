/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import calculators.TraceCalculator;
import matrixcalculator.logic.Matrix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TraceCalculatorTest {
    
    public TraceCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ifTheMatrixOnlyHasOneElementTheTraceIsTheValueOfThatElement() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setValue(1, 1, -5.6);
        TraceCalculator tc = new TraceCalculator(matrix);
        
        assertEquals(-5.6, tc.calculate(), 0.000001);
    }
    
    @Test
    public void aNullMatrixHasTheTraceZero() {
        Matrix matrix = new Matrix(3, 3);
        matrix.setRow(1, new double[]{0, 0, 0});
        matrix.setRow(2, new double[]{0, -0, 0});
        matrix.setRow(3, new double[]{0, 0, 0.0});
        TraceCalculator tc = new TraceCalculator(matrix);
        
        assertEquals(0, tc.calculate(), 0.000001);
    }
    
    @Test
    public void producesTheRightAnswerSmallTest1() {
        Matrix matrix = new Matrix(5, 5);
        matrix.setRow(1, new double[]{2, 8.4, 6, 0, 3.4});
        matrix.setRow(2, new double[]{10.3, -6.743, -3, 2, 5});
        matrix.setRow(3, new double[]{2.56, 3, 5.7, 4, 5});
        matrix.setRow(4, new double[]{2, 0, 0, 7, 3});
        matrix.setRow(5, new double[]{1, 4, 7, 5.6, 5});
        TraceCalculator tc = new TraceCalculator(matrix);
        
        assertEquals(12.957, tc.calculate(), 0.000001);
    }
    
    @Test
    public void producesTheRightAnswerSmallTest2() {
        Matrix matrix = new Matrix(5, 5);
        matrix.setRow(1, new double[]{-4, 0, 0, 0, 0});
        matrix.setRow(2, new double[]{0, 43.456, 0, 0, 0});
        matrix.setRow(3, new double[]{0, 0, -56.7, 0, 0});
        matrix.setRow(4, new double[]{0, 0, 0, 3, 0});
        matrix.setRow(5, new double[]{0, 0, 0, 0, 12.578});
        TraceCalculator tc = new TraceCalculator(matrix);
        
        assertEquals(-1.666, tc.calculate(), 0.000001);
    }
    
    @Test
    public void toStringReturnsTheDesiredString() {
        Matrix matrix = new Matrix(2, 2);
        matrix.setRow(1, new double[]{-6.78, -3});
        matrix.setRow(2, new double[]{23, 24.657});
        TraceCalculator tc = new TraceCalculator(matrix);
        tc.calculate();
        
        assertEquals("-6.78, -3.0, \n23.0, 24.657, \n\n17.877\n", tc.toString());
    }
}
