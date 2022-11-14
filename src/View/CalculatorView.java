package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CalculatorView extends JFrame {
    public JButton addBtn = new JButton("Add");
    public JButton subBtn = new JButton("Subtract");
    public JButton mulBtn = new JButton("Multiply");
    public int r1, c1;
    public int r2, c2;
    JLabel equals = new JLabel("=");
    JTextField firstRow;
    JTextField firstColumn;
    JTextField secondRow;
    JTextField secondColumn;
    JPanel m1;
    JPanel m2;
    JPanel resultJPanel;
    final private ArrayList<JTextField> firstMatrixFields = new ArrayList<>();
    final private ArrayList<JTextField> secondMatrixFields = new ArrayList<>();
    final private ArrayList<JTextField> resultMatrixFields = new ArrayList<>();

    public CalculatorView(int row, int column) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(350, 200);
        this.setSize(400, 200);
        this.setTitle("Matrix Calculator");
        this.setResizable(false);
        this.setVisible(true);

        r1 = row;
        c1 = column;
        r2 = row;
        c2 = column;

        setArrayListIndex(firstMatrixFields, row * column);
        setArrayListIndex(secondMatrixFields, row * column);
        setArrayListIndex(resultMatrixFields, row * column);

        m1 = addFields(row, column, firstMatrixFields);
        m2 = addFields(row, column, secondMatrixFields);
        resultJPanel = addFields(row, column, resultMatrixFields);

        JPanel btns = new JPanel(new GridLayout(3,1,10,5));
        JPanel mainPanel = new JPanel();
        mainPanel.add(m1);
        mainPanel.add(m2);
        mainPanel.add(equals);
        mainPanel.add(resultJPanel);
        btns.add(addBtn);
        btns.add(subBtn);
        btns.add(mulBtn);

        this.add(btns, "South");
        this.add(mainPanel, "North");
    }

    public void setArrayListIndex(ArrayList<JTextField> ArrayList, int n) {
        for (int i = 0; i <n; i++) {
            JTextField jT = new JTextField(2);
            ArrayList.add(jT);
        }

    }

    public JPanel addFields(int rows, int columns, ArrayList<JTextField> ArrayList) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, columns));

        int index = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                panel.add(ArrayList.get(index));
                index++;
            }
        }
        return panel;
    }

    public int[][] getFirstMatrix(int row, int column) {
        int index = 0;
        int[][] array = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.parseInt(firstMatrixFields.get(index).getText());
                index++;
            }
        }
        return array;
    }

    public int[][] getSecondMatrix(int row, int column) {
        int index = 0;
        int[][] array = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.parseInt(secondMatrixFields.get(index).getText());
                index++;
            }
        }
        return array;
    }

    public void setCalculationResult(int[][] result) {
        int index = 0;
        for (int i = 0; i < result[0].length; i++) {
            for (int j = 0; j < result.length; j++) {
                resultMatrixFields.get(index).setText(Integer.toString(result[i][j]));
                index++;
            }
        }
    }

    public void addCalculationListener(ActionListener calculationListener) {
        addBtn.addActionListener(calculationListener);
        subBtn.addActionListener(calculationListener);
        mulBtn.addActionListener(calculationListener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
