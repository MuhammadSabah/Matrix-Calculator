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
}
