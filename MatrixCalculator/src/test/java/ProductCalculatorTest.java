/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import calculators.ProductCalculator;
import matrixcalculator.logic.Matrix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductCalculatorTest {
    Matrix nullMatrix;
    Matrix matrixA;
    Matrix matrixB;
    Matrix matrixC;
    Matrix fullA;
    Matrix fullB;
    
    public ProductCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nullMatrix = new Matrix(5, 3);
        
        matrixA = new Matrix(2, 5);
        matrixA.setRow(1, new double[]{2.56, -8.4, 4, 3, 0});
        matrixA.setRow(2, new double[]{10, -7.4, 4.67, 7, -5});
        
        matrixB = new Matrix(3, 3);
        matrixB.setRow(1, new double[]{7, 5, 4});
        matrixB.setRow(2, new double[]{3, 6, 2});
        matrixB.setRow(3, new double[]{6, 0, 5});
        
        matrixC = new Matrix(3, 2);
        matrixC.setRow(1, new double[]{-4.78, 0});
        matrixC.setRow(2, new double[]{3.67, -1});
        matrixC.setRow(3, new double[]{4, 1});
        
        fullA = new Matrix(4, 4);
        fullA.setRow(1, new double[]{5.7, -4, -3.32, 6});
        fullA.setRow(2, new double[]{5.7, 7, -5.8, 10});
        fullA.setRow(3, new double[]{4, 2, 1, 0});
        fullA.setRow(4, new double[]{5.6, -2, -1, 5});
        
        fullB = new Matrix(4, 4);
        fullB.setRow(1, new double[]{2, 1, -2.2, 4});
        fullB.setRow(2, new double[]{4.12, 1, 4.5, -3});
        fullB.setRow(3, new double[]{1, 0, 1, 0});
        fullB.setRow(4, new double[]{3, -2, -1, 5});
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void theResultIsTheCorrectSize() {
            ProductCalculator pc = new ProductCalculator(matrixA, nullMatrix);
            Matrix result = pc.calculate();
            
            assertTrue(result.getNumberOfRows() == 2 && result.getNumberOfColumns() == 3);
    }
    
    @Test
    public void theProductOfANullMatrixAndAnotherIsANullMatrixWhenTheNullMatrixComesFirst() {
            ProductCalculator pc = new ProductCalculator(nullMatrix, matrixB);
            Matrix result = pc.calculate();
            
            assertTrue(result.isNullMatrix());
    }
    
    @Test
    public void theProductOfANullMatrixAndAnotherIsANullMatrixWhenTheNullMatrixComesSecond() {
            ProductCalculator pc = new ProductCalculator(matrixA, nullMatrix);
            Matrix result = pc.calculate();
            
            assertTrue(result.isNullMatrix());
    }
    
    @Test
    public void producesTheRightAnswerWithMatricesThatHaveToBeFilled() {
            ProductCalculator pc = new ProductCalculator(matrixB, matrixC);
            Matrix result = pc.calculate();
            
            assertEquals(0.89, result.getValue(1, 1), 0.0000001);
            assertEquals(-1, result.getValue(1, 2), 0.0000001);
            assertEquals(15.68, result.getValue(2, 1), 0.0000001);
            assertEquals(-4, result.getValue(2, 2), 0.0000001);
            assertEquals(-8.68, result.getValue(3, 1), 0.0000001);
            assertEquals(5, result.getValue(3, 2), 0.0000001);
            
    }
    
    @Test
    public void producesTheRightAnswerWithMatricesThatDoNotHaveToBeFilled() {
        ProductCalculator pc = new ProductCalculator(fullA, fullB);
        Matrix result = pc.calculate();
        
        assertEquals(9.6, result.getValue(1, 1), 0.0000001);
        assertEquals(-10.3, result.getValue(1, 2), 0.0000001);
        assertEquals(-39.86, result.getValue(1, 3), 0.0000001);
        assertEquals(64.8, result.getValue(1, 4), 0.0000001);
        
        assertEquals(64.44, result.getValue(2, 1), 0.0000001);
        assertEquals(-7.3, result.getValue(2, 2), 0.0000001);
        assertEquals(3.16, result.getValue(2, 3), 0.0000001);
        assertEquals(51.8, result.getValue(2, 4), 0.0000001);
        
        assertEquals(17.24, result.getValue(3, 1), 0.0000001);
        assertEquals(6, result.getValue(3, 2), 0.0000001);
        assertEquals(1.2, result.getValue(3, 3), 0.0000001);
        assertEquals(10, result.getValue(3, 4), 0.0000001);
        
        assertEquals(16.96, result.getValue(4, 1), 0.0000001);
        assertEquals(-6.4, result.getValue(4, 2), 0.0000001);
        assertEquals(-27.32, result.getValue(4, 3), 0.0000001);
        assertEquals(53.4, result.getValue(4, 4), 0.0000001);
        
    }
    
    //test nxn where n != 2^k, nxn where n == 2^k and mxn nxp
    
    @Test
    public void toStringReturnsTheDesiredString() {
        ProductCalculator pc = new ProductCalculator(matrixA, nullMatrix);
        Matrix result = pc.calculate();
                
        assertEquals("2.56, -8.4, 4.0, 3.0, 0.0, 0.0, 0.0, 0.0, \n10.0, -7.4, 4.67, 7.0, -5.0, 0.0, 0.0, 0.0, \n"
                + "0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n"
                + "0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n"
                + "0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n\n"
                + "0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n"
                + "0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n"
                + "0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n"
                + "0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, \n\n"
                + "0.0, 0.0, 0.0, \n0.0, 0.0, 0.0, \n\n", pc.toString());
    }
}
