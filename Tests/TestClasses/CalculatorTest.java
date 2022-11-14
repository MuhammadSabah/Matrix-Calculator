package Tests.TestClasses;

import org.junit.Assert;
import org.junit.Test;

import Model.CalculatorModel;
public class CalculatorTest {

    @Test
    public void testAdd() {
        CalculatorModel calculator = new CalculatorModel(3,3);
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{1,2,3},{4,5,6},{7,8,9}}; 
        int[][] exp = {{2,4,6},{8,10,12},{14,16,18}}; 
        calculator.addTwoMatrices(a, b);
        int[][] result = calculator.getMatrixValue();
        Assert.assertEquals(exp, result);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < exp.length; i++) {
            for (int j = 0; j < exp[0].length; j++) {
                System.out.print(exp[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("They are equal, so the test passed!");

    }
    @Test
    public void testSub() {
        CalculatorModel calculator = new CalculatorModel(3,3);
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{1,2,3},{4,5,6},{7,8,9}}; 
        int[][] exp = {{0,0,0},{0,0,0},{0,0,0}}; 
        calculator.subTwoMatrices(a, b);
        int[][] result = calculator.getMatrixValue();
        Assert.assertEquals(exp, result);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================================");
        for (int i = 0; i < exp.length; i++) {
            for (int j = 0; j < exp[0].length; j++) {
                System.out.print(exp[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("They are equal, so the test passed!");

    }

    @Test
    public void testMultiply() {
        CalculatorModel calculator = new CalculatorModel(3,3);
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{1,2,3},{4,5,6},{7,8,9}}; 
        int[][] exp = {{30,36,42},{66,81,96},{102,126,150}}; 
        calculator.multiplyTwoMatrices(a, b);
        int[][] result = calculator.getMatrixValue();
        Assert.assertEquals(exp, result);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================================");
        for (int i = 0; i < exp.length; i++) {
            for (int j = 0; j < exp[0].length; j++) {
                System.out.print(exp[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("They are equal, so the test passed!");

    }
    
   

    // @Test
    // public void testMultiply() {
    //     CalculatorModel calculator = new CalculatorModel(3,3);
    //     int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
    //     int[][] b = {{1,2,3},{4,5,6},{7,8,9}}; 
    //     calculator.multiplyTwoMatrices(a, b);
    //     int[][] result = calculator.getMatrixValue();
    //     for (int i = 0; i < result.length; i++) {
    //         for (int j = 0; j < result[0].length; j++) {
    //             System.out.print(result[i][j] + " ");
    //         }
    //         System.out.println();
    //     }

    // }

}