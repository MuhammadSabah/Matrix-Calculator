package Controller;

import java.awt.event.*;

import View.CalculatorView;
import Model.CalculatorModel;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;
        this.calculatorView.addCalculationListener(new calculationListener());
    }

    public int[][] addTwoMatrices(int[][] a, int[][] b) {
        int[][] result = calculatorModel.getResultMatrix();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public int[][] subTwoMatrices(int[][] a, int[][] b) {
        int[][] result = calculatorModel.getResultMatrix();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    public int[][] multiplyTwoMatrices(int[][] a, int[][] b) {
        int [][] result = calculatorModel.getResultMatrix();
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < b[0].length; k++)
                    result[i][j] += a[i][k] * b[k][j];
            }
        }
        return result;
    }

    class calculationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int[][] matrix1 = new int[calculatorView.r1][calculatorView.c1];
            int[][] matrix2 = new int[calculatorView.r2][calculatorView.c2];

            if(e.getSource() == calculatorView.addBtn){
                if(matrix1[0].length != matrix2[0].length && matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length || matrix1.length != matrix2.length){                    calculatorView.displayErrorMessage("cannot add matrices");
                }
                else{
                    try {
                    matrix1 = calculatorView.getFirstMatrix(matrix1[0].length, matrix1.length);
                    matrix2 = calculatorView.getSecondMatrix(matrix2[0].length, matrix2.length);

                    calculatorModel.setResultMatrix(addTwoMatrices(matrix1, matrix2));
                    calculatorView.setCalculationResult(calculatorModel.getResultMatrix());

                } catch (NumberFormatException ex) {
                    calculatorView.displayErrorMessage("Enter the matrix properly.");
                    }
                }
            }
            if(e.getSource() == calculatorView.subBtn){
                if(matrix1[0].length != matrix2[0].length && matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length || matrix1.length != matrix2.length){
                    calculatorView.displayErrorMessage("cannot subtract matrices");
                }
                else{
                    try {
                        matrix1 = calculatorView.getFirstMatrix(matrix1[0].length, matrix1.length);
                        matrix2 = calculatorView.getSecondMatrix(matrix2[0].length, matrix2.length);

                        calculatorModel.setResultMatrix(subTwoMatrices(matrix1, matrix2));
                        calculatorView.setCalculationResult(calculatorModel.getResultMatrix());

                    } catch (NumberFormatException ex) {
                        calculatorView.displayErrorMessage("Enter the matrix properly.");
                    }
                }
            }          
            if(e.getSource() == calculatorView.mulBtn){
                if(matrix2[0].length != matrix1.length){
                    calculatorView.displayErrorMessage("cannot multiply matrices");
                }
                else{
                    try {
                        matrix1 = calculatorView.getFirstMatrix(matrix1[0].length, matrix1.length);
                        matrix2 = calculatorView.getSecondMatrix(matrix2[0].length, matrix2.length);
        
                        calculatorModel.setResultMatrix(multiplyTwoMatrices(matrix1, matrix2));
                        calculatorView.setCalculationResult(calculatorModel.getResultMatrix());
        
                    } catch (NumberFormatException ex) {
                        calculatorView.displayErrorMessage("Enter the matrix properly.");
                    }
                }
            }
        }
    }
}
