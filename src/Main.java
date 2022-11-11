import Controller.CalculatorController;
import Model.CalculatorModel;
import View.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel(4, 4);
        CalculatorView calculatorView = new CalculatorView(4, 4);
        CalculatorController calculatorController = new CalculatorController(calculatorView, calculatorModel);
        calculatorView.setVisible(true);
    }
}