package View;

import javax.swing.JFrame;

import Controller.CalculatorController;
import Model.CalculatorModel;

import javax.swing.*;
import java.awt.event.*;

public class SetupView extends JFrame{

    public int r1, c1;
    public int r2, c2;

    JTextField firstRow;
    JTextField firstColumn;
    JTextField secondRow;
    JTextField secondColumn;

    public JButton goBtn = new JButton("go");

    public SetupView(){
        this.setSize(200, 200);
        this.setLocation(350, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel fields = new JPanel();
        firstRow = new JTextField(2);
        fields.add(firstRow);
        firstColumn = new JTextField(2);
        fields.add(firstColumn);
        secondRow = new JTextField(2);
        fields.add(secondRow);
        secondColumn = new JTextField(2);
        fields.add(secondColumn);
        fields.add(goBtn);

        this.add(fields);
        this.setVisible(true);
    
        goBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                r1 = Integer.parseInt(firstRow.getText());
                c1 = Integer.parseInt(firstColumn.getText());
                r2 = Integer.parseInt(secondRow.getText());
                c2 = Integer.parseInt(secondColumn.getText());

                CalculatorModel calculatorModel = new CalculatorModel(r1, c2);
                CalculatorView calculatorView = new CalculatorView(r1, c1, r2, c2);
                CalculatorController calculatorController = new CalculatorController(calculatorView, calculatorModel);
            }
        
        });
    }
}
