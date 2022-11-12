package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class CalculatorView extends JFrame  implements ActionListener{
    public JButton addBtn = new JButton("Add");
    public JButton subBtn = new JButton("Subtract");
    public JButton mulBtn = new JButton("Multiply");
    public int r1, c1;
    public int r2, c2;
    JTextField firstRow;
    JTextField firstColumn;
    JTextField secondRow;
    JTextField secondColumn;
    JPanel m1;
    JPanel m2;
    JPanel resultJPanel;
    private final HashMap<String, JTextField> firstMatrixFields = new HashMap<>();
    final private HashMap<String, JTextField> secondMatrixFields = new HashMap<>();
    final private HashMap<String, JTextField> resultMatrixFields = new HashMap<>();

    public CalculatorView(int row1, int column1, int row2, int column2) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // this.setSize(frameSize(row, column));
        this.setLocation(350, 200);
        this.setSize(500, 300);
        this.setTitle("Matrix Calculator");
        this.setResizable(false);
        this.setVisible(true);

        r1 = row1;
        c1 = column1;
        r2 = row2;
        c2 = column2;

        setHashmapIndex(firstMatrixFields, row1 * column1);
        setHashmapIndex(secondMatrixFields, row2 * column2);
        setHashmapIndex(resultMatrixFields, row1 * column2);

        m1 = addFields(row1, column1, firstMatrixFields);
        m2 = addFields(row2, column2, secondMatrixFields);
        resultJPanel = addFields(row1, column2, resultMatrixFields);

        JPanel btns = new JPanel(new GridLayout(3,1,10,5));
        JPanel mainPanel = new JPanel();
        mainPanel.add(m1);
        mainPanel.add(m2);
        btns.add(addBtn);
        btns.add(subBtn);
        btns.add(mulBtn);
        mainPanel.add(btns);
        mainPanel.add(resultJPanel);
        this.setLayout(new BorderLayout());
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
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.parseInt(firstMatrixFields.get(String.valueOf(index)).getText());
                index++;
            }
        }
        return array;
    }

    public int[][] getSecondMatrix(int row, int column) {
        int index = 1;
        int[][] array = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
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
        subBtn.addActionListener(calculationListener);
        mulBtn.addActionListener(calculationListener);
    }

    public void updateMatrixSizes(){
        r1 = Integer.parseInt(firstRow.getText());
        c1 = Integer.parseInt(firstColumn.getText());
        r2 = Integer.parseInt(secondRow.getText());
        c2 = Integer.parseInt(secondColumn.getText());

        setHashmapIndex(firstMatrixFields, r1 * c1);
        setHashmapIndex(secondMatrixFields, r2 * c2);
        setHashmapIndex(resultMatrixFields, r1 * c2);

        m1 = addFields(r1, c1, firstMatrixFields);
        m2 = addFields(r2, c2, secondMatrixFields);
        resultJPanel = addFields(r1, c2, resultMatrixFields);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
