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

                    calculatorModel.addTwoMatrices(matrix1, matrix2);

                    calculatorView.setCalculationResult(calculatorModel.getMatrixValue());

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

                        calculatorModel.subTwoMatrices(matrix1, matrix2);

                        calculatorView.setCalculationResult(calculatorModel.getMatrixValue());

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
        
                        calculatorModel.multiplyTwoMatrices(matrix1, matrix2);
        
                        calculatorView.setCalculationResult(calculatorModel.getMatrixValue());
        
                    } catch (NumberFormatException ex) {
                        calculatorView.displayErrorMessage("Enter the matrix properly.");
                    }
                }
            }
        }
    }
}
