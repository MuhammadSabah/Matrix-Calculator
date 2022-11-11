import Controller.CalculatorController;
import Model.CalculatorModel;
import View.CalculatorView;

public class Main{
    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel(3, 3);
        CalculatorView calculatorView = new CalculatorView(3, 3);
        CalculatorController calculatorController = new CalculatorController(calculatorView, calculatorModel);
        calculatorView.setVisible(true);
    }
}