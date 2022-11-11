package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class CalculatorView extends JFrame {
    JButton addBtn = new JButton("Add");
    JButton subBtn = new JButton("Subtract");
    JButton mulBtn = new JButton("Multiply");
    public int r1, c1;
    public int r2, c2;
    private final HashMap<String, JTextField> firstMatrixFields = new HashMap<>();
    final private HashMap<String, JTextField> secondMatrixFields = new HashMap<>();
    final private HashMap<String, JTextField> resultMatrixFields = new HashMap<>();

    public CalculatorView(int row, int column) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameSize(row, column));
        this.setLocation(350, 200);
        this.setSize(500, 300);
        this.setTitle("Matrix Calculator");
        this.setResizable(false);
        this.setVisible(true);

        r1 = row;
        c1 = column;
        r2 = row;
        c2 = column;

        setHashmapIndex(firstMatrixFields, row * column);
        setHashmapIndex(secondMatrixFields, row * column);
        setHashmapIndex(resultMatrixFields, row * column);

        //
        JPanel fields = new JPanel();
        fields.add(new JTextField(2));
        fields.add(new JTextField(2));
        fields.add(new JTextField(2));
        fields.add(new JTextField(2));
        //

        JPanel m1 = addFields(row, column, firstMatrixFields);
        JPanel m2 = addFields(row, column, secondMatrixFields);
        JPanel mainPanel = new JPanel();
        JPanel resultJPanel = addFields(row, column, resultMatrixFields);
        JPanel btns = new JPanel(new GridLayout(3,1,10,5));
        mainPanel.add(m1);
        mainPanel.add(m2);
        btns.add(addBtn);
        btns.add(subBtn);
        btns.add(mulBtn);
        mainPanel.add(btns);
        mainPanel.add(resultJPanel);
        this.setLayout(new BorderLayout());
        this.add(fields, "North");
        this.add(mainPanel, "Center");
    }

    public void setHashmapIndex(HashMap<String, JTextField> hashMap, int n) {
        String fieldName = "";
        for (int i = 1; i <= n; i++) {
            fieldName = "";
            fieldName += i;
            JTextField jT = new JTextField(2);
            hashMap.put(fieldName, jT);
        }

    }

    public JPanel addFields(int rows, int columns, HashMap<String, JTextField> hashMap) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, columns));

        int index = 1;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                panel.add(hashMap.get(String.valueOf(index)));
                index++;
            }
        }
        return panel;
    }

    public int[][] getFirstMatrix(int row, int column) {
        int index = 1;
        int[][] array = new int[row][column];
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = Integer.parseInt(firstMatrixFields.get(String.valueOf(index)).getText());
                index++;
            }
        }
        return array;
    }

    public int[][] getSecondMatrix(int row, int column) {
        int index = 1;
        int[][] array = new int[row][column];
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = Integer.parseInt(secondMatrixFields.get(String.valueOf(index)).getText());
                index++;
            }
        }
        return array;
    }

    public void setCalculationResult(int[][] result) {
        int index = 1;
        for (int i = 0; i < result[0].length; i++) {
            for (int j = 0; j < result.length; j++) {
                resultMatrixFields.get(String.valueOf(index)).setText(Integer.toString(result[i][j]));
                index++;
            }
        }
    }

    public void addCalculationListener(ActionListener calculationListener) {
        addBtn.addActionListener(calculationListener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public Dimension frameSize(int r, int c) {
        int width = 80;
        int height = 200;
        switch (r) {
            case (2):
                width += 20;
                break;
            case (3):
                width += 40;
                break;
            case (4):
                width += 60;
                break;
            case (5):
                width += 80;
                break;
            case (6):
                width += 100;
                break;
            case (7):
                width += 120;
                break;
            case (8):
                width += 140;
                break;
            case (9):
                width += 160;
                break;
        }
        switch (c) {
            case (2):
                height += 100;
                break;
            case (3):
                height += 150;
                break;
            case (4):
                height += 250;
                break;
            case (5):
                height += 300;
                break;
            case (6):
                height += 400;
                break;
            case (7):
                height += 450;
                break;
            case (8):
                height += 550;
                break;
            case (9):
                height += 600;
                break;
        }
        return new Dimension(height, width);
    }
}
